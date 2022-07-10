package service.department;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.department.DepartmentService;
import pro.sky.skyprospringdemo.service.department.DepartmentServiceImpl;
import pro.sky.skyprospringdemo.service.employee.EmployeeService;
import pro.sky.skyprospringdemo.service.employee.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    private final Employee employee = new Employee("Evgen", "Evgeniev", 70_000, "3");
    private final Employee employee1 = new Employee("Maxim", "Maximov", 30_000, "3");

    private final List<Employee> list = new ArrayList<>(List.of(employee, employee1));

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void getMaxSalaryFromDepartmentTest() {
        Mockito.when(employeeService.getEmployees()).thenReturn(list);
        int maxSalaryExpected = departmentService.getMaxSalaryFromDepartment("3");
        assertEquals(maxSalaryExpected, 70_000);
    }

    @Test
    public void getMinSalaryFromDepartmentTest() {
        Mockito.when(employeeService.getEmployees()).thenReturn(list);
        int maxSalaryExpected = departmentService.getMinSalaryFromDepartment("3");
        assertEquals(maxSalaryExpected, 30_000);
    }

    @Test
    public void getAllEmployeesFromDepartmentTest() {
        Mockito.when(employeeService.getEmployees()).thenReturn(list);
        assertEquals(departmentService.getAllEmployeesFromDepartment("3"), list);
    }

    @Test
    public void getAllEmployeesTest() {
        Mockito.when(employeeService.getEmployees()).thenReturn(list);
        assertEquals(departmentService.getAllEmployees(), list);
    }
}
