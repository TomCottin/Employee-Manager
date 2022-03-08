import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public employees: Employee[];
  public updateEmployee: Employee;
  public deleteEmployee: Employee;

  constructor(private employeeService: EmployeeService) { };

  ngOnInit(): void {
    this.getEmployees();
  }

  onOpenModal(mode: string, employee: Employee | null): void {

    const container = document.getElementById('main-container')
    const button = document.createElement('button')

    button.type = 'button'
    button.style.display = 'none'
    button.setAttribute('data-toggle', 'modal')

    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal')
    }
    else if (mode === 'update') {
      if (employee != null) {
        this.updateEmployee = employee
      }
      button.setAttribute('data-target', '#updateEmployeeModal')
    }
    else if (mode === 'delete') {
      if (employee != null) {
        this.deleteEmployee = employee
      }
      button.setAttribute('data-target', '#deleteEmployeeModal')
    }

    container?.appendChild(button)

    button.click()

  }

  public onAddEmployee(addFrom: NgForm): void {
    document.getElementById('add-employee-form')?.click()
    this.employeeService.newEmployee(addFrom.value).subscribe(
      (response: Employee) => {
        console.log(response)
        this.getEmployees()
        addFrom.reset()
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        addFrom.reset()
      }
    )
  }

  public onUpdateEmployee(employee: Employee): void {
    document.getElementById('add-employee-form')?.click()
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response)
        this.getEmployees()
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public onDeleteEmployee(employeeID: number): void {
    this.employeeService.deleteEmployee(employeeID).subscribe(
      (response: void) => {
        console.log(response)
        this.getEmployees()
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public searchEmployees(key: string): void {
    const result: Employee[] = []
    for (const employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) != -1
        || employee.email.toLowerCase().indexOf(key.toLowerCase()) != -1
        || employee.phone.toLowerCase().indexOf(key.toLowerCase()) != -1
        || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) != -1) {
        result.push(employee)
      }
    }
    this.employees = result
    if(result.length === 0 || !key) {
      this.getEmployees()
    }
  }
}
