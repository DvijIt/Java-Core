package gromcode.main.lesson30.ItCompanyStructure.entities;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private Collection<Department> departments;
    private Collection<Customer> customers;

    public Firm(Date dateFounded, Collection<Department> departments, Collection<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
