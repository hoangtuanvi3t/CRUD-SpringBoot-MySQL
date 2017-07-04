package basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring boot app - easier way to create a spring based app
 *
 */

@SpringBootApplication  // = @Configuration, @EnableAutoConfiguration and @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}