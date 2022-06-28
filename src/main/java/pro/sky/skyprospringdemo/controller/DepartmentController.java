package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.DepartmentService;
import pro.sky.skyprospringdemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/max-salary")
    public int maxSalary(@RequestParam("departmentId") String departmentId) {
        return departmentService.getMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public int minSalary(@RequestParam("departmentId") String departmentId) {
        return departmentService.getMinSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> allEmployeesFromDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getAllEmployeesFromDepartment(departmentId);
    }

    @GetMapping(path = "/allEmployees")
    public List<Employee> allEmployeesFromDepartment() {
        return departmentService.getAllEmployees();
    }
}
