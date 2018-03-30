package com.lgd.winter.util;

import com.lgd.winter.util.bean.MenuObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单数据处理工具类
 *
 * @author guochao
 * @since 1.0.0
 */
public class MenuObjectUtil {

    /**
     * 获取树形结构list
     *
     * @param list 需要转换的list（包含parentId的无限极list数据）
     * @return
     */
    public List<MenuObject> getChildMenuObjects(List<MenuObject> list) {
        List<MenuObject> returnList = new ArrayList<MenuObject>();
        for (Iterator<MenuObject> iterator = list.iterator(); iterator.hasNext(); ) {
            MenuObject t = (MenuObject) iterator.next();
            //根据父级ID 遍历childen list
            if (t.getPid().equals(0)) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }


    /**
     * 递归处理childen数据
     *
     * @param list 菜单list
     * @param t    父级菜单对象
     */
    private void recursionFn(List<MenuObject> list, MenuObject t) {
        List<MenuObject> childList = getChildList(list, t);
        t.setSub(childList);
        for (MenuObject tChild : childList) {
            if (hasChild(list, tChild)) {
                Iterator<MenuObject> it = childList.iterator();
                while (it.hasNext()) {
                    MenuObject n = (MenuObject) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }


    /**
     * 获取子节点list数据
     *
     * @param list 需要处理的list
     * @param t    父菜单对象
     * @return 子节点list数据
     */
    private List<MenuObject> getChildList(List<MenuObject> list, MenuObject t) {

        List<MenuObject> tlist = new ArrayList<MenuObject>();
        Iterator<MenuObject> it = list.iterator();
        while (it.hasNext()) {
            MenuObject n = (MenuObject) it.next();
            if (n.getPid().equals(t.getId())) {
                tlist.add(n);
            }
        }
        return tlist;
    }


    /**
     * 判断是否有子节点
     *
     * @param list 需要判断的list
     * @param t    父级菜单对象
     * @return 判断结果
     */
    private boolean hasChild(List<MenuObject> list, MenuObject t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }

}
