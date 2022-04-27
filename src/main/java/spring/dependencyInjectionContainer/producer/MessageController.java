package spring.dependencyInjectionContainer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.dependencyInjectionContainer.MessagePrinter;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Controller
public class MessageController {
    private final Scanner scanner;
    private final MessagePrinter messagePrinter;

    @Autowired
    public MessageController(Scanner scanner, MessagePrinter messagePrinter) {
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
    }

    public void mainLoop(){
        Option option;
        do {
            option = choseOption();
            executeOption(option);

            }while(option !=Option.EXIT);
        }

    private void executeOption(Option option) {
        switch (option){
            case NEXT_MESSAGE -> printMessage();
            case EXIT -> exit();
        }
    }

    private void exit() {
        System.out.println("Koniec programu!");
    }

    private void printMessage() {
        messagePrinter.printMessage();
    }

    private Option choseOption() {
        Optional<Option> option;
        do {
            printOptions();
            int optionNumber = scanner.nextInt();
            scanner.nextLine();
            option = Option.fromInt(optionNumber);
        }while (option.isEmpty());
        return option.get();
    }

    private void printOptions() {
        System.out.println("Opcje:");
        Option[] values = Option.values();
        for (Option value : values) {
            System.out.println(value);
        }
    }
}

enum Option{
    EXIT(0,"Wyjście z programu"),
    NEXT_MESSAGE(1, "Wczytaj kolejny komunikat");
    private final int number;
    private final String description;

    Option(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static Optional<Option> fromInt(int optionNumber) {
        Option[] options = Option.values();
        if (optionNumber >= 0 && optionNumber < options.length){
            return Optional.of(options[optionNumber]);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return number + " - " + description;
    }
}
