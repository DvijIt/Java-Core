package lesson30.ItCompanyStructure;

import lesson30.ItCompanyStructure.entities.Employee;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Employee> employeesWithoutProjectFilter(ArrayList<Employee> employees) {
        ArrayList<Employee> employeesFiltered = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().isEmpty()) {
                employeesFiltered.add(employee);
            }
        }
        return employeesFiltered;
    }

}
