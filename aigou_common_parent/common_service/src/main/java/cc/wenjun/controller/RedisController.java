package cc.wenjun.controller;

import cc.wenjun.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @PostMapping("/redis")
    public AjaxResult set(@RequestParam("key")String key, @RequestParam("value") String value){
       return null;
    }
}
