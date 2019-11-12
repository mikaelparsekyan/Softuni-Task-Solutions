package collection_hierarchy.models;

import java.util.LinkedList;
import java.util.List;

public abstract class Collection {
    private int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new LinkedList<>();
    }

    public List<String> getItems() {
        return items;
    }
}
