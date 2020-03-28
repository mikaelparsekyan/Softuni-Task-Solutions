package alararestaurant.service;

import alararestaurant.domain.entities.Item;

public interface ItemService {

    Boolean itemsAreImported();

    String readItemsJsonFile();

    String importItems(String items);

    Item findItemByName(String name);
}
