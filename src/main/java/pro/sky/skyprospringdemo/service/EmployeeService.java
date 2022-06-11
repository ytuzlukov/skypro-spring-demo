package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    List<Employee> getEmployeesList();
}
