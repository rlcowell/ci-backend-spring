package aws.hack.ci;

import aws.hack.ci.config.AppConfig;
import aws.hack.ci.server.ServletContainerCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{AppConfig.class, ServletContainerCustomizer.class}, args);
    }
}
