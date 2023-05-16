package ConcreteCommands;

import interfase.Command;
import interfase.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that outputs the elements of a collection in ascending order
 */
public class PrintAscending implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public PrintAscending(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде print_ascending");
        }
        receiver.PrintAscending();
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда print_ascending - выводит" +
                " элементы коллекции в порядке возрастания.";
    }
}