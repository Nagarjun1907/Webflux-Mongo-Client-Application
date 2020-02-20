package com.springwebflux.demo.WebfluxMongoClientDemo;


import java.util.Date;

public class EmployeeEvents {
    private Employee employee;

    public EmployeeEvents() {
    }

    private Date date;

    public EmployeeEvents(Employee employee, Date date) {
        this.employee = employee;
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeEvents{" +
                "employee=" + employee +
                ", date=" + date +
                '}';
    }
}
