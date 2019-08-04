package cc.wenjun.controller;

import cc.wenjun.common.client.RedisClient;
import cc.wenjun.util.AjaxResult;
import cc.wenjun.util.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController implements RedisClient {
    @PostMapping("/redis")
    public AjaxResult set(@RequestParam("key") String key, @RequestParam("value") String value) {
        try {
            RedisUtils.INSTANCE.set(key,value);
            return AjaxResult.ajax().setSuccess(true).setMessage("保存成功了！！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.ajax().setSuccess(false).setMessage("保存失败了"+e.getMessage());

        }
    }

    @GetMapping("/redis")
    public AjaxResult get(@RequestParam("key") String key) {
        try {
            String value = RedisUtils.INSTANCE.get(key);
            return AjaxResult.ajax().setSuccess(true).setMessage("保存成功了！！！").setRestObj(value);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.ajax().setSuccess(false).setMessage("保存失败了！！！"+e.getMessage());
        }
    }
}
