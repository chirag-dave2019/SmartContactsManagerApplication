package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class PageContoller {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(org.springframework.ui.Model model) {
        System.out.println("Home page Handler");
        model.addAttribute("name","Substring technologies");
        model.addAttribute("youtubeChannel","Chirag Dave");
        model.addAttribute("gitRepository","https://github.com/chirag-dave2019");
        return "home";
    }

    //about route
    @GetMapping("/about")
    public String about(org.springframework.ui.Model model) {
        model.addAttribute("isLogin",true);
        System.out.println("About Page loading");
        return "about";
    }


    //service route
    @GetMapping("/services")
    public String services() {
        System.out.println("Services Page loading");
        return "services";
    }

    //contacts route
    @GetMapping("/contact")
    public String contact() {
        System.out.println("Contact Page loading");
        return "contact";
    }

    //contacts route
    @GetMapping("/login")
    public String login() {
        
        return new String("login");
    }

    //contacts route
    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        //default data
        // userForm.setName("Chirag");
        // userForm.setEmail("davechiragn1997@gmail.com");
        // userForm.setAbout("The Full Stack Developer with great knowledge...");
        model.addAttribute("userForm",userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // user form
        System.out.println("USer Form: " + userForm);

        // validate form data

        if(rBindingResult.hasErrors()){
            return "register";
        }


        // TODO validate form data
        // save to db
        //user Service
        //UserForm -- > User

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://avatars.githubusercontent.com/u/83655325?v=4?s=400")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
            "https://avatars.githubusercontent.com/u/83655325?v=4?s=400");

        User savedUSer = userService.saveUser(user);
        // message = "Registration Successful"
        //redirect login page
        
        //add the message

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",message);

        return "redirect:/register";
    }
    
}
