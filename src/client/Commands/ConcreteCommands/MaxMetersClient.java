package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import client.Commands.Receiver;

import java.io.IOException;

/**
 * Class for a command that outputs a collection item whose metersAboveSeaLevel field value is the maximum
 */
public class MaxMetersClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public MaxMetersClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException, ClassNotFoundException {
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде max_by_meters_above_sea_level");
        }
        try {
            receiver.MaxMeters();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда max_by_meters_above_sea_level - вывести любой элемент из коллекции, значение поля metersAboveSeaLevel которого является максимальным.";
    }
}