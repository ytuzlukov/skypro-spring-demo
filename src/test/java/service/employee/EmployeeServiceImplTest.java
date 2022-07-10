package service.employee;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringdemo.service.employee.EmployeeService;
import pro.sky.skyprospringdemo.service.employee.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@Service
public class EmployeeServiceImplTest {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    void addEmployeeTest() {
        Employee employee = new Employee("Ivan", "Ivanov", 50_000, "5");
        Employee employee1 = employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());

        assertEquals(employee, employee1);
    }

    @Test
    void findEmployeeTest() {
        Employee employee = new Employee("Petr", "Petrov", 60_000, "3");
        Employee employee1 = employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());

        assertEquals(employee, employeeService.findEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment()));
    }

    @Test
    void deleteEmployeeTest() {
        Employee employee = new Employee("Evgen", "Evgeniev", 70_000, "2");
        Employee employee1 = employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());

        assertEquals(employee, employeeService.findEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment()));

        employeeService.removeEmployee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary(),
                        employee.getDepartment());

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment()));
    }
}
