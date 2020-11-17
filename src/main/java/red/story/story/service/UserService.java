package red.story.story.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import red.story.story.dao.UserMapper;
import red.story.story.entity.User;

/**
 * @author storyRed
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean insertOneUser(User user){
        userMapper.inertOne(user);
        return true;
    }
}
