package pro.sky.java.course2.envhw5;

import java.util.Objects;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final double salary;
    private final int department;


    public Employee(String lastName, String firstName, double salary, int department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pro.sky.java.course2.envhw5.Employee employee = (pro.sky.java.course2.envhw5.Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "фамилия " + lastName +
                ", имя " + firstName +
                "; ЗП: " + salary +
                ", отдел " + department;
    }
}

