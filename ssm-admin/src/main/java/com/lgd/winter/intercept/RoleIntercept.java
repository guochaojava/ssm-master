package com.lgd.winter.intercept;

import com.lgd.winter.dto.query.MenuQuery;
import com.lgd.winter.enums.StatusEnum;
import com.lgd.winter.model.Menu;
import com.lgd.winter.service.MenuService;
import com.lgd.winter.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 权限拦截器
 *
 * @author guochao
 * @since 1.0.0
 */
public class RoleIntercept implements HandlerInterceptor {

    @Autowired
    private MenuService menuService;
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        try {
            //redis 获取登录信息
            String result = redisTemplate.opsForValue().get("admin:login");
            if (result == null) {
                request.getRequestDispatcher("/check").forward(request, response);
                return false;
            }
            MenuQuery query = new MenuQuery();
            query.setStatus(StatusEnum.NORMAL.getCode());
            query.setUserId(Integer.parseInt(result));
            List<Menu> list = menuService.menuList(query);
            //请求url   /police-admin/sys/auth/menu
            String url = request.getRequestURI();
            boolean have = false;
            for (Menu menu : list) {
                if (CommonUtil.include(menu.getUrl(), url)) {
                    have = true;
                }
            }
            if (have) {
                return true;
            } else {
                request.getRequestDispatcher("/auth").forward(request, response);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/check").forward(request, response);
            return false;
        }
    }
}
