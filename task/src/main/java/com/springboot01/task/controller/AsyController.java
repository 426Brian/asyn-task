package com.springboot01.task.controller;

import com.springboot01.task.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyController {
    @Autowired
    AsynService asynService;

    @RequestMapping("/hello")
    public String hello(){
        asynService.hello();
        return "success";
    }
}
