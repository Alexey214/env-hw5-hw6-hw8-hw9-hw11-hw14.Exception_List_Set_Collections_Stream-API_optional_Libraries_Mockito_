package pro.sky.java.course2.envhw5.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees = new HashMap<>();

    @Override
    public String addEmployee(String lastName, String firstName) {
        String key = lastName + " " + firstName;
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        if (employees.containsKey(key)) {
            s = "сотрудник уже добавлен в БД";
        } else {
            employees.put(key, employee);
            s = "Сотрудник " + lastName + ' ' + firstName + " успешно добавлен";
        }
        return s;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) {
        String key = lastName + " " + firstName;
        Employee employee = new Employee(lastName, firstName);
        String s = null;
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
        String key = lastName + " " + firstName;
        String s = null;
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
}
