package com.lgd.winter.controller;

import cn.hutool.core.lang.Console;
import cn.hutool.crypto.SecureUtil;
import com.lgd.winter.bean.Result;
import com.lgd.winter.model.User;
import com.lgd.winter.service.UserService;
import com.lgd.winter.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 登录相关控制器
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Controller
public class LoginController extends BaseController {

    private static final String LOGIN_EXIST_TIME = CommonUtil.findPropertiesKey("redis.login.expire");
    private static final String COOKIE_DOMAIN = CommonUtil.findPropertiesKey("cookie.domain");

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;


    @RequestMapping("/check")
    public String check() {
        return "login";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) {
        user.setPassword(SecureUtil.md5(user.getPassword()));
        User loginUser = userService.loginCheck(user);
        if (loginUser != null) {
            //redis存入登录信息
            redisTemplate.opsForValue().set("admin:login", loginUser.getId().toString(), Long.parseLong(LOGIN_EXIST_TIME), TimeUnit.SECONDS);
            //cookie存入登录信息
            Cookie cookie = new Cookie("login", loginUser.getId().toString());
            cookie.setDomain(COOKIE_DOMAIN);
            cookie.setPath("/");
            response.addCookie(cookie);

            return Result.buildOK("登陆成功！").setUrl(getBaseUrl(request) + "/sys/index");
        } else {
            return Result.buildError("用户名或密码错误");
        }
    }

    @RequestMapping(value = "/sys/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //清理cookie
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            Console.log("no cookies");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setDomain(COOKIE_DOMAIN);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        //清理redis
        redisTemplate.delete("admin:login");

        return "login";
    }

    @RequestMapping("/auth")
    public String auth() {
        return "auth";
    }
}