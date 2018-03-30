package com.lgd.winter.bean;

import com.lgd.winter.enums.CodeMessageEnum;

public class Result {

    public static class ObjectResult extends Result {
        public Integer status;
        public String msg;
        public Object data;
        public String url = "";// 为空或不定义时不操作，为地址时跳转到相应地址，为reload是刷新页面

        public ObjectResult() {
        }

        private ObjectResult(Integer status, String msg) {
            this.status = status;
            this.msg = msg;
        }

        private ObjectResult(Integer status, String msg, Object data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }

        public ObjectResult reload() {
            this.url = "reload";
            return this;
        }

        public ObjectResult setUrl(String url) {
            this.url = url;
            return this;
        }

    }

    public static ObjectResult buildOK(String msg) {
        return new ObjectResult(CodeMessageEnum.OK.getCode(), msg);
    }

    public static ObjectResult buildOK(Object data, String msg) {
        return new ObjectResult(CodeMessageEnum.OK.getCode(), msg, data);
    }

    public static ObjectResult buildOK(Integer code, Object data, String msg) {
        return new ObjectResult(code, msg, data);
    }

    public static ObjectResult buildError() {
        return new ObjectResult(CodeMessageEnum.ERROR.getCode(), CodeMessageEnum.ERROR.getMessage());
    }

    public static ObjectResult buildError(Integer status, String msg) {
        return new ObjectResult(status, msg);
    }

    public static ObjectResult buildError(String msg) {
        return new ObjectResult(CodeMessageEnum.ERROR.getCode(), msg);
    }


    /**
     * @author alsm
     * @ClassName: ListResult
     * @Description: TODO
     * @date 2017年4月20日 上午11:04:37
     */
    public static class ListResult extends Result {
        public Integer status;
        public String msg;
        public Integer pages;
        public Long total;
        public Object data;
        public String url = "";// 为空或不定义时不操作，为地址时跳转到相应地址，为reload是刷新页面

        public ListResult() {
        }

        private ListResult(Integer status, String msg, Integer pages, Long total, Object data) {
            this.status = status;
            this.msg = msg;
            this.pages = pages;
            this.data = data;
            this.total = total;
        }

        public ListResult reload() {
            this.url = "reload";
            return this;
        }
    }

    public static ListResult buildOK(Integer pages, Long total, Object data) {
        return new ListResult(CodeMessageEnum.OK.getCode(), CodeMessageEnum.OK.getMessage(), pages, total, data);
    }
}
