package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap(Map.of(
            new Employee(
                    "Жан",
                    "Рено"
            ),
            new Employee(
                    "Люк",
                    "Бессон"
            )));

    @Override
    public Employee addEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            employees.put(employee.getFullName(), employee);
            return employee;
        } else throw new EmployeeAlreadyAddedException("Такой пользователь уже существует");
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
    }

    @Override
    public Map<String, Employee> getEmployeesMap() {
            return employees;
    }

}
