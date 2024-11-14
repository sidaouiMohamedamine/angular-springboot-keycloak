import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent {
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, private router:Router) {}

  // Method that is called when the form is submitted
  onSubmit(){
    this.employeeService.addEmployee(this.employee).subscribe(data=>{
     console.log('data',this.employee);
     this.router.navigate(['/employees'])
   },
     error=>console.log('erreur')
     )
 }
  // Method to check if the form is valid (can be used to disable the submit button)
  employeeFormValid(): boolean {
    return !!(
      this.employee.firstname &&
      this.employee.lastname &&
      this.employee.email &&
      this.employee.birthDate &&
      this.employee.phoneNumber &&
      this.employee.address &&
      this.employee.salary
    );
  }


}

