package com.devent.cache.devent.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public CacheStore<Employee> employeeCache;

    public Employee getEmployeeById(String empId) {
        //Search Employee record in Cache
        Employee cachedEmployee = employeeCache.get(empId);
        if(cachedEmployee != null) {
            System.out.println("Cache hit for : " + cachedEmployee.getEmpId());
            return cachedEmployee;
        }

        //Fetch Employee details from backend service
        Employee employee = employeeRepository.getEmployeeById(empId);

        //Store Employee record in Cache
        employeeCache.add(empId, employee);

        return employee;
    }
}
