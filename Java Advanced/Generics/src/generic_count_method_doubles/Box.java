package generic_count_method_doubles;

import java.util.LinkedList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> values;

    public Box() {
        this.values = new LinkedList<>();
    }

    void add(T element) {
        this.values.add(element);
    }

    int compare(T element) {
        int result = 0;
        for (int i = 0; i < this.values.size(); i++) {
            T currentElement = this.values.get(i);
            if (currentElement.compareTo(element) > 0) {
                result++;
            }
        }
        return result;
    }

}
