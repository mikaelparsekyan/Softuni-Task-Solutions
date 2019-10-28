package studentSystem;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[] input) {
        String command = input[0];
        String name = input[1];
        if (command.equals("Create")) {
            var age = Integer.parseInt(input[2]);
            var grade = Double.parseDouble(input[3]);
            if (!this.repo.containsKey(name)) {
                createStudent(name, age, grade);
            }
        } else if (command.equals("Show")) {
            if (this.repo.containsKey(name)) {
                printStudent(name);
            }
        }
    }

    private void createStudent(String name, int age, double grade) {
        var student = new Student(name, age, grade);
        this.repo.put(name, student);
    }

    private void printStudent(String name) {
        var student = this.repo.get(name);
        String output = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            output += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            output += " Average student.";
        } else {
            output += " Very nice person.";
        }

        System.out.println(output);
    }
}
