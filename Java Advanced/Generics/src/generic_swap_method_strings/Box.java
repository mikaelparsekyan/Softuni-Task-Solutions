package generic_swap_method_strings;

import java.util.LinkedList;
import java.util.List;

public class Box<T> {
    List<T> data;

    public Box() {
        this.data = new LinkedList<>();
    }

    void addValue(T val) {
        this.data.add(val);
    }

    public List<T> getData() {
        return data;
    }

    void swap(int i1, int i2) {
        if (isInBounds(i1) && isInBounds(i2)) {
            T val1 = this.data.get(i1);
            T val2 = this.data.get(i2);
            this.data.set(i1,val2);
            this.data.set(i2,val1);
        }
    }

    private boolean isInBounds(int i) {
        return i >= 0 && i < this.data.size();
    }
}
