package pro.sky.java.course2.envhw5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.envhw5.exception.BadRequest;
import pro.sky.java.course2.envhw5.exception.InternalServerError;
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
        return "Выберите необходимое действие: добавить, удалить или найти сотрудника в баззе данных";
    }

    @GetMapping(path = "/addEmployee")
    public String addEmployee(@RequestParam(name = "lastName", required = false) String lastName, @RequestParam(name = "firstName", required = false) String firstName) {
        if (free() == 0) {
            throw new InternalServerError();
        } else if (employeeService.addEmployee(lastName, firstName).equalsIgnoreCase("сотрудник уже добавлен в БД")) {
            throw new BadRequest();
        }
        return employeeService.addEmployee(lastName, firstName);
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

    @GetMapping(path = "/free")
    public int free() {
        return employeeService.free();
    }
}
