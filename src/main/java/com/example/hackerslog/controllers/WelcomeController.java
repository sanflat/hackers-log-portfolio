package com.example.hackerslog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.hackerslog.common.UserAuthClass;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ウェルカム Controller
 */
@Controller
public class WelcomeController {

    /**
     * ウェルカム画面を表示
     * @param model Model
     * @return welcome/welcome.html
     */
    @RequestMapping("/")
    public String welcomeView(Model model){
        UserAuthClass userAuthClass = new UserAuthClass();
        userAuthClass.getAuthModelAttribute(model);
        return "welcome/welcome";
    }
}
