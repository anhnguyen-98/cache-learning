package com.devent.cache.devent.cache;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeRepository {

    private Map<String, Employee> database = new HashMap<>();

    @PostConstruct
    public void initData() {
        Employee e1 = new Employee("Mahesh", 20, "Finance", "100");
        Employee e2 = new Employee("Rohan", 21, "IT", "101");
        Employee e3 = new Employee("Sohan", 22, "Admin", "102");

        database.put("100", e1);
        database.put("101", e2);
        database.put("102", e3);
    }

    public Employee getEmployeeById(String empId) {
        System.out.println("Database hit for " + empId);
        return database.get(empId);
    }

    public void updateEmployeeById(String empId, Employee employee) {
        System.out.println("Update employee " + empId);
        database.remove(empId);
        database.put(empId, employee);
    }

}
