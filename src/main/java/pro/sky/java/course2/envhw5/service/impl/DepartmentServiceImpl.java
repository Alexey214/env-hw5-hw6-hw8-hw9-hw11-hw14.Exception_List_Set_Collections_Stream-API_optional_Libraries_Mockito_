package pro.sky.java.course2.envhw5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.data.Employee;
import pro.sky.java.course2.envhw5.exception.NotFound;
import pro.sky.java.course2.envhw5.service.DepartmentService;
import pro.sky.java.course2.envhw5.service.EmployeeService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public String maxSalaryInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employeeService.getEmployees().values());
        final String maxSalary = employeesList
                .stream()
                .filter(dep -> dep.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NotFound::new).toString();
        return "Сотрудник с максимальной зарплатой отделе " + department + ", " + maxSalary;
    }

    @Override
    public String minSalaryInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employeeService.getEmployees().values());
        final String minSalary = employeesList.stream()
                .filter(dep -> dep.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NotFound::new).toString();
        return "Сотрудник с минимальной зарплатой отделе " + department + ", " + minSalary;
    }

    @Override
    public String printEmployeesInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employeeService.getEmployees().values());
        final String employeesInDep = employeesList.stream()
                .filter(dep -> dep.getDepartment() == department)
                .collect(Collectors.toList()).toString();
        return employeesInDep;
    }

    @Override
    public String printAllEmployees() {
        List<Employee> employeesList = new ArrayList<>(employeeService.getEmployees().values());
        final String allEmployees = employeesList.stream()
                .collect(Collectors.toList()).toString();
        return allEmployees;
    }
}
