package spring.dependencyInjectionContainer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.dependencyInjectionContainer.producer.MessageController;

import java.util.Arrays;
import java.util.Scanner;


@SpringBootApplication
@ConfigurationPropertiesScan
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .map(context::getBean)
                .forEach(System.out::println);

        MessageController bean = context.getBean(MessageController.class);
        bean.mainLoop();
    }

    @Bean
    Scanner scanner(){
        return new Scanner(System.in);
    }
}
