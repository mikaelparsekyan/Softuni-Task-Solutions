package FamilyTree;


import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parents;
    private List<Person> child;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChild() {
        return child;
    }
}
