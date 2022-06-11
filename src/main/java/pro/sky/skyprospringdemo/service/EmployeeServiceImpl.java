package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>(List.of(
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
        if (!employees.contains(employee)) {
            employees.add(employee);
            return employee;
        } else throw new EmployeeAlreadyAddedException("Такой пользователь уже существует");
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return employee;
        } else throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
    }

    @Override
    public List<Employee> getEmployeesList() {
            return employees;
    }

}
