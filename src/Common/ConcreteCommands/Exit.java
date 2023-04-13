package Common.ConcreteCommands;

import Common.SeriMessage;
import Common.interfase.Command;
import Server.Commands.ReceiverServer;
import Server.ServerCity;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class for the team that exits the program
 */
public class Exit implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Exit(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде exit");
        }
        receiver.Exit();
    }

    /**
     * Method with information
     */
    @Override
    public void Information() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Команда exit - завершение программы."));
    }
}