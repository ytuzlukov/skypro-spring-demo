package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    Collection<Employee> getEmployees();
}
