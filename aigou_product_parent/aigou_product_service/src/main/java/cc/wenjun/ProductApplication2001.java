package cc.wenjun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients(basePackages = "cc.wenjun.common.client")
@MapperScan("cc.wenjun.mapper")
public class ProductApplication2001
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProductApplication2001.class,args);
    }
}
