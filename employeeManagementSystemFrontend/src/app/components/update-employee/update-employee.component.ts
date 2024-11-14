import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent {
  id: number;  // Variable to store the ID of the employee to be updated
  employee: Employee = new Employee();

  // Inject dependencies: EmployeeService for API calls, ActivatedRoute to get route parameters, Router for navigation
  constructor(
      private employeeService: EmployeeService, 
      private activatedRoute: ActivatedRoute, 
      private router: Router
  ) { }

  ngOnInit(): void {
      // On component initialization, get the employee ID from the route
      this.id = this.activatedRoute.snapshot.params['id'];  // Capture the employee ID from the URL
      this.getEmployeeById();  // Call method to fetch the employee details by ID
  }

  // Method to fetch employee data by ID
  getEmployeeById(): void {
      this.employeeService.getEmployeeById(this.id).subscribe(data => {
          this.employee = data;  // Populate the employee object with data fetched from the API
          console.log(this.employee);  // Log the employee data for debugging purposes
      }, error => console.log("Error fetching employee details"));  // Handle errors while fetching the data
  }

  // Method to handle the form submission
  onSubmit(): void {
      // Call the service method to update the employee data in the database
      this.employeeService.updateEmployee(this.id, this.employee).subscribe(
          data => {
              console.log(data);  // Log the response from the update operation
              this.employee = new Employee();  // Reset the employee object after successful update
              this.router.navigate(['/employees']);  // Navigate back to the employee list page
          },
          error => console.log(error)  // Log errors if the update operation fails
      );
  }


}
