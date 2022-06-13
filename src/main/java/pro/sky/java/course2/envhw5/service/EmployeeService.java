package pro.sky.java.course2.envhw5.service;

import pro.sky.java.course2.envhw5.data.Employee;

import java.util.Map;

public interface EmployeeService {
    String addEmployee(String lastName, String firstName, double salary, int department);

    String deleteEmployee(String lastName, String firstName, double salary, int department);

    String findEmployee(String lastName, String firstName);

    int sumEmployee();

    Map<String, Employee> getEmployees();

    String checkName(String lastName, String firstName);
}
