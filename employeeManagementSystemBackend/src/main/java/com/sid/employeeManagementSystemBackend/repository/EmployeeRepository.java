package com.sid.employeeManagementSystemBackend.repository;


import com.sid.employeeManagementSystemBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        @Query("select e from Employee e where e.address=:address")
        List<Employee> getEmployeeByAdress(@Param("address")String address);

        /************************deuxiéme méthode    ***************/
        List<Employee> findEmployeeBySalary(Double salary);
        boolean existsEmployeeByLastname(String lastName);

        @Query("select count(e) from Employee e")
        Integer getEmployeeNumber();

}
