package collection_hierarchy.collections;

import collection_hierarchy.interfaces.Addable;
import collection_hierarchy.models.Collection;


public class AddCollection extends Collection implements Addable {


    public AddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return super.getItems().indexOf(item);
    }
}
