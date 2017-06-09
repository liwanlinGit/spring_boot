package cn.desc.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("cn.desc.www.mapper")
/*@ImportResource(locations={"classpath:spring-redis.xml"}) //   RedisConfig 类 等于spring-redis.xml配置*/
public class Applicationewwrs {
  public static void main(String[] args) {
		SpringApplication.run(Applicationewwrs.class);
	}
}
