package org.lessons.java.bestoftheyear.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {

    @GetMapping("/")
    public String home(Model model){
        String name = "Alessandro";
        model.addAttribute("name", name);
        return "home";
    }

}
