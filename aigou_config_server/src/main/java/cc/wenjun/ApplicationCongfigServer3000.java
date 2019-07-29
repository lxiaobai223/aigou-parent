package cc.wenjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ApplicationCongfigServer3000
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApplicationCongfigServer3000.class,args);

    }
}
