package com.sid.employeeManagementSystemBackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Team_Table")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Team_name")
    private String name;

    @Column(name = "Team_tasks")
    private String description;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}
