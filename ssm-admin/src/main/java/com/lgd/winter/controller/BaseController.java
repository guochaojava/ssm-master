package com.lgd.winter.controller;

import cn.hutool.core.util.ImageUtil;
import cn.hutool.setting.dialect.Props;
import com.lgd.winter.enums.FileTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 基础控制器
 *
 * @author guochao
 * @since 1.0.0
 */
public abstract class BaseController {

    /**
     * 获取项目基本路径
     *
     * @param request 请求对象
     * @return 项目基本路径
     */
    public String getBaseUrl(HttpServletRequest request) {
        String appContext = request.getContextPath();
        StringBuilder basePath = new StringBuilder();
        basePath.append(request.getScheme()).append("://");
        basePath.append(request.getServerName());
        if (request.getServerPort() != 80) {
            basePath.append(":").append(request.getServerPort());
        }
        basePath.append(appContext);
        return basePath.toString();
    }


    /**
     * 本地保存文件
     *
     * @param file     上传文件对象
     * @param type     文件类型
     * @param fileName 文件名称
     * @return 文件路径
     * @throws Exception
     */
    public String saveFiles(MultipartFile file, String type, String fileName) throws Exception {
        String basePath = ""; // 基本路径 用于生成文件
        String path = ""; // 相对路径 用于返回路径并持久化
        String classifyPath = getUploadPath(); // eg: \2017\4\

        Props props = new Props("config.properties");
        basePath = props.getProperty("wUploadFilePath");

        if (FileTypeEnum.HEAD.getType().equals(type)) {
            path = "/head" + classifyPath;
        }
        if (FileTypeEnum.BANNER.getType().equals(type)) {
            path = "/banner" + classifyPath;
        }
        if (FileTypeEnum.ARTICLE.getType().equals(type)) {
            path = "/article" + classifyPath;
        }
        if (FileTypeEnum.COVER.getType().equals(type)) {
            path = "/cover" + classifyPath;
        }

        if ("file".equals(type)) {
            path = "/file" + classifyPath;
        }

        File targetFile = new File(basePath + path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        file.transferTo(targetFile);
        // 获取文件大小：  单位 b
        long fileSize = file.getSize();
        String[] tem = fileName.split("\\.");
        if ("jpg".equalsIgnoreCase(tem[1]) || "png".equalsIgnoreCase(tem[1]) || "gif".equalsIgnoreCase(tem[1])
                || "jepg".equalsIgnoreCase(tem[1])) {
            if (fileSize > 300000) {
                //缩放文件
                ImageUtil.scale(targetFile, targetFile, (float) 1);
            }
        }
        return "/upload" + path + "/" + fileName;
    }

    /**
     * 获取上传路径
     *
     * @return 上传路径
     */
    public static String getUploadPath() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = (calendar.get(Calendar.MONTH) + 1);
        String path = "/" + year + "/" + month;
        return path;
    }

    /**
     * 重命名文件
     *
     * @param fileName 源文件名称
     * @return 新文件名
     */
    public static String generateFileName(String fileName) {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
        return formatDate + random + extension;
    }
}
