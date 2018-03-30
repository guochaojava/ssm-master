package com.lgd.winter.api;

import com.lgd.winter.api.bean.Result;
import com.lgd.winter.exception.ApiExceptionHandleAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 测试接口
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@ApiIgnore
@RestController
public class TestApi extends ApiExceptionHandleAction {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object getUser() {

        return Result.ok("成功!");
    }
}