package com.example.javaproject.controller;

import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class webcontroller {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public String pricing(){
        return "pricing";
    }
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts(){
        return "contacts";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginroute(){
        return login();
    }
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }
    @RequestMapping(value = "/forgotten-password", method = RequestMethod.GET)
    public String forgot(){
        return "forgotten-password";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(){
        return "user";
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "404";
    }
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String order(){
        return "order";
    }
}
