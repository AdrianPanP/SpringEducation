package spring.dependencyInjectionContainer;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Iterator;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        //wypisanie wszystkich obiektów znajdujacych sie w kontenerze wstrzykiwania zależności
        Arrays.stream(context.getBeanDefinitionNames())
                .map(context::getBean)
                .forEach(System.out::println);
        System.out.println("---------------------------------");


        MessagePrinter bean = context.getBean(MessagePrinter.class);
        bean.printMessage();
    }
}
