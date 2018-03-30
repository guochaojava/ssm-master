package com.lgd.winter.controller;

import com.github.pagehelper.PageInfo;
import com.lgd.winter.bean.Result;
import com.lgd.winter.dto.query.MenuQuery;
import com.lgd.winter.enums.StatusEnum;
import com.lgd.winter.model.Menu;
import com.lgd.winter.model.User;
import com.lgd.winter.service.MenuService;
import com.lgd.winter.service.UserService;
import com.lgd.winter.util.MenuObjectUtil;
import com.lgd.winter.util.bean.MenuObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单控制器
 *
 * @author guochao
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sys")
public class MenuController extends BaseController {

    private static final String VIEW_PREFIX = "menu/";

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;


    /**
     * 根据登录用户获取菜单列表
     *
     * @param request 请求对象
     * @return 菜单列表
     */
    @RequestMapping(value = "/menuList")
    @ResponseBody
    public Object menuList(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        User user = userService.selectByPrimaryKey(Integer.parseInt(userId));
        MenuQuery query = new MenuQuery();
        query.setStatus(StatusEnum.NORMAL.getCode());
        query.setUserId(user.getId());
        List<Menu> list = menuService.menuList(query);
        List<MenuObject> mol = new ArrayList<MenuObject>();
        for (Menu mv : list) {
            MenuObject mo = new MenuObject();
            //复制源类属性到目标类  param1:源类  param2:目标类
            BeanUtils.copyProperties(mv, mo);
            mol.add(mo);
        }
        MenuObjectUtil mu = new MenuObjectUtil();
        List<MenuObject> result = mu.getChildMenuObjects(mol);
        Map<String, Object> map = new HashMap<>();
        map.put("list", result);
        return Result.buildOK(map, "获取成功");
    }

    @RequestMapping(value = "/auth/menu")
    public String toMenu(Model model) {
        return VIEW_PREFIX + "list";
    }

    @RequestMapping(value = "/auth/menu/list")
    @ResponseBody
    public Object menuList(MenuQuery query) {
        PageInfo<Menu> pageInfo = menuService.list(query);
        Map<String, Object> map = new HashMap<>();
        map.put("list", pageInfo.getList());
        return Result.buildOK(pageInfo.getPages(), pageInfo.getTotal(), map);

    }

    @RequestMapping(value = "/auth/menu/listNoPages")
    @ResponseBody
    public Object menuListNoPages(MenuQuery query) {
        //设置搜索条件
        query.setStatus(StatusEnum.NORMAL.getCode());
        List<Menu> list = menuService.menuList(query);
        List<MenuObject> mol = new ArrayList<MenuObject>();
        for (Menu mv : list) {
            MenuObject mo = new MenuObject();
            BeanUtils.copyProperties(mv, mo);
            mol.add(mo);
        }
        MenuObjectUtil mu = new MenuObjectUtil();
        List<MenuObject> result = mu.getChildMenuObjects(mol);
        Map<String, Object> map = new HashMap<>();
        map.put("list", result);
        return Result.buildOK(map, "获取成功");
    }

    @RequestMapping(value = "/auth/menu/add")
    @ResponseBody
    public Object menuAdd(Menu menu, HttpServletRequest request) {
        if (menu.getId() != null) {
            menuService.updateByPrimaryKeySelective(menu);
            return Result.buildOK("更新成功！");
        } else {
            menu.setUrl(getBaseUrl(request) + menu.getUrl());
            menuService.insertSelective(menu);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", menu.getId().toString());
            return Result.buildOK(map, "添加成功！");
        }
    }

    @RequestMapping(value = "/auth/menu/delete")
    @ResponseBody
    public Object menuDel(String id) {
        menuService.deleteByIds(id);
        return Result.buildOK("删除成功！");
    }

    @RequestMapping(value = "/auth/menu/status")
    @ResponseBody
    public Object menuStatus(String id) {
        menuService.updateStatusByIds(id);
        return Result.buildOK("更新成功！");
    }

    @RequestMapping(value = "/auth/menu/sort")
    @ResponseBody
    public Object menuSort(Menu menu) {
        menuService.updateByPrimaryKeySelective(menu);
        return Result.buildOK("更新成功！");
    }
}
