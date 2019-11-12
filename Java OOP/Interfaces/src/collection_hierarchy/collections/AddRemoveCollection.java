package collection_hierarchy.collections;

import collection_hierarchy.interfaces.AddRemovable;
import collection_hierarchy.models.Collection;


public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
        super();
    }

    @Override
    public int add(String item) {
        super.getItems().add(0,item);
        return super.getItems().indexOf(item);
    }

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size()-1);
    }
}
