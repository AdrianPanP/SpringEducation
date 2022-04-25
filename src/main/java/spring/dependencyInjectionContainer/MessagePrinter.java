package spring.dependencyInjectionContainer;

import org.springframework.stereotype.Service;

@Service
public class MessagePrinter {
    MessageProducer messageProducer;

    public MessagePrinter(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void printMessage(){
        System.out.println("Wywołano klasę MessagePrinter");
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
