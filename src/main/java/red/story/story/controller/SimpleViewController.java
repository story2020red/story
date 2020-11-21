package red.story.story.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author storyRed
 */
@Controller
public class SimpleViewController {
    @RequestMapping("/")
    public String storyHome(){
        return "HomePage/story";
    }
    @RequestMapping("/log-in-page")
    public String goLogIn(){
        return "user/user-login";
    }
    @RequestMapping("/register-page")
    public String goRegister(){
        return "user/user-register";
    }
    @RequestMapping("/developing")
    public String developing(){
        return "developing/thing-in-progress";
    }
    @RequestMapping("/money-your-homepage")
    public String moneyHome(){
        return "developing/money-yourself-homepage";
    }
}
