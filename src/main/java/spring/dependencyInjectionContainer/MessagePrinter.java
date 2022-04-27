package spring.dependencyInjectionContainer;

import org.springframework.stereotype.Service;
import spring.dependencyInjectionContainer.producer.MessageProducer;

import java.util.function.Function;

@Service
public class MessagePrinter {
    MessageProducer messageProducer;
    MessagePrinterConfig printerConfig;

    public MessagePrinter(MessageProducer messageProducer, MessagePrinterConfig printerConfig) {
        this.messageProducer = messageProducer;
        this.printerConfig = printerConfig;
    }

    public void printMessage(){
        String message = messageProducer.getMessage();
        Function<String, String> decorator = printerConfig.getDecorator();
        String decoratedMessage = decorator.apply(message);
        System.out.println(decoratedMessage);
    }
}
