package com.lgd.winter.controller;

import com.lgd.winter.model.User;
import com.lgd.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页控制器
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sys")
public class IndexController extends BaseController {

    private static final String VIEW_PREFIX = "index/";

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        String userId = (String) request.getAttribute("userId");
        User user = userService.selectByPrimaryKey(Integer.parseInt(userId));
        model.addAttribute("user", user);
        return VIEW_PREFIX + "index";
    }

    @RequestMapping("/welcome")
    public String main(Model model) {
        return VIEW_PREFIX + "welcome";
    }
}