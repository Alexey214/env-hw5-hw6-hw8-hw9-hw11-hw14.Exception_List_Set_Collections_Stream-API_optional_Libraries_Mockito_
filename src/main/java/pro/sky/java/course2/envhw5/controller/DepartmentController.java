package pro.sky.java.course2.envhw5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.envhw5.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public String maxSalaryInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return departmentService.maxSalaryInDep(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public String minSalaryInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return departmentService.minSalaryInDep(departmentId);
    }

    @GetMapping(path = "/all")
    public String printEmployeesInDep(@RequestParam(name = "departmentId", required = false) int departmentId) {
        return departmentService.printEmployeesInDep(departmentId);
    }

    @GetMapping(path = "/printAllEmployee")
    public String printAllEmployee() {
        return departmentService.printAllEmployees();
    }
}
