package com.sid.employeeManagementSystemBackend.repository;


import com.sid.employeeManagementSystemBackend.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
}
