package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private List<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public void add(Astronaut astronaut){
        this.data.add(astronaut);
        if (this.data.size() > this.capacity){
            this.data.remove(this.data.size() - 1);
        }
    }

    public boolean remove(String name){
        Astronaut astronaut = null;
        for (Astronaut person : this.data) {
            if (person.getName().equals(name)){
                astronaut = person;
                break;
            }
        }
        if (astronaut != null) {
            this.data.remove(astronaut);
            return true;
        } else {
            return false;
        }
    }


    //FIXME Can produce a NullPointerException if this.data is empty when this method is invoked
    public Astronaut getOldestAstronaut(){
        Astronaut astronaut = null;
        int oldestAge = Integer.MIN_VALUE;
        for (Astronaut person : this.data) {
            if (person.getAge() > oldestAge){
                astronaut = person;
            }
        }
        return astronaut;
    }

    //FIXME Can produce a NullPointerException if this.data doesn't contain the astronaut
    public Astronaut getAstronaut(String name){
        Astronaut astronaut = null;
        for (Astronaut person : this.data) {
            if (person.getName().equals(name)){
                astronaut = person;
                break;
            }
        }
        return astronaut;
    }


    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:", this.name));
        this.data.forEach(a -> sb.append("Astronaut: ").append(a.toString()).append(System.lineSeparator()));
        return sb.toString();
    }


}