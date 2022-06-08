package pro.sky.java.course2.envhw5.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.Employee;
import pro.sky.java.course2.envhw5.exception.NotFound;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees = new HashMap<>();

    public String checkName(String lastName, String firstName) {
        String key = null;
        if (!StringUtils.isEmpty(lastName)
                && !StringUtils.isEmpty(firstName)
                && StringUtils.equals(StringUtils.left(lastName, 1), StringUtils.left(lastName, 1).toUpperCase(Locale.ROOT))
                && StringUtils.equals(StringUtils.left(firstName, 1), StringUtils.left(firstName, 1).toUpperCase(Locale.ROOT))) {
            key = lastName + " " + firstName;
        } else {
            key = "ошибка";
        }
        return key;
    }

    @Override
    public String addEmployee(String lastName, String firstName, double salary, int department) {
        String s = null;
        String key = checkName(lastName, firstName);
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.containsKey(key)) {
            s = "сотрудник уже добавлен в БД";
        } else if (key.equals("ошибка")) {
            return key;
        } else {
            employees.put(key, employee);
            s = "Сотрудник " + lastName + ' ' + firstName + " успешно добавлен";
        }
        return s;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName, double salary, int department) {
        String s = null;
        String key = checkName(lastName, firstName);
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.containsKey(key)) {
            employees.remove(key, employee);
            s = "Сотрудник " + key + " успешно удалён";
        } else {
            s = "сотрудник не найден";
        }
        return s;
    }

    @Override
    public String findEmployee(String lastName, String firstName) {
        String s = null;
        String key = checkName(lastName, firstName);
        if (employees.containsKey(key)) {
            s = "Найден сотрудник " + key;
        } else {
            s = "сотрудник не найден";
        }

        return s;
    }

    @Override
    public int sumEmployee() {
        return employees.size();
    }

    @Override
    public String printAllEmployee() {
        return employees.toString();
    }

    @Override
    public String maxSalaryInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        final String maxSalary = employeesList
                .stream()
                .filter(dep -> dep.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NotFound::new).toString();
        return "Сотрудник с максимальной зарплатой отделе " + department + ", " + maxSalary;
    }

    @Override
    public String minSalaryInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        final String minSalary = employeesList.stream()
                .filter(dep -> dep.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NotFound::new).toString();
        return "Сотрудник с минимальной зарплатой отделе " + department + ", " + minSalary;
    }

    @Override
    public String printEmployeesInDep(int department) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        final String employeesInDep = employeesList.stream()
                .filter(dep -> dep.getDepartment() == department)
                .collect(Collectors.toList()).toString();
        return employeesInDep;
    }

    @Override
    public String printAllEmployees() {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        final String allEmployees = employeesList.stream()
                .collect(Collectors.toList()).toString();
        return allEmployees;
    }
}
