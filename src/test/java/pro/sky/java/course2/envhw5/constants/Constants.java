package pro.sky.java.course2.envhw5.constants;

import pro.sky.java.course2.envhw5.data.Employee;

import java.util.Map;

public class Constants {
    public static final String DEFAULT_LASTNAME = "Ivanov";
    public static final String DEFAULT_FIRSTNAME = "Ivan";
    public static final Double MIN_SALARY = 50_000.01;
    public static final Double MAX_SALARY = 60_000.01;
    public static final Integer DEFAULT_DEPARTMENT = 1;
    public static final String DEFAULT_FULL_NAME = "Ivanov Ivan";
    public static final String NOT_CORRECT_FULL_NAME = "ivanov ivan";
    public static final String NOT_CORRECT_LASTNAME = "ivanov";
    public static final String NOT_CORRECT_FIRSTNAME = "ivan";
    public static final String DEFAULT_EXCEPTION_MESSAGE_1 = "сотрудник уже добавлен в БД";
    public static final String DEFAULT_EXCEPTION_MESSAGE_2 = "ошибка";
    public static final String DEFAULT_FOUND_MESSAGE = "Найден сотрудник " + DEFAULT_LASTNAME + ' ' + DEFAULT_FIRSTNAME;
    public static final String DEFAULT_NOT_FOUND_MESSAGE = "сотрудник не найден";
    public static final String DEFAULT_ADD_MESSAGE_1 = "Сотрудник " + DEFAULT_LASTNAME + ' ' + DEFAULT_FIRSTNAME + " успешно добавлен";
    public static final String DEFAULT_DELETE_MESSAGE = "Сотрудник " + DEFAULT_LASTNAME + ' ' + DEFAULT_FIRSTNAME + " успешно удалён";
    public static final Employee DEFAULT_EMPLOYEE1 = new Employee("Ivanov", "Ivan", 50_000.01, 1);
    public static final Employee DEFAULT_EMPLOYEE2 = new Employee("Petrov", "Petr", 60_000.01, 1);
    public static final Employee DEFAULT_EMPLOYEE3 = new Employee("Sidorov", "Sidr", 70_000.01, 2);
    public static final Employee NOT_CORRECT_EMPLOYEE_NAME = new Employee("ivanov", "ivan", 70_000.01, 2);

    public static final String DEFAULT_MAX_SALARY = "Сотрудник с максимальной зарплатой отделе " + DEFAULT_DEPARTMENT + ", " + MAX_SALARY;
    public static final String DEFAULT_MIN_SALARY = "Сотрудник с минимальной зарплатой отделе " + DEFAULT_DEPARTMENT + ", " + MIN_SALARY;
    public static final Map<String, Employee> DEFAULT_EMPLOYEE_MAP = Map.of(
            DEFAULT_EMPLOYEE1.getLastName() + " " + DEFAULT_EMPLOYEE1.getFirstName(), DEFAULT_EMPLOYEE1,
            DEFAULT_EMPLOYEE2.getLastName() + " " + DEFAULT_EMPLOYEE2.getFirstName(), DEFAULT_EMPLOYEE2,
            DEFAULT_EMPLOYEE3.getLastName() + " " + DEFAULT_EMPLOYEE3.getFirstName(), DEFAULT_EMPLOYEE3);
    public static final int THE_DEPARTAMENT_IS_MISSING = 0;
}
