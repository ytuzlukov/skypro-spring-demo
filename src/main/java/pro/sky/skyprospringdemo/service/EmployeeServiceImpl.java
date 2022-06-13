package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap(Map.of());

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой пользователь уже существует");
        } else {
            employees.put(employee.getFullName(), employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
    }

    @Override
    public Collection<Employee> getEmployees() {
            return employees.values();
    }

}
