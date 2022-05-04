package pro.sky.java.course2.envhw5.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public List<Employee> employees = new ArrayList<>();

    @Override
    public String addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        if (employees.contains(employee)) {
            s = "сотрудник уже добавлен в БД";
        } else {
            employees.add(employee);
            s = "Сотрудник " + lastName + ' ' + firstName + " успешно добавлен";
        }
        return s;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        if (employees.contains(employee)) {
            employees.remove(employee);
            s = "Сотрудник " + lastName + ' ' + firstName + " успешно удалён";
        } else {
            s = "сотрудник не найден";
        }
        return s;
    }

    @Override
    public String findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        if (employees.contains(employee)) {
            s = "Найден сотрудник " + lastName + ' ' + firstName;
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
