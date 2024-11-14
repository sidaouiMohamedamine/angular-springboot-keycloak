package com.sid.employeeManagementSystemBackend.service;

import com.sid.employeeManagementSystemBackend.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee updateEmployee(Long id, Employee employee);
    public ResponseEntity<Void> deleteEmployee(Long id);
    public Integer getEmployeeNumber();

}
