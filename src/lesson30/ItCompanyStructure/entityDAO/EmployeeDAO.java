package lesson30.ItCompanyStructure.entityDAO;

import lesson30.ItCompanyStructure.entities.Employee;
import lesson30.ItCompanyStructure.entities.Project;
import lesson30.ItCompanyStructure.entities.enums.PositionType;

import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDAO() {
        Employee employee1 = new Employee("employee1", PositionType.TEAM_LEAD, DepartmentDAO.getDepartmentByIndex(0));
        Employee employee2 = new Employee("employee2", PositionType.ANALYST, DepartmentDAO.getDepartmentByIndex(1));
        Employee employee3 = new Employee("employee3", PositionType.FINANCE, DepartmentDAO.getDepartmentByIndex(0));
        Employee employee4 = new Employee("employee4", PositionType.MANAGER, DepartmentDAO.getDepartmentByIndex(0));
        Employee employee5 = new Employee("employee5", PositionType.DEVELOPER, DepartmentDAO.getDepartmentByIndex(0));
        Employee employee6 = new Employee("employee6", PositionType.MANAGER, DepartmentDAO.getDepartmentByIndex(1));
        Employee employee7 = new Employee("employee7", PositionType.TEAM_LEAD, DepartmentDAO.getDepartmentByIndex(1));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);

        employee1.getProjects().add(ProjectDAO.getProjects().get(0));
        employee1.getProjects().add(ProjectDAO.getProjects().get(1));
        employee2.getProjects().add(ProjectDAO.getProjects().get(2));
        employee2.getProjects().add(ProjectDAO.getProjects().get(5));
        employee3.getProjects().add(ProjectDAO.getProjects().get(3));
        employee4.getProjects().add(ProjectDAO.getProjects().get(4));
        employee5.getProjects().add(ProjectDAO.getProjects().get(5));
        employee6.getProjects().add(ProjectDAO.getProjects().get(1));

        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployeeByIndex(0));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployeeByIndex(1));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployeeByIndex(2));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployeeByIndex(3));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployeeByIndex(4));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployeeByIndex(5));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployeeByIndex(6));

    }

    public static Employee getEmployeeByIndex(int index) {
        return EmployeeDAO.getEmployees().get(index);
    }

    public static ArrayList<Employee> getEmployeesByProject(Project project) {
        ArrayList<Employee> employeesByProject = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().contains(project)) {
                employeesByProject.add(employee);
            };
        }
        return employeesByProject;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
