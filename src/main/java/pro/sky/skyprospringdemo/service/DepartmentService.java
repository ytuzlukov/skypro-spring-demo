package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Employee;

import java.util.List;

public interface DepartmentService {

    int getMaxSalaryFromDepartment(String departmentId);

    int getMinSalaryFromDepartment(String departmentId);

    List<Employee> getAllEmployeesFromDepartment(String departmentId);

    List<Employee> getAllEmployees();
}
