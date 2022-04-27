package spring.dependencyInjectionContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import spring.dependencyInjectionContainer.exception.InvalidDecoratorException;

import java.util.function.Function;
@Configuration
public class MessagePrinterConfig {
    private final String decorator;

    public MessagePrinterConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }

    Function<String, String> getDecorator() throws InvalidDecoratorException {
        if (decorator.equals("LOWERCASE")){
            return String::toLowerCase;
        }else if (decorator.equals("UPPERCASE")){
            return String::toUpperCase;
        }
        throw new InvalidDecoratorException("No decorator for " + decorator);
    }
}
