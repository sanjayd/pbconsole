package net.sanjayd.pb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) Boolean error) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", error != null && error);
        return mav;
    }
}
