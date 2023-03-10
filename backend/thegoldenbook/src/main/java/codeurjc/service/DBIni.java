package codeurjc.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import codeurjc.model.User;
import codeurjc.repository.UserRepository;

@Service
public class DBIni {
    
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDataBase(){
        userRepository.save(new User("user", passwordEncoder.encode("pass"), "USER"));
        userRepository.save(new User("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));

    }

}
