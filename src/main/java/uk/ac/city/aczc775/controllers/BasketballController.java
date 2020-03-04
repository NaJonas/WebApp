package uk.ac.city.aczc775.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasketballController {

    @RequestMapping(value = "/history")
    public ModelAndView showHistory(){
        return new ModelAndView("history");
    }



    @RequestMapping(value="/rules")
    public ModelAndView showRules(){
        return new ModelAndView("rules");
    }

}
