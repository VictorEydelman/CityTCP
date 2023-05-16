package Commands.ConcreteCommands;

import Commands.Receiver;
import interfase.Command;

import java.io.IOException;

/**
 * Class for a command that shows all the elements of a collection
 */
public class ShowClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public ShowClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде show");
        }
        try {
            receiver.Show();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда show - вывод всех элементов коллекции.";
    }
}