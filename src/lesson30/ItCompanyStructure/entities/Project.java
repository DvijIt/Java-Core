package lesson30.ItCompanyStructure.entities;

public class Project {
    private String name;
    private Customer customer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }
}
