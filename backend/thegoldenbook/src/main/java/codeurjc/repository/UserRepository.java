package codeurjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import codeurjc.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
   
    
}
