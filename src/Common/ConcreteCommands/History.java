package Common.ConcreteCommands;

import Common.SeriMessage;
import Server.Commands.ReceiverServer;
import Common.interfase.Command;
import Server.ServerCity;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class for the command that outputs the last 10 commands
 */
public class History implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public History(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде history");
        }
        receiver.History();
    }

    /**
     * Method with information
     */
    @Override
    public void Information() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Команда history - команда позволяет увидеть" +
                " последние 10 выполненных команд."));
    }
}