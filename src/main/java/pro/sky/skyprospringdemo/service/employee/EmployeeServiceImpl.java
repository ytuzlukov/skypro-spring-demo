package pro.sky.skyprospringdemo.service.employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringdemo.exceptions.WrongSymbolsException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String secondName, int salary, String department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                salary,
                department);

        if (StringUtils.isAlpha(employee.getFirstName())) {
            employee.setFirstName(StringUtils.capitalize(employee.getFirstName().toLowerCase()));
        } else {
            throw new WrongSymbolsException("Имя должно содержать только буквы a-z, A-Z");
        }

        if (StringUtils.isAlpha(employee.getFirstName())) {
            employee.setLastName(StringUtils.capitalize(employee.getLastName().toLowerCase()));
        } else {
            throw new WrongSymbolsException("Фамилия должно содержать только буквы a-z, A-Z");
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой пользователь уже существует");
        } else {
            employees.put(employee.getFullName(), employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName, int salary, String department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                salary,
                department);

        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String secondName, int salary, String department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                salary,
                department);

        if (employees.containsKey(employee.getFullName())) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Пользователь с таким именем и фамилией не найден");
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }
}
