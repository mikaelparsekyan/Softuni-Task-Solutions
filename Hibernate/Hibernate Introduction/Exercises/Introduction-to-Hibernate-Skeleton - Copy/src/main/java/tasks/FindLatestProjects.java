package tasks;

import entities.Project;

import javax.persistence.EntityManager;

import java.util.List;

import static tasks.Queries.GET_LAST_PROJECTS;

public class FindLatestProjects extends Task {
    public FindLatestProjects(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Project> projects = getManager()
                .createQuery(GET_LAST_PROJECTS, Project.class)
                .setMaxResults(10)
                .getResultList();

        printProjects(projects);

    }

    private void printProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.printf("Project name: %s%n",project.getName());
            System.out.printf("    Project Description: %s%n",project.getDescription());
            System.out.printf("    Project Start Date: %s%n",project.getStartDate().toString());
            if(project.getEndDate() != null) {
                System.out.printf("    Project End Date: %s%n", project.getEndDate().toString());
            } else {
                System.out.println("    Project End Date: null");
            }
        }
    }
}
