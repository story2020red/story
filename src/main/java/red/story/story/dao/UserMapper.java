package red.story.story.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import red.story.story.entity.User;

/**
 * @author storyRed
 * 实现数据存取
 * --------------------------------------
 * 我来做个样式看看先：
 * --------2020-11-27 02:37:35 下午-----------倒尿start;
 * -------2020-11-27 02:44:55 下午-------fail;
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     *insert one,     *
     * @param user, 需要添加的用户
     *测试正确 2020-11-17 02:58:45 下午
     */
    @Insert("insert into user(email,password,status) values(#{email},#{password},#{status})")
    void inertOne(User user);

    /**
     * 查找一个用户
     * @param email 邮箱
     * @return u,
     * test success 2020-11-17 03:08:20 下午
     */
    @Select("select * from user where email='${email}'")
    User findOneUserByEmail(String email);

    /**查找一个ID通过电子邮件
     * @param email
     * @return
     */
    @Select("select id from user where email='${email}'")
    Integer findIdByEmail(String email);


}
