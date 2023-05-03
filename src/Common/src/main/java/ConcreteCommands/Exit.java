package Common.src.main.java.ConcreteCommands;

import Common.src.main.java.interfase.Command;
import Server.src.main.java.Commands.ReceiverServer;

import java.io.IOException;

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
    public String Information() throws IOException {
        return "Команда exit - завершение программы.";
    }
}