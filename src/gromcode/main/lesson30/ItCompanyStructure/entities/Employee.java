package gromcode.main.lesson30.ItCompanyStructure.entities;

import gromcode.main.lesson30.ItCompanyStructure.entities.enums.PositionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private PositionType position;
    private Department department;
    private Collection<Project> projects;

    public Employee(String firstName, String lastName, Date dateHired, PositionType position, Department department, Collection<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    public Employee(String firstName, PositionType position, Department department) {
        this.firstName = firstName;
        this.position = position;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int compareTo(Employee o) {
        return this.lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}
