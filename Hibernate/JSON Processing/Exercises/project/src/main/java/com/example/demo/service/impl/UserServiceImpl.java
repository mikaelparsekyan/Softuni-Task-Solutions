package com.example.demo.service.impl;

import com.example.demo.constants.FileExportPaths;
import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.UserRepository;
import com.example.demo.data.entiites.Product;
import com.example.demo.data.entiites.User;
import com.example.demo.dtos.product.SoldProductExportDto;
import com.example.demo.dtos.user.UserWithSoldProductsExportDto;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsersToDatabase() {
        String fileText = FileUtil
                .readFile(FileImportPaths.USERS_IMPORT_FILE_PATH);

        List<User> users = gson.fromJson(fileText,
                new TypeToken<List<User>>() {
                }.getType());

        if (users != null) {
            users.forEach(userRepository::saveAndFlush);
        }
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        int usersCount = userRepository.getAllUsersCount();

        long userId = random.nextInt(usersCount) + 1;

        return userRepository.findById(userId);
    }

    @Override
    public void exportAllUsersWithSoldProducts() {
        List<UserWithSoldProductsExportDto> users = userRepository
                .findAll()
                .stream()
                .filter(user ->
                        user.getProducts().stream().filter(product ->
                                product.getBuyer() != null).count() >= 1
                )
                .sorted(this::sortUsers)
                .map(this::mapUsers)
                .collect(Collectors.toList());

        FileUtil.write(FileExportPaths.USERS_WITH_SOLD_PRODUCTS_FILE_PATH,
                gson.toJson(users));
    }

    private UserWithSoldProductsExportDto mapUsers(User user) {
        UserWithSoldProductsExportDto dto = modelMapper
                .map(user, UserWithSoldProductsExportDto.class);

        dto.setProducts(user.getProducts()
                .stream()
                .filter(product -> product.getBuyer() != null)
                .map(this::mapProducts)
                .collect(Collectors.toList()));

        return dto;
    }

    private SoldProductExportDto mapProducts(Product p) {
        SoldProductExportDto mappedDto =
                modelMapper.map(p, SoldProductExportDto.class);
        mappedDto.setFirstName(p.getBuyer().getFirstName());
        mappedDto.setLastName(p.getBuyer().getLastName());
        return mappedDto;
    }

    private int sortUsers(User u1, User u2) {
        int result = 0;
        if (u1.getFirstName() != null && u2.getFirstName() != null) {
            result = u1.getFirstName().compareTo(u2.getFirstName());
        }
        if (result == 0) {
            return u1.getLastName().compareTo(u2.getLastName());
        }
        return result;
    }
}
