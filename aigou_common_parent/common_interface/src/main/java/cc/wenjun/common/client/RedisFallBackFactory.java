package cc.wenjun.common.client;

import cc.wenjun.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisFallBackFactory implements FallbackFactory<RedisClient> {

    @Override
    public RedisClient create(Throwable throwable) {
        return new RedisClient() {
            @Override
            public AjaxResult set(String key, String value) {
                return AjaxResult.ajax().setSuccess(false).setMessage("系统出错了，，请联系管理员");
            }

            @Override
            public AjaxResult get(String key) {
                return AjaxResult.ajax().setSuccess(false).setMessage("系统出错了，，请联系管理员");
            }
        };

    }
}
