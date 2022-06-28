package pro.sky.skyprospringdemo.service.employee;

import pro.sky.skyprospringdemo.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName, int salary, String department);

    Employee removeEmployee(String firstName, String secondName, int salary, String department);

    Employee findEmployee(String firstName, String secondName, int salary, String department);

    List<Employee> getEmployees();
}
