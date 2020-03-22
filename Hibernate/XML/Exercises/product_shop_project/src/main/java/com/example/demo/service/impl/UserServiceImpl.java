package com.example.demo.service.impl;

import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.UserRepository;
import com.example.demo.data.entiites.User;
import com.example.demo.dtos.user.UsersImportDto;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsersToDatabase() {
        String fileXml = FileUtil.readFile(FileImportPaths.USERS_IMPORT_FILE_PATH);


        UsersImportDto usersImportDto = XmlParser.deserialize(fileXml,
                UsersImportDto.class);

        usersImportDto.getUsers().forEach(userRepository::saveAndFlush);

        setFriendsToEachUser();
    }

    private void setFriendsToEachUser() {
        userRepository.findAll()
                .forEach(user -> {
                    user.setFriends(getRandomUsers());
                    userRepository.saveAndFlush(user);
                });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        int usersCount = userRepository.getAllUsersCount();

        long userId = random.nextInt(usersCount) + 1;

        return userRepository.findById(userId);
    }

    @Override
    public Set<User> getRandomUsers() {
        Random random = new Random();
        Set<User> users = new HashSet<>();
        int usersCount = userRepository.getAllUsersCount();

        for (int i = 0; i < 2; i++) {
            long userId = random.nextInt(usersCount) + 1;
            users.add(userRepository.findById(userId));
        }
        return users;
    }
}
