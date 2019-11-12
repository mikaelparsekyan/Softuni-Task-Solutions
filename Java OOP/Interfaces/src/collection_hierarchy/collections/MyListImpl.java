package collection_hierarchy.collections;

import collection_hierarchy.interfaces.MyList;
import collection_hierarchy.models.Collection;

public class MyListImpl extends Collection implements MyList {

    public MyListImpl() {
        super();
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return super.getItems().indexOf(item);
    }
}
