package Common.ConcreteCommands;

import Common.SeriMessage;
import Server.Commands.ReceiverServer;
import Common.interfase.Command;
import Server.ServerCity;

import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void Information() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Команда print_ascending - выводит" +
                " элементы коллекции в порядке возрастания."));
    }
}