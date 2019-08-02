package cc.wenjun.controller;

import cc.wenjun.domain.User;
import cc.wenjun.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
@PostMapping("/login")
    public AjaxResult login(@RequestBody User user){
    System.out.println(user);
    String username=user.getUsername();
String password=user.getPassword();
if("admin".equals(username)&&"admin".equals(password)){
    return AjaxResult.ajax().setSuccess(true).setMessage("登录成功！！！").setRestObj(user);
}
return AjaxResult.ajax().setSuccess(false).setMessage("登录失败！！");
    }
}
