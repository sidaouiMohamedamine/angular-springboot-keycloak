package com.sid.employeeManagementSystemBackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Contract_Table")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date ContractStartDate;
    private Date ContractEndDate;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @Enumerated(EnumType.STRING)
    private Type type;
}
