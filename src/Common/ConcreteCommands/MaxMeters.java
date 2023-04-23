package Common.ConcreteCommands;

import Common.interfase.Command;
import Server.Commands.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that outputs a collection item whose metersAboveSeaLevel field value is the maximum
 */
public class MaxMeters implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public MaxMeters(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде max_by_meters_above_sea_level");
        }
        receiver.MaxMeters();
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда max_by_meters_above_sea_level - вывести любой элемент из коллекции," +
                " значение поля metersAboveSeaLevel которого является максимальным.";
    }
}