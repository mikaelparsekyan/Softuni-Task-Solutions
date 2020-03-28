package alararestaurant.service;

import alararestaurant.constants.FileImportPaths;
import alararestaurant.domain.dtos.ItemsImportDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final FileUtil fileUtil;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final ValidationUtil validationUtil;
    @Autowired
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() {
        return fileUtil.readFile(FileImportPaths.ITEMS_IMPORT_PATH);
    }

    @Override
    public String importItems(String items) {
        StringBuilder result = new StringBuilder();

        LinkedList<ItemsImportDto> itemList = gson.fromJson(items,
                new TypeToken<LinkedList<ItemsImportDto>>() {
                }.getType());

        for (ItemsImportDto item : itemList) {
            Item mappedItem = modelMapper.map(item, Item.class);
            mappedItem.setPrice(BigDecimal.valueOf(item.getPrice().doubleValue()));
            Category category = categoryService.getCategoryByName(item.getCategory());

            if (category == null) {
                category = new Category();
                category.setName(item.getCategory());
            }

            if (findItemByName(mappedItem.getName()) == null) {
                if (validationUtil.isValid(mappedItem) &&
                        validationUtil.isValid(category)) {

                    mappedItem.setCategory(category);
                    itemRepository.saveAndFlush(mappedItem);

                    result.append(String.format(
                            "Record %s successfully imported.", item.getName()));
                } else {
                    result.append("Invalid data format");
                }
            } else {
                result.append("Already in DB!");
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

    @Override
    public Item findItemByName(String name) {
        return itemRepository.findByName(name);
    }
}
