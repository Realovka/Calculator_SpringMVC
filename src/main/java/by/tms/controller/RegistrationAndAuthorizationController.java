package by.tms.controller;


import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/reg_auth")
public class RegistrationAndAuthorizationController {

    private UserService userService;

    public RegistrationAndAuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/reg")
    public ModelAndView getRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegistration(User user, ModelAndView modelAndView) {
        userService.createUser(user);
        System.out.println(userService.getInMemoryUserDao().getUsers());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuthorization(ModelAndView modelAndView) {
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView postAuthorization(User user, ModelAndView modelAndView) {
        if (userService.validateUser(user)) {
            modelAndView.setViewName("/calc");
        }
        return modelAndView;
    }

}
