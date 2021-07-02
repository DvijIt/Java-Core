package gromcode.main.lesson30.ItCompanyStructure.entityDAO;

import gromcode.main.lesson30.ItCompanyStructure.entities.Project;

import java.util.ArrayList;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
        Project project1 = new Project("project0", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("project1", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("project2", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("project3", CustomerDAO.getCustomers().get(3));
        Project project5 = new Project("project4", CustomerDAO.getCustomers().get(4));

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);

    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
