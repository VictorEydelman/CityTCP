package Commands.ConcreteCommands;

import Commands.Receiver;
import interfase.Command;

import java.io.IOException;
import java.io.Serializable;

/**
 * Class for a command that displays a list of available commands
 */
public class HelpClient implements Command, Serializable {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public HelpClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде help");
        }
        try {
            receiver.Help();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда help - получить справку по всем доступным командам.";
    }
}