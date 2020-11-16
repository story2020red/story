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
}
