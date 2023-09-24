package springrest.springbootbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springrest.springbootbackend.model.Employee;
import springrest.springbootbackend.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Nithin");
		employee.setLastName("Gyentalkar");
		employee.setEmailId("NitinGyentalkar@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Itachi");
		employee1.setLastName("Uchiha");
		employee1.setEmailId("Itachi@gmail.com");
		employeeRepository.save(employee1);

	}
}
