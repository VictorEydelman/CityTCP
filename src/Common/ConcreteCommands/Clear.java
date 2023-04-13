package Common.ConcreteCommands;

import Common.SeriMessage;
import Server.Commands.ReceiverServer;
import Common.interfase.*;
import Server.ServerCity;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class for a command that deletes all elements of a collection
 */
public class Clear implements Command{
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Clear(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде clear");
        }
        receiver.Clear();
    }

    /**
     * Method with information
     */
    @Override
    public void Information() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Команда clear - удаляет все элементы коллекции."));
    }
}