package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private static int id = 0;

    public Repository() {
        this.data = new HashMap<>();
    }

    public void add(Person p) {
        this.data.put(id, p);
        id++;
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person p) {
        if (this.data.containsKey(id)) {
            this.data.put(id, p);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        this.data.remove(id);
        if (this.data.containsKey(id)) {
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.data.size();
    }
}
