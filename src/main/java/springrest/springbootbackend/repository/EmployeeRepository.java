package springrest.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springrest.springbootbackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// all the CRUD database methods
}
