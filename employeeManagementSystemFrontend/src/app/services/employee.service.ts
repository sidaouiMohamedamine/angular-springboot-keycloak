import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../models/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = 'http://localhost:8081/api/employee';  // URL of the API to add an employee
  constructor(private http: HttpClient) {}

  // Method to add a new employee
  addEmployee(employee: Employee): Observable<Object> {
       return  this.http.post(`${this.apiUrl}/addEmployee`,employee);
 
  }


  getAllEmployee():Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiUrl}/getAllEmployee`)
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.http.get<Employee>(`${this.apiUrl}/getEmployeeById/${id}`)
  }


  updateEmployee(id:number,employee:Employee):Observable<Object>{
     return this.http.put(`${this.apiUrl}/updateEmployee/${id}`,employee);
  }
  deleteEmployee(id:number):Observable<Object>{
    return this.http.delete(`${this.apiUrl}/deleteEmployee/${id}`);

  }



}
