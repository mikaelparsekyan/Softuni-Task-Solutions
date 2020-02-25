package tasks;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static tasks.Queries.GET_PROJECTS;

public class GetEmployeeWithProject extends Task {
    private Scanner scanner;

    public GetEmployeeWithProject(EntityManager manager) {
        super(manager);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = getManager().find(Employee.class, id);

        System.out.println(employee);

        for (Project project : getProjects(employee)) {
            System.out.println(project.getName());
        }

    }

    private List<Project> getProjects(Employee employee) {
        return getManager()
                .createQuery(GET_PROJECTS, Project.class)
                .setParameter("id", employee.getId())
                .getResultList();
    }
}
