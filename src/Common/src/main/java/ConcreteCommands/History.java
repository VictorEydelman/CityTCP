package Common.src.main.java.ConcreteCommands;

import Common.src.main.java.interfase.Command;
import Server.src.main.java.Commands.ReceiverServer;

import java.io.IOException;

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
    public String Information() throws IOException {
        return "Команда history - команда позволяет увидеть" +
                " последние 10 выполненных команд.";
    }
}