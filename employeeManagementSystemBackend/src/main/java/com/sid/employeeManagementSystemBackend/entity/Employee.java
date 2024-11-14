package com.sid.employeeManagementSystemBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee_table")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "employeeFirstName")
        private String firstname;
        @Column(name = "employeeLastName")
        private String lastname;
        private String email;
        private Date birthDate;
        private String phoneNumber;
        private String address;
        private Double salary;

        @ManyToOne
        @JoinColumn(name = "team_id")
        private Team team;

        @ManyToOne
        @JoinColumn(name= "department_id")
        private Department department;

        @ManyToOne
        @JoinColumn(name = "contract_id")
        private Contract contract;

        @Enumerated(EnumType.STRING)
        private Level level;












}
