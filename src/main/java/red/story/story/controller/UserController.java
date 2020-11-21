package red.story.story.controller;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import red.story.story.dao.UserMapper;
import red.story.story.entity.UserBehavior;

import javax.servlet.http.HttpSession;

/**
 * @author storyRed
 */
@Controller
public class UserController {

    /**
     * 点击首页用户图标，向服务器查询其登录状态，如果没有登录就跳到登录页面；
     * 如果已经登录，则跳到个人中心；
     * 这里有个问题就是这种模式下，方法返回值不能区分页面还是json,只好统一返回json,
     * 在前端再次请求页面；
     *
     * @return
     */
    @RequestMapping("/homepage-user-button-doing-with")
    @ResponseBody
    public String dealWithUserButtonReplyOnHomePage(HttpSession session) {
/*   当访问网站时，server container会为每个浏览器用户创建一个session,session有自己的持续时间，当用户离开本网站在线
        内容太久时，server container会自动清理该session,
 */
        Object userStatusObject = session.getAttribute("user-status");
//        获取不到内容时，说明用户刚访问本网站
        if (userStatusObject == null) {
            return "offline";
        }
        String userStatus = userStatusObject.toString();
        if (userStatus.equals(UserBehavior.NOT_LOGGED_IN)){
            return "offline";
        }
        return "online";
    }
    @Autowired
    private UserMapper mapper;
    @RequestMapping("/check-out-email")
    @ResponseBody
    public String findIdByEmail(String email){
        Integer a=mapper.findIdByEmail(email);
        if (a ==null){
            return "no";
        }
        return "yes";
    }

    /**
     * 注册功能；
     * 这个方法比单纯的查找对比user多一步，就是刷新验证码；
     * @param email
     * @return
     */
    @RequestMapping("/whether-or-not-this-email")
    public String canRegisterByEmail(String email){
        String s=findIdByEmail(email);
        final String journal = "no";
        if (journal.equals(s)){
//            可以注册；1.生成验证码；2.写入数据库

        }
        return "";
    }

}
