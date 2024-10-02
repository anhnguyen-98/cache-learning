package com.devent.cache.devent.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final CacheStore<Employee> employeeCache;

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
