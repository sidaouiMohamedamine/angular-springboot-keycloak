package com.sid.employeeManagementSystemBackend.service;


import com.sid.employeeManagementSystemBackend.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public Department addDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department getDepartmentById(Long id);
    public Department updateDepartment(Long id, Department department);
    public String deleteDepartment(Long id);
}
