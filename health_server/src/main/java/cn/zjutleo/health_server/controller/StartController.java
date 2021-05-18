package cn.zjutleo.health_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/9
 * @description: StartController
 */
@RestController
@RequestMapping("/start")
public class StartController {
    @RequestMapping("/springboot")
    public String startSpringBoot(){
        return "Health System!";
    }

}
