package springrest.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.springbootbackend.exception.ResourceNotFoundException;
import springrest.springbootbackend.model.Employee;
import springrest.springbootbackend.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllemployees(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by ID REST API
    @GetMapping("{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long Id){
        Employee employee = employeeRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + Id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{Id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long Id,@RequestBody Employee employeedetails){
        Employee updateEmployee = employeeRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + Id));

        updateEmployee.setFirstName((employeedetails.getFirstName()));
        updateEmployee.setLastName((employeedetails.getLastName()));
        updateEmployee.setEmailId((employeedetails.getEmailId()));

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{Id}")
    public  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long Id){
        Employee employee = employeeRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + Id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
