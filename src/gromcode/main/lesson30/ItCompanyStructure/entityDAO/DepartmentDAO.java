package gromcode.main.lesson30.ItCompanyStructure.entityDAO;

import gromcode.main.lesson30.ItCompanyStructure.entities.Department;
import gromcode.main.lesson30.ItCompanyStructure.entities.enums.DepartmentType;

import java.util.ArrayList;

public class DepartmentDAO {
    private static ArrayList<Department> departments = new ArrayList<>();

    public DepartmentDAO() {
        Department management = new Department(DepartmentType.MANAGEMENT);
        Department analysts = new Department(DepartmentType.ANALYTICS);
        Department designers = new Department(DepartmentType.DESIGNING);
        Department developers = new Department(DepartmentType.DEVELOPMENT);
        Department finances = new Department(DepartmentType.FINANCE);
        Department information = new Department(DepartmentType.INFORMATION);
        Department sales = new Department(DepartmentType.SALES);
        Department support = new Department(DepartmentType.SUPPORT);

        departments.add(management);
        departments.add(analysts);
        departments.add(designers);
        departments.add(developers);
        departments.add(finances);
        departments.add(information);
        departments.add(sales);
        departments.add(support);

    }

    public static Department getDepartmentByIndex(int index) {
        return DepartmentDAO.getDepartments().get(index);
    }

    public static Department getDepartmentByType(DepartmentType type) throws Exception {
        for (Department department: DepartmentDAO.getDepartments()) {
            if (department.getType().equals(type)) {
                return department;
            }
        };

        throw new Exception("Departament is not defined");
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }
}
