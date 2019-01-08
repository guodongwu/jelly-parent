package com.jelly.jellyspringboot.api;

import com.jelly.jellyspringboot.view.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiTestController {
    @ApiOperation(value = "测试post请求",notes = "注意事项")
    @ApiImplicitParam(dataType = "User",name ="user",value = "用户信息",required = true)
    @PostMapping("/testPost")
    public  String testPost(@RequestBody User user){
        return "success";
    }


}
