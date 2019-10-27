package stackIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StackIterator<T> implements Iterable<T> {
    private List<T> data;

    public StackIterator() {
        this.data = new LinkedList<>();
    }

    public T pop() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("No elements");
        } else {
            T e = this.data.get(0);
            this.data.remove(e);
            return e;
        }
    }

    public void push(T e) {
        this.data.add(0,e);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIteratorClass();
    }

    private class StackIteratorClass implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index >= 0 && index < data.size();
        }

        @Override
        public T next() {
            return data.get(index++);
        }
    }
}
