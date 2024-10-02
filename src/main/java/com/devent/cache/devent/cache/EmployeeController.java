package com.devent.cache.devent.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/employees"))
@RequiredArgsConstructor
public class EmployeeController {

    public final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") String id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

}
