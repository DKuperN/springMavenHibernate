package by.javastudy.hibernate.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    // inject via application.properties
    @Value("${welcome.message:Anonim}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", message);
        return "welcome";
    }
}
