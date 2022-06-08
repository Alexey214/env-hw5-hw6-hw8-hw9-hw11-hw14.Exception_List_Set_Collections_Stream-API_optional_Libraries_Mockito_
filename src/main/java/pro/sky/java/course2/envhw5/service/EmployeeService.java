package pro.sky.java.course2.envhw5.service;

public interface EmployeeService {
    String addEmployee(String lastName, String firstName, double salary, int department);

    String deleteEmployee(String lastName, String firstName, double salary, int department);

    String findEmployee(String lastName, String firstName);

    int sumEmployee();

    String printAllEmployee();

    String maxSalaryInDep(int department);

    String minSalaryInDep(int department);

    String printEmployeesInDep(int department);

    String printAllEmployees();

    String checkName(String lastName, String firstName);
}
