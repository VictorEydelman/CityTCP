package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import client.Commands.Receiver;

import java.io.IOException;

/**
 * Class for a command that outputs information about a collection
 */
public class InfoClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public InfoClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде info");
        }
        try {
            receiver.Info();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда info - получить информацию по коллекции.";
    }
}