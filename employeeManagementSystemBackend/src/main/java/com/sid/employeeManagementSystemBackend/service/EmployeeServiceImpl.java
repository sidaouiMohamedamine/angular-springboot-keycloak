package com.sid.employeeManagementSystemBackend.service;

import com.sid.employeeManagementSystemBackend.entity.Employee;
import com.sid.employeeManagementSystemBackend.entity.Team;
import com.sid.employeeManagementSystemBackend.exception.NotFoundException;
import com.sid.employeeManagementSystemBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Employee Not Found"));

        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Team Not Found"));
        if (existingEmployee != null) {

            existingEmployee.setFirstname(employee.getFirstname());
            existingEmployee.setLastname(employee.getLastname());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setBirthDate(employee.getBirthDate());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setSalary(employee.getSalary());

            existingEmployee.setTeam(employee.getTeam());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setContract(employee.getContract());
            existingEmployee.setLevel(employee.getLevel());

            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    public Integer getEmployeeNumber(){
        return employeeRepository.getEmployeeNumber();
    }



}
