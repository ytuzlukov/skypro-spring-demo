package pro.sky.skyprospringdemo.service.department;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.employee.EmployeeService;
import pro.sky.skyprospringdemo.service.employee.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public int getMaxSalaryFromDepartment(String departmentId) {
        List<Employee> mp = employeeService.getEmployees();
        return mp.stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .max(Comparator.comparingInt(c -> c.getSalary())).get().getSalary();
    }

    @Override
    public int getMinSalaryFromDepartment(String departmentId) {
        List<Employee> mp = employeeService.getEmployees();
        return mp.stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .min(Comparator.comparingInt(c -> c.getSalary())).get().getSalary();
    }

    @Override
    public List<Employee> getAllEmployeesFromDepartment(String departmentId) {
        List<Employee> mp = employeeService.getEmployees();
        return mp
                .stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> mp = employeeService.getEmployees();
        return new ArrayList<>(mp);
    }
}
