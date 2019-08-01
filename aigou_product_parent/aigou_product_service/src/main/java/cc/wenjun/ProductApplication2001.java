package cc.wenjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductApplication2001
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProductApplication2001.class,args);
    }
}
