package codeurjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import codeurjc.model.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
   User findByUser(String user);

}
