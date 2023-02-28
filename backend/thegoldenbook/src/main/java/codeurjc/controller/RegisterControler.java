/*package codeurjc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.repository.UserRepository;
import codeurjc.model.User;

@Controller
public class RegisterControler {
    @Autowired
    private UserRepository user_repository;
    
    @RequestMapping
    public void añadirUser(@RequestParam String NombreCompleto, @RequestParam String CorreoElectronico, @RequestParam String Contraseña){
        user_repository.save(new User(NombreCompleto, CorreoElectronico, Contraseña));
    }
}
*/