package projekti;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("message", "World!");
        return "index";
    }

}
