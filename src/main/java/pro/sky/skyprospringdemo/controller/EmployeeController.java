package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.employee.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName,
            @RequestParam("salary") int salary,
            @RequestParam("department") String department) {
        return employeeService.addEmployee(firstName, secondName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName,
            @RequestParam("salary") int salary,
            @RequestParam("department") String department) {
        return employeeService.removeEmployee(firstName, secondName, salary, department);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName,
            @RequestParam("salary") int salary,
            @RequestParam("department") String department) {
        return employeeService.findEmployee(firstName, secondName, salary, department);
    }

    @GetMapping(path = "/getEmployees")
    public List<Employee> getEmployeesMap() {
        return employeeService.getEmployees();
    }
}
