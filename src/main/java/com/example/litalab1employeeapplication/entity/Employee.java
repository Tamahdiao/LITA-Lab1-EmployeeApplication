package com.example.litalab1employeeapplication.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstName;
    private String lastName;

    private String password;
    private String roles;

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

    @OneToMany(mappedBy="employee")
    private Set<Contribution> contribution;

    public Employee() {}

    public Employee(String username, String role) {

        this.username = username;
        this.roles = role;
    }


    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    public String getRoles() {
        return this.roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String role) {
        this.roles = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.username, employee.username)
                && Objects.equals(this.roles, employee.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.roles);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.username + '\'' + ", role='" + this.roles + '\'' + '}';
    }

}
