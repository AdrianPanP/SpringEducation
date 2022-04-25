package spring.dependencyInjectionContainer;

import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class ConsoleMessageProducer implements MessageProducer{
    Scanner sc = new Scanner(System.in);

    @Override
    public String getMessage() {
        System.out.println("Wywołano klasę ConsoleMessageProducer");
        System.out.println("Napisz coś");
        return sc.nextLine();
    }
}

