package az.ingress.demo.service;

import az.ingress.demo.model.Employee;

public interface EmployeeService {
    Employee get(Integer id);

    Employee create(Employee employee);

    Employee update(Integer id, Employee employee);

    void delete(Integer id);
}
