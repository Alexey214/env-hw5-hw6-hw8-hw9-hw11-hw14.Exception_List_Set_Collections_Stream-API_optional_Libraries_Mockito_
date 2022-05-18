package pro.sky.java.course2.envhw5.service;

public interface EmployeeService {
    String addEmployee(String lastName, String firstName);

    String deleteEmployee(String lastName, String firstName);

    String findEmployee(String lastName, String firstName);

    int sumEmployee();

    String printAllEmployee();
}
