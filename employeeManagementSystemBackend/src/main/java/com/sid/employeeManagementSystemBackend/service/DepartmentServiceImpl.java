package com.sid.employeeManagementSystemBackend.service;


import com.sid.employeeManagementSystemBackend.entity.Department;
import com.sid.employeeManagementSystemBackend.entity.Team;
import com.sid.employeeManagementSystemBackend.exception.NotFoundException;
import com.sid.employeeManagementSystemBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department addDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Departement Not Found"));

        return department;

    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartement = departmentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Department Not Found"));
        if (existingDepartement != null) {
            existingDepartement.setName(department.getName());
            existingDepartement.setDescription(department.getDescription());
            existingDepartement.setEmployeeList(department.getEmployeeList());

            return departmentRepository.save(existingDepartement);
        } else {
            return null;
        }
    }

    @Override
    public String deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return "Departement with Id " + id + " has been deleted successfully.";
        } else {
            return "Departement with Id " + id + " not found.";
        }


    }
}
