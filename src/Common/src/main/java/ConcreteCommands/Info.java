package Common.src.main.java.ConcreteCommands;

import Common.src.main.java.interfase.Command;
import Server.src.main.java.Commands.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that outputs information about a collection
 */
public class Info implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Info(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде info");
        }
        System.out.println(1);
        receiver.Info();
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда info - получить информацию по коллекции.";
    }
}