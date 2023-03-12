package codeurjc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import codeurjc.model.Book;
import codeurjc.service.CargarMasService;

@Controller
public class CargarMasController {
    @Autowired
	private  CargarMasService cargarMasService;


    @GetMapping("/")
	public String CargarMas(Model model ) {
        model.addAttribute("home", cargarMasService.findAll());
	
		return "CargarMas";
	}

    
}
