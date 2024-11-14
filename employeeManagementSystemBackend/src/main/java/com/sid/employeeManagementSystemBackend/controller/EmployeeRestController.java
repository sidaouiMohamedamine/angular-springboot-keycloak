package com.sid.employeeManagementSystemBackend.controller;


import com.sid.employeeManagementSystemBackend.entity.Employee;
import com.sid.employeeManagementSystemBackend.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/employee/")
public class EmployeeRestController {

        @Autowired
        private EmployeeServiceImpl employeeService;
        @PostMapping("addEmployee")
        public Employee addEmployee(@RequestBody Employee employee){
            return employeeService.addEmployee(employee);

        }
        @GetMapping("getAllEmployee")
        public List<Employee> getAllEmployee(){
            return employeeService.getAllEmployee();
        }
        @GetMapping("getEmployeeById/{id}")
        public Employee getEmployeeById(@PathVariable("id") Long id){
                return employeeService.getEmployeeById(id);
        }

        @PutMapping("updateEmployee/{id}")
        public Employee updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
                return  employeeService.updateEmployee(id,employee);
        }
        @DeleteMapping("deleteEmployee/{id}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
                return employeeService.deleteEmployee(id);
        }

        @GetMapping("getEmployeeNumber")
        public Integer getEmployeeNumber(){
                return employeeService.getEmployeeNumber();
        }




}
