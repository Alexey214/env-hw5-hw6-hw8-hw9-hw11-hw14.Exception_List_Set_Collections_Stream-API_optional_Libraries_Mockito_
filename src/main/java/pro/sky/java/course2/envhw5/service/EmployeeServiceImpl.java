package pro.sky.java.course2.envhw5.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.envhw5.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Employee[] employees = new Employee[10];

    @Override
    public String addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                s = "Сотрудник " + lastName + ' ' + firstName + " успешно добавлен";
                break;
            }
            if (employees[i] != null) {
                if (employees[i].equals(employee)) {
                    s = "сотрудник уже добавлен в БД";
                    break;
                }
            }
        }
        return s;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(employee)) {
                    employees[i] = null;
                    s = "Сотрудник " + lastName + ' ' + firstName + " успешно удалён";
                    break;
                }
            } else {
                s = "сотрудник не найден";
            }
        }
        return s;
    }

    @Override
    public String findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String s = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(employee)) {
                    s = "Найден сотрудник " + lastName + ' ' + firstName;
                    break;
                }
            } else {
                s = "сотрудник не найден";
            }
        }
        return s;
    }

    @Override
    public int free() {
        int i = 0;
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] == null) {
                i++;
            }
        }
        return i;
    }
}
