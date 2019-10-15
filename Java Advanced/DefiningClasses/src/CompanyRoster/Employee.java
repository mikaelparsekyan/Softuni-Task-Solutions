package CompanyRoster;

public class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position,
                    String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position,
                    String department, String val) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        try {
            int age = Integer.parseInt(val);
            this.age = age;
            this.email = "n/a";
        } catch (Exception e) {
            this.email = val;
            this.age = -1;
        }
    }

    public Employee(String name, double salary, String position,
                    String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name,
                this.salary, this.email, this.age);
    }
}
