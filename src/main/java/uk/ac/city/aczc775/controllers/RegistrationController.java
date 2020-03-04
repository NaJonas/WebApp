package uk.ac.city.aczc775.controllers;

import uk.ac.city.aczc775.entities.BasketballUser;
import uk.ac.city.aczc775.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(){
        BasketballUser user = new BasketballUser();
        return new ModelAndView("register", "user", user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
        public String processRegistration(BasketballUser user){
            user.setEnabled(Boolean.TRUE);
            user.setAuthority("ROLE_USER");
            registrationService.registerUser(user);
            return "redirect:/profile";
        }

    }


