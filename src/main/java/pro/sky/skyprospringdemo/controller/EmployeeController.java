package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName);
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/employee/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName);
        employeeService.removeEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/employee/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName);
        employeeService.findEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/employee/get_employees_list")
    public List<Employee> getEmployeesList() {
        return new ArrayList<>(employeeService.getEmployeesList());
    }
}
