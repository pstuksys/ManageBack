package paulius.ManagerApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import paulius.ManagerApp.exception.UserNotFoundException;
import paulius.ManagerApp.model.Employee;
import paulius.ManagerApp.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo repo;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> findEmployees(){
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    public Employee findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Employee by id " + id + " not found"));
    }

}
