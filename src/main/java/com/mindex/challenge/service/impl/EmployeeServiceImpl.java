package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }


    // Method to get reporting structure
    @Override
    public ReportingStructure getReportingStructure(Employee employee) {

        ReportingStructure reports = new ReportingStructure();
        reports.setEmployee(employee);

        int total = 0;
        Queue<Employee> queue = new LinkedList<>();

        // Add the employee for whom we are calculating the ReportingStructure for
        queue.add(employee);

        // If not empty
        while (!queue.isEmpty()) {
            // Poll the queue (get and remove an element)
            List<Employee> e;
            e = queue.poll().getDirectReports();
            // If there are reports present, add them to the queue
           if (e != null && !e.isEmpty()) {
               queue.addAll(e);
               // Add the count of reports for the current employee
               total += e.size();
           }
        }

        reports.setNumberOfReports(total);

        return reports;
    }
}
