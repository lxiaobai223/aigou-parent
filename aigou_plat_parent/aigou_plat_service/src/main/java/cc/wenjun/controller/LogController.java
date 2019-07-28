package cc.wenjun.controller;

import cc.wenjun.domain.User;
import cc.wenjun.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
/*@RequestMapping(value = "/login",method = RequestMethod.GET)*/
@PostMapping("/login")

    public AjaxResult login(User user){
String username=user.getUsername();
String password=user.getPassword();
if("admin".equals(username)&&"admin".equals(password)){
    return AjaxResult.ajax().setSuccess(true).setMessage("登录成功！！！");
}
return AjaxResult.ajax().setSuccess(false).setMessage("登录失败！！");
    }
}
