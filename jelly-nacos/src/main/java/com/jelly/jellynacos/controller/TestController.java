package com.jelly.jellynacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.jelly.jellynacos.dao.UserRepository;
import com.jelly.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RefreshScope
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public boolean test(@RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) id = "1";
        String url = String.format("http://jellyprovider/user?id=" + id);
        log.info("port:" + port);
        String url2 = String.format("http://jellyconsumer/user?id=" + id);
        log.info("port:" + port);
        String a = restTemplate.getForObject(url, String.class);
        String b = restTemplate.getForObject(url2, String.class);
        return a.equals(b);
    }

    @PutMapping("/user")
    public String userSave(User user) {
        User u = userRepository.save(user);
        return u.toString();
    }

    @GetMapping("/user")
    public String getUserById(User user) {
        User u = userRepository.getOne(user.getId());
        return u.toString();
    }

    @NacosInjected
    private NamingService namingService;


    @RequestMapping(value = "/set")
    public String set(@RequestParam String serviceName) {
        try {
            namingService.registerInstance(serviceName, "jelly", "192.168.7.11", 8080); // 注册中心的地址
            return "OK";
        } catch (NacosException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }

    @RequestMapping(value = "/get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
