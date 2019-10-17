package Google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private ArrayList<Pokemon> collection = new ArrayList<>();
    private ArrayList<Parent> parents = new ArrayList<>();
    private ArrayList<Child> children = new ArrayList<>();
    private Car car;
    private boolean hasCompany = false;
    private boolean hasCar = false;

    Person(String name){
        this.name = name;
        this.company = new Company();
        this.car = new Car();
    }

    public Company getCompany() {
        return company;
    }

    void setCompany(Company company) {
        this.company = company;
        hasCompany = true;
    }

    public ArrayList<Pokemon> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Pokemon> collection) {
        this.collection = collection;
    }

    ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        hasCar = true;
    }

    public void addParent(Parent p){
        parents.add(p);
    }

    public void addPokemon(Pokemon p){
        collection.add(p);
    }

    public void addChild(Child p){
        children.add(p);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "\n");
        if(hasCompany) {
            sb.append("Company: " + "\n" + company.getName() + " " + company.getDepartment() + String.format(" %.2f\n", company.getSalary()));
        } else{
            sb.append("Company:\n");
        }
        if(hasCar) {
            sb.append("Car:" + "\n" + car.getModel() + " " + car.getSpeed() + "\n");
        } else{
            sb.append("Car:\n");
        }
        sb.append("Pokemon:\n");
        for(Pokemon poke: collection){
            sb.append(poke.getName() + " " + poke.getType() + "\n");
        }
        sb.append("Parents:\n");
        for(Parent p: parents){
            sb.append(p.getName() + " " + p.getBirthday() + "\n");
        }
        sb.append("Children:\n");
        for(Child p: children){
            sb.append(p.getName() + " " + p.getBirthday() + "\n");
        }
        return sb.toString();
    }
}