package cn.desc.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("cn.desc.www.mapper")
@Configuration
@ImportResource(locations={"classpath:spring-redis.xml"})
public class Applicationewwrs {
  public static void main(String[] args) {
		SpringApplication.run(Applicationewwrs.class);
	}
}
