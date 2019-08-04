package cc.wenjun.common.client;


import cc.wenjun.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class StaticPageFallBackFactory implements FallbackFactory<StaticPageClient> {
    @Override
    public StaticPageClient create(Throwable throwable) {
        return new StaticPageClient() {
            @Override
            public AjaxResult genStaticPage(Map<String, Object> map) {
                return AjaxResult.ajax().setSuccess(false).setMessage("系统异常!");
            }
        };
    }
}
