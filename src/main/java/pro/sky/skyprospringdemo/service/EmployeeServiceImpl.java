package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ivanov Ivan Ivanovich", new Employee("Ivanov", "Ivan",53_000, "1"),
            "Petrov Petr Petrovich", new Employee("Petrov", "Petr", 61_000, "1"),
            "Stepanov Stepan Stepanovich", new Employee("Stepanov", "Stepan", 75_000, "2"),
            "Sergeev Sergei Sergeevich", new Employee("Sergeev", "Sergei", 35_000, "2"),
            "Romanov Roman Romanovich", new Employee("Romanov", "Roman", 43_000, "3"),
            "Vasiliev Vasiliy Vasilievich", new Employee("Vasiliev","Vasiliy", 66_000, "3"),
            "Alexandrov Alexander Alexandrovich", new Employee("Alexandrov","Alexander", 18_000, "4"),
            "Mikhaylov Mikhail Mikhailovich", new Employee("Mikhaylov","Mikhail", 68_000, "4"),
            "Dmitriev Dmitrii Dmitrievich", new Employee("Dmitriev","Dmitrii", 28_000, "5"),
            "Vladimirov Vladimir Vladimirovich", new Employee("Vladimirov","Vladimir", 33_000, "5")
    ));

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
        } else {
            throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        }
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        }
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }
}
