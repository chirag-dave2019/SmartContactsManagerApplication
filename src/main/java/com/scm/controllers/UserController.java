package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

@RequestMapping("/user")
public class UserController {
   // user dahsboard

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //user profile page

    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    

   // user add contacts page
   // user view contact
   // user edit contact
   // user delete contact
   // user search contact
}
