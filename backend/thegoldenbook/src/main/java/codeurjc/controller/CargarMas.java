package codeurjc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.web.csrf.CsrfToken;


import codeurjc.model.Book;
import codeurjc.service.CargarMasService;

@Controller
public class CargarMas {
    @Autowired
	private  CargarMasService cargarMasService;


    @GetMapping("/")
	public String CargarMas(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
        model.addAttribute("home", cargarMasService.findAll());
	
		return "CargarMas";
	}

    
}
