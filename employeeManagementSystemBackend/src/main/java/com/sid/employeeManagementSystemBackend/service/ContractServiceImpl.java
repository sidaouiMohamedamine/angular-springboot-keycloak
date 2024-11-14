package com.sid.employeeManagementSystemBackend.service;


import com.sid.employeeManagementSystemBackend.entity.Contract;
import com.sid.employeeManagementSystemBackend.entity.Department;
import com.sid.employeeManagementSystemBackend.exception.NotFoundException;
import com.sid.employeeManagementSystemBackend.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService{

    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Contract Not Found"));
        return contract;
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Contract Not Found"));
        if (existingContract != null) {
            existingContract.setContractStartDate(contract.getContractStartDate());
            existingContract.setContractEndDate(contract.getContractEndDate());
            existingContract.setType(contract.getType());
            existingContract.setEmployeeList(contract.getEmployeeList());


            return contractRepository.save(existingContract);
        } else {
            return null;
        }
    }

    @Override
    public String deleteContract(Long id) {

        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            return "Contract with Id " + id + " has been deleted successfully.";
        } else {
            return "Contract with Id " + id + " not found.";
        }
    }




}
