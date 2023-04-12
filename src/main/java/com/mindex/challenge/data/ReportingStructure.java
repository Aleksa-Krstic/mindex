package com.mindex.challenge.data;


// ReportingStructure class with necessary attribute as in readme.
public class ReportingStructure {

    private Employee employee;

    private int numberOfReports;

    public ReportingStructure() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

}
