package codeurjc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpRequest;

import org.springframework.http.HttpHeaders;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.web.csrf.CsrfToken;

import codeurjc.model.Book;
import codeurjc.model.User;
import codeurjc.repository.UserRepository;

public class ProfileController {

    @Autowired
    private UserRepository user_repository;

    @GetMapping("(/profile)")
    public String showProfile(Model model, @PathVariable Long id, HttpServletRequest request) {
      CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
      model.addAttribute("token", token.getToken());
      model.addAttribute("admin", request.isUserInRole("ADMIN"));
      Optional<User> user = user_repository.findById(id);
      if(user.isPresent()){
          model.addAttribute("user", user_repository);
      }  
      return "profile";
    }

    @GetMapping("/profileModification")
    public String profileModification(Model model, HttpServletRequest request) {
      CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
      model.addAttribute("token", token.getToken());
      model.addAttribute("user", request.isUserInRole("USER"));
      return "profileModification";
    }

    @PostMapping("/profileModification")
    public String newProfileProcess(Model model, User user, MultipartFile imageField) throws IOException {
  
      if (!imageField.isEmpty()) {
        user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
        user.setImage(true);
      }
  
      user_repository.save(user);
  
      model.addAttribute("id", user.getId());
  
      return "redirect:/profile";
    }
    
    @GetMapping("profile/image")
	  public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException, IOException {

		  Optional<User> user = user_repository.findById(id);
		  if (user.isPresent() && user.get().getImageFile() != null) {

			  InputStreamResource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());

			  return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg", "image/jpg")
					.contentLength(user.get().getImageFile().length()).body(file);

		  } else {
			  return ResponseEntity.notFound().build();
		  }
	}
}
