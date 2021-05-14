package lesson30.ItCompanyStructure;

import lesson30.ItCompanyStructure.entities.Customer;
import lesson30.ItCompanyStructure.entities.Department;
import lesson30.ItCompanyStructure.entities.Employee;
import lesson30.ItCompanyStructure.entities.Project;
import lesson30.ItCompanyStructure.entities.enums.DepartmentType;
import lesson30.ItCompanyStructure.entities.enums.PositionType;
import lesson30.ItCompanyStructure.entityDAO.DepartmentDAO;
import lesson30.ItCompanyStructure.entityDAO.EmployeeDAO;
import lesson30.ItCompanyStructure.entityDAO.ProjectDAO;

import java.util.ArrayList;
import java.util.Collection;

public class Controller<T> {

    // список проектов в которых участвует заданный сотрудник
    public static Collection<Project> projectsByEmployee(Employee employee) {
        return employee.getProjects();
    }

    // список сотрудников из заданного отдела, не участвуюзих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        Department department = DepartmentDAO.getDepartmentByType(departmentType);
        return Utils.employeesWithoutProjectFilter((ArrayList<Employee>) department.getEmployees());
    }

    // список сотрудников не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
       return Utils.employeesWithoutProjectFilter(EmployeeDAO.getEmployees());
    }

    // список подчиненных для заданого руководителя (по всем проектам которыми он руководит)
    public static ArrayList<Employee> employeesByTeamLead(Employee lead) {
        ArrayList<Employee> employeesByTeamLead = new ArrayList<>();

        for (Project project : lead.getProjects()) {
            ArrayList<Employee> employeesByProject = EmployeeDAO.getEmployeesByProject(project);

            for (Employee employee : employeesByProject) {
                if (!employee.equals(lead)) {
                    employeesByTeamLead.add(employee);
                }
            }
        }

        return employeesByTeamLead;
    }

    // список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) {
        ArrayList<Employee> teamLeads = new ArrayList<>();

        for (Project project : employee.getProjects()) {
            ArrayList<Employee> employeesByProject = EmployeeDAO.getEmployeesByProject(project);

            for (Employee em : employeesByProject) {
                if (em.getPosition().equals(PositionType.TEAM_LEAD)) {
                    teamLeads.add(employee);
                }
            }
        }
        return teamLeads;
    }

    // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) {
        ArrayList<Project> projects = ProjectDAO.getProjects();
        ArrayList<Employee> employeesWithSameProjects = new ArrayList<>();
        for (Project project : projects) {
            if (employee.getProjects().contains(project)) {
                employeesWithSameProjects.addAll(EmployeeDAO.getEmployeesByProject(project));
            }
        }
        return employeesWithSameProjects;
    }

    // список проектов, выполняемых для заданного заказчика
    public static ArrayList<Project>projectsByCustomer(Customer customer) {
        ArrayList<Project> projects = ProjectDAO.getProjects();
        ArrayList<Project> projectsForCustomer = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCustomer().equals(customer)) {
                projectsForCustomer.add(project);
            }
        }

        return projectsForCustomer;
    }

    // список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static ArrayList<Employee>employeesByCustomerProjects(Customer customer) {
        ArrayList<Employee> employeesForProjects = new ArrayList<>();
        for (Project project : projectsByCustomer(customer)) {
            employeesForProjects.addAll(EmployeeDAO.getEmployeesByProject(project));
        }
        return employeesForProjects;
    }

}
