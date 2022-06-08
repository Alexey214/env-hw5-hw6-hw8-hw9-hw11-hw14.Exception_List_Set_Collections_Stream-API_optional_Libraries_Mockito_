package pro.sky.java.course2.envhw5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.envhw5.data.Employee;
import pro.sky.java.course2.envhw5.exception.NotFound;
import pro.sky.java.course2.envhw5.service.impl.DepartmentServiceImpl;
import pro.sky.java.course2.envhw5.service.impl.EmployeeServiceImpl;

import static pro.sky.java.course2.envhw5.constants.Constants.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    public void maxSalaryInDep() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(DEFAULT_EMPLOYEE_MAP);
        String result = out.maxSalaryInDep(DEFAULT_DEPARTMENT)
                .replace("Сотрудник: фамилия Petrov, имя Petr; ЗП: ", "")
                .replace(", отдел 1", "");
        assertEquals(DEFAULT_MAX_SALARY, result);
    }

    @Test
    void minSalaryInDep() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(DEFAULT_EMPLOYEE_MAP);
        String result = out.minSalaryInDep(DEFAULT_DEPARTMENT)
                .replace("Сотрудник: фамилия Ivanov, имя Ivan; ЗП: ", "")
                .replace(", отдел 1", "");
        assertEquals(DEFAULT_MIN_SALARY, result);
    }

    @Test
    void printEmployeesInDep() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(DEFAULT_EMPLOYEE_MAP);
        String result = out.printEmployeesInDep(DEFAULT_DEPARTMENT);
        String expected = "[" + DEFAULT_EMPLOYEE1.toString() + ", " + DEFAULT_EMPLOYEE2.toString() + "]";
        assertEquals(expected, result);
    }

    @Test
    void printAllEmployees() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(DEFAULT_EMPLOYEE_MAP);
        String expected = "[" + DEFAULT_EMPLOYEE1.toString() + ", " + DEFAULT_EMPLOYEE2.toString() + ", " + DEFAULT_EMPLOYEE3.toString() + "]";
        String actual = out.printAllEmployees();
        assertEquals(expected, actual);
    }

    @Test
    void ExceptionNotFoundOrEmployeeBookIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(DEFAULT_EMPLOYEE_MAP);
        assertThrows(NotFound.class, () -> out.maxSalaryInDep(THE_DEPARTAMENT_IS_MISSING));
    }
}