package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping(path = "/calc")
    public String get(Model model) {
        List<String> operations = new ArrayList<>();
        operations.add("add");
        operations.add("sub");
        operations.add("mult");
        operations.add("div");
        model.addAttribute("operations", operations);
        return "home";
    }

    @PostMapping(path = "/calc")
    public String calc(@RequestParam double num1, @RequestParam double num2, @RequestParam String type, Model model) {
        List<String> operations = new ArrayList<>();
        operations.add("add");
        operations.add("sub");
        operations.add("mult");
        operations.add("div");
        model.addAttribute("operations", operations);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("type", type);
        switch (type) {
            case "add":
                model.addAttribute("result", num1 + num2);
                break;
            case "sub":
                model.addAttribute("result", num1 - num2);
                break;
            case "mult":
                model.addAttribute("result", num1 * num2);
                break;
            case "div":
                model.addAttribute("result", num1 / num2);
                if (num2==0){
                    model.addAttribute("message","Division by zero");
                }
                break;
        }
        return "home";
    }
}
