package red.story.story;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import red.story.story.dao.UserMapper;
import red.story.story.entity.User;
import red.story.story.service.UserService;




@SpringBootTest
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
class StoryApplicationTests {


    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User("ss","sss");
//        userService.insertOneUser(user);
    }

    /**
     * 在发布到ESC时会自动跑一边测试，像这种不同跑两次的就不能用
     * **/
    @Test
    void t2(){
//        System.out.println("result:"+userMapper.findOneUserByEmail("aa"));
    }
}
