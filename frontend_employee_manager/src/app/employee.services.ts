import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Employee } from "./employee"
import { environment } from "src/environments/environment";

@Injectable({ providedIn: 'root' })
export class EmployeeService {
    
    private apiServerURL = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public getEmployees(): Observable<Employee[]> {
        return this.http.get<Employee[]>(this.apiServerURL + "/all");
    }

    public newEmployee(employee: Employee): Observable<Employee> {
        return this.http.post<Employee>(this.apiServerURL + "/new", employee);
    }

    public updateEmployee(employee: Employee): Observable<Employee> {
        return this.http.put<Employee>(this.apiServerURL + "/update", employee);
    }

    public deleteEmployee(id: number): Observable<void> {
        return this.http.delete<void>(this.apiServerURL + "/delete/" + id);
    }

}