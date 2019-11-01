package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private int getRandomIndex(){
        Random random = new Random();
        return random.nextInt((this.size()-1) + 1);
    }
    public T getRandomElement() {
        T element = this.get(getRandomIndex());
        this.remove(element);
        return element;
    }
}
