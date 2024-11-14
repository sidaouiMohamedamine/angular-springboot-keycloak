package com.sid.employeeManagementSystemBackend.controller;


import com.sid.employeeManagementSystemBackend.entity.Contract;
import com.sid.employeeManagementSystemBackend.service.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contract/")
public class ContractRestController {

            @Autowired
            private ContractServiceImpl contractService;

            @PostMapping("addContract")
            public Contract addContract(@RequestBody Contract contract){
                return  contractService.addContract(contract);
            }
            @GetMapping("getAllContract")
            public List<Contract> getAllContract(){
                return contractService.getAllContract();
            }
            @GetMapping("getContractById/{id}")
            public Contract getContractById(@PathVariable("id") Long id){
                return contractService.getContractById(id);
            }

            @PutMapping("updateContract/{id}")
            public Contract updateContract(@PathVariable("id") Long id,@RequestBody Contract contract){
                return contractService.updateContract(id,contract);
            }
            @DeleteMapping("deleteContract/{id}")
             public String deleteContract (@PathVariable("id") Long id) {
                return contractService.deleteContract(id);
            }













}
