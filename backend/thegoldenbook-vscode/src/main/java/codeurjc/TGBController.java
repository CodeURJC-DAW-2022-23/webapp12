package codeurjc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TGBController{
    @GetMapping("/greeting")
    public String greetinng(Model model){
        model.addAttribute("name","World");
        return "Header";
    }
}