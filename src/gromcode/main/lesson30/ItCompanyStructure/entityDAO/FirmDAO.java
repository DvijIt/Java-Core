package gromcode.main.lesson30.ItCompanyStructure.entityDAO;

import gromcode.main.lesson30.ItCompanyStructure.entities.Customer;
import gromcode.main.lesson30.ItCompanyStructure.entities.Department;
import gromcode.main.lesson30.ItCompanyStructure.entities.Firm;

import java.util.Collection;
import java.util.Date;

public class FirmDAO {
    private static Firm firm;

    public FirmDAO(Collection<Department> departments, Collection<Customer> customers) {
        firm = new Firm(new Date(), departments, customers);
    }

    public static Firm getFirm() {
        return firm;
    }
}
