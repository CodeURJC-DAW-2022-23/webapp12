package codeurjc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Author_Controller{
    @GetMapping("/author")
    public String greetinng(Model model){
        model.addAttribute("name","Stephen King");
        model.addAttribute("info", "text");
        return "author";
    }
}