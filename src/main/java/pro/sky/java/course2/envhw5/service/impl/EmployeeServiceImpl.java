package pro.sky.java.course2.envhw5.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.data.Employee;
import pro.sky.java.course2.envhw5.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees = new HashMap<>();

    public String checkName(String lastName, String firstName) {
        String key = null;
        if (!StringUtils.isEmpty(lastName)
                && StringUtils.isAlpha(firstName)
                && StringUtils.isAlpha(lastName)
                && !StringUtils.isEmpty(firstName)
                && StringUtils.equals(StringUtils.left(lastName, 1), StringUtils.left(lastName, 1).toUpperCase(Locale.ROOT))
                && StringUtils.equals(StringUtils.left(firstName, 1), StringUtils.left(firstName, 1).toUpperCase(Locale.ROOT))) {
            key = StringUtils.capitalize(lastName) + " " + StringUtils.capitalize(firstName);
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
    public Map<String, Employee> getEmployees() {
        return employees;
    }

}
