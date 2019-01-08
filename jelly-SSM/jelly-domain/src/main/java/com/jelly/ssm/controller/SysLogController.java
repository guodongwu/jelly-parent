package com.jelly.ssm.controller;


import com.jelly.ssm.entity.Log;
import com.jelly.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private LogService logService;
    @GetMapping("/index")
    public  String Index(){
        List<Log> logList=new ArrayList<>();
        for (int i=0;i<10;i++){
            Log log=new Log();
            log.setBasePath("aa");
            log.setDescription("大吾昂");
            log.setResult("成功");
            logList.add(log);
        }
        logService.insertBatch(logList);
        return  "OK";

    }
}
