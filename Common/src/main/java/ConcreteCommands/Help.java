package ConcreteCommands;

import interfase.Command;
import sr.Commands.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that displays a list of available commands
 */
public class Help implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Help(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде help");
        }
        receiver.Help();
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда help - получить справку по всем доступным командам.";
    }
}