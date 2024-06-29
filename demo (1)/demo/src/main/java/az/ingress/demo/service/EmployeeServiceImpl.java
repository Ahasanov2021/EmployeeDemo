package az.ingress.demo.service;

import az.ingress.demo.model.Employee;
import az.ingress.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee get(Integer id){
        log.info("Employee service get method is working.");
        Optional<Employee> student = employeeRepository.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return student.get();
    }

    @Override
    public Employee create(Employee employee){
        log.info("Employee service create method is working.");
        Employee employeeInDb = employeeRepository.save(employee);
        return employeeInDb;
    }

    @Override
    public Employee update(Integer id, Employee employee){
        log.info("Employee service update method is working.");
        Employee entity = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        if(employee.getAge() != null){
            entity.setAge(employee.getAge());
        }
        if(employee.getName() != null){
            entity.setName(employee.getName());
        }
        if(employee.getSurName() != null){
            entity.setSurName(employee.getSurName());
        }
        if(employee.getPhone() != null){
            entity.setPhone(employee.getPhone());
        }
        employeeRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        log.info("Employee service delete method is working.");
        employeeRepository.deleteById(id);
    }
}
