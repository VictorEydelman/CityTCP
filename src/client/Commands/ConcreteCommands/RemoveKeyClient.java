package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import client.Commands.Receiver;

import java.io.IOException;

/**
 * Class for a command that deletes a collection item by its key
 */
public class RemoveKeyClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public RemoveKeyClient(Receiver receiver){
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
            try {
                receiver.RemoveKey(Integer.parseInt(args[1]));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (NumberFormatException ex){
            System.out.println("Введено не число в качестве ключа");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда remove_key - удаление элемента коллекции по его ключу.");
    }
}