package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departments = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            Employee employee = null;
            String name = elements[0];
            double salary = Double.parseDouble(elements[1]);
            String position = elements[2];
            String departmentName = elements[3];
            if (elements.length == 6) {
                String email = elements[4];
                int age = Integer.parseInt(elements[5]);
                employee = new Employee(name, salary, position,
                        departmentName, email, age);
            } else if (elements.length == 5) {
                String val = elements[4];
                employee = new Employee(name, salary, position,
                        departmentName, val);
            } else if (elements.length == 4) {
                employee = new Employee(name, salary, position,
                        departmentName);
            }
            Department department;
            List<Employee> employees;
            if (departments.containsKey(departmentName)) {
                department = departments.get(departmentName);
                employees = department.getEmployees();
                employees.add(employee);
            } else {
                department = new Department(departmentName);
                employees = new ArrayList<>();
                employees.add(employee);
            }
            department.setEmployees(employees);
            departments.put(departmentName, department);
        }
        List<Employee> employeeList = departments.entrySet().stream()
                .sorted((emp1, emp2) -> {
                    double salary1 = emp1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    double salary2 = emp2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    return Double.compare(salary2, salary1);
                })
                .map(emp -> emp.getValue().getEmployees())
                .findFirst().orElse(null);

        System.out.printf("Highest Average Salary: %s%n", employeeList.get(0).department);

        employeeList.stream().sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                .forEach(emp -> {
                    System.out.println(emp.toString());
                });

    }

}
