package Common.ConcreteCommands;

import Common.interfase.Command;
import Server.Commands.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that saves a collection to a file
 */
public class Save implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Save(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде save");
        }
        receiver.Save();
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда save - сохранить коллекцию в файл.";
    }
}