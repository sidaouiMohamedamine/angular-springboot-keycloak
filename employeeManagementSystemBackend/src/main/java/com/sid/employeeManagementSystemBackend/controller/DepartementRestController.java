package com.sid.employeeManagementSystemBackend.controller;


import com.sid.employeeManagementSystemBackend.entity.Department;
import com.sid.employeeManagementSystemBackend.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department/")
public class DepartementRestController {

    @Autowired
    private DepartmentServiceImpl departmentService;


    @PostMapping("addDepartment")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("getAllDepartment")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("getDepartmentById/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }
    @PutMapping("updateDepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,@RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        return departmentService.deleteDepartment(id);
    }






}
