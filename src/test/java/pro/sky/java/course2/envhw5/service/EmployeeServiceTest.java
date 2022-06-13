package pro.sky.java.course2.envhw5.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.envhw5.service.impl.EmployeeServiceImpl;
import static pro.sky.java.course2.envhw5.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeServiceImpl();

    @Test
    void addEmployeeWhitCorrectName() {
        String result = out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        assertTrue(result.contains(DEFAULT_FULL_NAME));
        assertEquals(DEFAULT_ADD_MESSAGE_1, result);
    }

    @Test
    void reAddEmployee() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        assertFalse(result.contains(DEFAULT_FULL_NAME));
        assertEquals(DEFAULT_EXCEPTION_MESSAGE_1, result);
    }

    @Test
    void deleteEmployeeWhitCorrectName() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.deleteEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        assertTrue(result.contains(DEFAULT_FULL_NAME));
        assertEquals(DEFAULT_DELETE_MESSAGE, result);
    }

    @Test
    void deleteEmployeeWhitNotCorrectName() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.deleteEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        assertFalse(result.contains(NOT_CORRECT_FULL_NAME));
        assertEquals(DEFAULT_DELETE_MESSAGE, result);
    }

    @Test
    void deleteNotFoundEmployee() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.deleteEmployee(NOT_CORRECT_LASTNAME, NOT_CORRECT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        assertFalse(result.contains(NOT_CORRECT_FULL_NAME));
        assertEquals(DEFAULT_NOT_FOUND_MESSAGE, result);
    }

    @Test
    void findEmployeeWhitCorrectName() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.findEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME);
        assertTrue(result.contains(DEFAULT_FULL_NAME));
        assertEquals(DEFAULT_FOUND_MESSAGE, result);
    }

    @Test
    void findEmployeeWhitNotCorrectName() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
        String result = out.findEmployee(NOT_CORRECT_LASTNAME, NOT_CORRECT_FIRSTNAME);
        assertFalse(result.contains(NOT_CORRECT_FULL_NAME));
        assertEquals(DEFAULT_NOT_FOUND_MESSAGE, result);
    }

    @Test
    void theNumberOfEmployees() {
        int count = 0;
        if (count >= 0) {
            out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MAX_SALARY, DEFAULT_DEPARTMENT);
            count++;
        }
        assertEquals(count, out.sumEmployee());
    }

    @Test
    void getEmployees() {
        out.addEmployee(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, MIN_SALARY, DEFAULT_DEPARTMENT);
        String result = out.getEmployees().toString();
        assertEquals("{Ivanov Ivan=" + DEFAULT_EMPLOYEE1 + "}", result);
    }

    @Test
    void checkCorrectName() {
        String result = out.checkName(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME);
        assertEquals(DEFAULT_FULL_NAME, result);
    }

    @Test
    void checkNotCorrectName() {
        String result = out.checkName(DEFAULT_LASTNAME, DEFAULT_FIRSTNAME);
        assertFalse(result.contains(NOT_CORRECT_FULL_NAME));
    }
}