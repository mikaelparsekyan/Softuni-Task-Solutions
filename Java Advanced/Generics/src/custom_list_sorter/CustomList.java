package custom_list_sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable> {
    private List<T> data;

    CustomList() {
        this.data = new ArrayList<>();
    }

    void add(T element) {
        this.data.add(element);
    }

    T remove(int index) {
        return this.data.remove(index);
    }

    boolean contains(T element) {
        return this.data.contains(element);
    }

    private boolean contains(int i) {
        return i >= 0 && i < this.data.size();
    }

    void swap(int i1, int i2) {
        if (this.contains(i1) && this.contains(i2)) {
            T val1 = this.data.get(i1);
            T val2 = this.data.get(i2);
            this.data.set(i1, val2);
            this.data.set(i2, val1);
        }
    }

    int countGraterThan(T e) {
        int counter = 0;
        for (int i = 0; i < this.data.size(); i++) {
            T element = this.data.get(i);
            if (e.compareTo(element) < 0) {
                counter++;
            }
        }
        return counter;
    }

    T getMax() {
        return this.data.stream().max(Comparable::compareTo).get();
    }

    T getMin() {
        return this.data.stream().min(Comparable::compareTo).get();
    }


    void sort() {
        this.data = this.data.stream()
                .sorted(Comparable::compareTo)
                .collect(Collectors.toList());
    }

    void print() {
        for (T val : this.data) {
            System.out.println(val);
        }

    }
}
