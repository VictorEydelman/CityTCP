package ConcreteCommands;

import interfase.Command;
import interfase.ReceiverServer;

import java.io.IOException;

/**
 * Class for a command that deletes a collection item by its key
 */
public class RemoveKey implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public RemoveKey(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_key null.");
            }
            receiver.RemoveKey(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (NumberFormatException ex){
            System.out.println("Введено не число в качестве ключа");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда remove_key - удаление элемента коллекции по его ключу.";
    }
}