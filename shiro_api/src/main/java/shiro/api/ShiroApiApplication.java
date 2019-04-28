package shiro.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("shiro.dal.dao")
public class ShiroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApiApplication.class,args);
    }
}
