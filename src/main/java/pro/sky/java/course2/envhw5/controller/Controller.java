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
    public String addEmployee(@RequestParam(name = "lastName", required = false) String lastName, @RequestParam(name = "firstName", required = false) String firstName) {
        String k = employeeService.addEmployee(lastName, firstName);
        if (k.equalsIgnoreCase("сотрудник уже добавлен в БД")) throw new BadRequest();
        return k;

    }

    @GetMapping(path = "/deleteEmployee")
    public String deleteEmployee(@RequestParam(name = "lastName", required = false) String lastName, @RequestParam(name = "firstName", required = false) String firstName) {
        if (employeeService.findEmployee(lastName, firstName).equals("сотрудник не найден")) {
            throw new NotFound();
        }
        return employeeService.deleteEmployee(lastName, firstName);
    }

    @GetMapping(path = "/findEmployee")
    public String findEmployee(@RequestParam(name = "lastName", required = false) String lastName, @RequestParam(name = "firstName", required = false) String firstName) {
        if (employeeService.findEmployee(lastName, firstName).equals("сотрудник не найден")) {
            throw new NotFound();
        }
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping(path = "/sumEmployee")
    public int free() {
        return employeeService.sumEmployee();
    }

    @GetMapping(path = "/printAllEmployee")
    public String printAllEmployee() {
        return employeeService.printAllEmployee();
    }
}
