package com.sid.employeeManagementSystemBackend.repository;


import com.sid.employeeManagementSystemBackend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {


}
