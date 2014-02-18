package net.sanjayd.pb.web;

import net.sanjayd.pb.service.AlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsoleController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/")
    public ModelAndView console() {
        ModelAndView mav = new ModelAndView("console");
        mav.addObject("isArmed", alarmService.isArmed());
        return mav;
    }
}
