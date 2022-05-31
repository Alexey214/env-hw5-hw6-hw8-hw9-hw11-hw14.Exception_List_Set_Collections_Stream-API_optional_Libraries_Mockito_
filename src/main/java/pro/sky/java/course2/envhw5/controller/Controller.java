package pro.sky.java.course2.envhw5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.envhw5.exception.BadRequest;
import pro.sky.java.course2.envhw5.exception.NotFound;
import pro.sky.java.course2.envhw5.service.EmployeeService;


@RestController
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello() {
        return "Выберите необходимое действие: добавить, удалить или найти сотрудника в базе данных";
    }

    @GetMapping(path = "/addEmployee")
    public String addEmployee(@RequestParam(name = "lastName", required = false) String lastName,
                              @RequestParam(name = "firstName", required = false) String firstName,
                              @RequestParam(name = "salary", required = false) double salary,
                              @RequestParam(name = "department", required = false) int department) {
        String k = employeeService.addEmployee(lastName, firstName, salary, department);
        if (!k.equalsIgnoreCase("ошибка")
                && !k.equalsIgnoreCase("сотрудник уже добавлен в БД")) {
            return k;
        } else {
            throw new BadRequest();
        }
    }

    @GetMapping(path = "/deleteEmployee")
    public String deleteEmployee(@RequestParam(name = "lastName", required = false) String lastName,
                                 @RequestParam(name = "firstName", required = false) String firstName,
                                 @RequestParam(name = "salary", required = false) double salary,
                                 @RequestParam(name = "department", required = false) int department) {
        if (!employeeService.findEmployee(lastName, firstName).equals("ошибка")
                && !employeeService.findEmployee(lastName, firstName).equals("сотрудник не найден")) {
            return employeeService.deleteEmployee(lastName, firstName, salary, department);
        } else {
            throw new NotFound();
        }
    }

    @GetMapping(path = "/findEmployee")
    public String findEmployee(@RequestParam(name = "lastName", required = false) String lastName,
                               @RequestParam(name = "firstName", required = false) String firstName) {
        if (employeeService.findEmployee(lastName, firstName).equals("сотрудник не найден")) {
            throw new NotFound();
        }
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping(path = "/sumEmployee")
    public int free() {
        return employeeService.sumEmployee();
    }

    @GetMapping(path = "/departments/max-salary")
    public String maxSalaryInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return employeeService.maxSalaryInDep(departmentId);
    }

    @GetMapping(path = "/departments/min-salary")
    public String minSalaryInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return employeeService.minSalaryInDep(departmentId);
    }

    @GetMapping(path = "/departments/all")
    public String printEmployeesInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return employeeService.printEmployeesInDep(departmentId);
    }

    @GetMapping(path = "/printAllEmployee")
    public String printAllEmployee() {
        return employeeService.printAllEmployee();
    }
}
