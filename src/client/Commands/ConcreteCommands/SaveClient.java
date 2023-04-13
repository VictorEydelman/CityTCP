package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import client.Commands.Receiver;

/**
 * Class for a command that saves a collection to a file
 */
public class SaveClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public SaveClient(Receiver receiver){
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
    public void Information(){
        System.out.println("Команда save - сохранить коллекцию в файл.");
    }
}