package com.sid.employeeManagementSystemBackend.service;

import com.sid.employeeManagementSystemBackend.entity.Contract;

import java.util.List;

public interface IContractService {
    public Contract addContract(Contract contract);
    public List<Contract> getAllContract();
    public Contract getContractById(Long id);
    public Contract updateContract(Long id, Contract contract);
    public String deleteContract(Long id);



}
