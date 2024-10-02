package com.devent.cache.devent.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/airports"))
@RequiredArgsConstructor
public class AirportController {

    public final AirportService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getEmployee(@PathVariable(name = "id") String id) {
        Airport employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

}
