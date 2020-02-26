package com.xiaomi.controller;

import com.xiaomi.enums.ApiHttpCode;
import com.xiaomi.model.ApiResult;
import com.xiaomi.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
@Api(tags="测试用户")
public class TestController {

    @GetMapping(value = "testMethod", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "测试用户A")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value = "姓名"),
            @ApiImplicitParam(name="age", value = "年龄", required = true)
    })
    public ApiResult<List<User>> testMethod() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(18);
        user.setAddress("北京市朝阳区");
        list.add(user);

        User user1 = new User();
        user1.setId(2);
        user1.setName("李四");
        user1.setAge(18);
        user1.setAddress("北京市昌平区");
        list.add(user1);

        ApiResult<List<User>> result = ApiResult.ok(ApiHttpCode.SUCCESS, list);
        return result;
    }

}
