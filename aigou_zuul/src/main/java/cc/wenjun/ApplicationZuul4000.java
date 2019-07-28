package cc.wenjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ApplicationZuul4000
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApplicationZuul4000.class,args);
    }
}
