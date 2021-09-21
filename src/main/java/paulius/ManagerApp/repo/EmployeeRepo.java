package paulius.ManagerApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paulius.ManagerApp.model.Employee;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>
{
    Optional<Employee> findByEmail(String email);
    //Optional<Employee> findById(Long id);
}
