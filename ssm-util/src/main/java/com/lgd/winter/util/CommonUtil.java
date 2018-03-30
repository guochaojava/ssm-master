package com.lgd.winter.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 通用工具类
 *
 * @author GuoChao.
 * @since 1.0.0
 */
public class CommonUtil {

    /**
     * 获取属性文件属性
     *
     * @param key 属性key
     * @return 属性值
     */
    public static String findPropertiesKey(String key) {
        Props props = new Props("config.properties");
        return props.getProperty(key);
    }

    /**
     * 判断是否包含某字符串，含1级（/xxxx）
     *
     * @param baseStr    源字符串
     * @param compareStr 需要比较字符串
     * @return 判断结果
     */
    public static boolean include(String baseStr, String compareStr) {
        if (StrUtil.isEmpty(baseStr) || StrUtil.isEmpty(compareStr)) {
            return false;
        }
        if (StrUtil.getContainsStr(baseStr, compareStr) != null) {
            return true;
        } else {
            String[] tem = compareStr.split("/");
            int length = tem.length;
            if (length > 0 && !"auth".equals(tem[length - 2])) {
                String handleStr = StrUtil.subPre(compareStr, compareStr.toCharArray().length - tem[length - 1].toCharArray().length - 1);
                if (StrUtil.getContainsStr(baseStr, handleStr) != null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}