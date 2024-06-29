package az.ingress.demo.controller;

import az.ingress.demo.model.Employee;
import az.ingress.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }


    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id){
        return employeeService.get(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.delete(id);
    }
}
