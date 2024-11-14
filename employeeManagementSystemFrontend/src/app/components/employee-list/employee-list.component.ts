import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {
  employee:Employee[]

  constructor(private employeeService:EmployeeService,private router:Router) { }

  ngOnInit(): void {
    this.getallEmloyee()
  }
   getallEmloyee(){
        this.employeeService.getAllEmployee().subscribe(data=>{
          this.employee=data;
          console.log(data)
        })
   }
   
   updateEmployee(id:number){
    this.router.navigate(['/update-employee',id])
  }
  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      console.log(data)
     
       window.location.reload();

    })
}


}
