package com.lgd.winter.util;

import freemarker.template.Configuration;


/**
 * freemarker模版配置类
 *
 * @author guochao
 * @since 1.0.0
 */
public class FreemarkerConfiguration {
    private static Configuration config = null;

    /**
     * Static initialization.
     *
     * Initialize the configuration of Freemarker.
     */
    static {
        config = new Configuration();
        config.setClassForTemplateLoading(FreemarkerConfiguration.class, "/../ftl/");
        config.setTemplateUpdateDelay(0);
    }

    public static Configuration getConfiguation() {
        return config;
    }
}
