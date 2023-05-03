package client.src.main.java.Commands.ConcreteCommands;

import Common.src.main.java.interfase.Command;
import client.src.main.java.Commands.Receiver;

import java.io.IOException;

/**
 * Class for the command that outputs the last 10 commands
 */
public class HistoryClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public HistoryClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде history");
        }
        try {
            receiver.History();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда history - команда позволяет увидеть последние 10 выполненных команд.";
    }
}