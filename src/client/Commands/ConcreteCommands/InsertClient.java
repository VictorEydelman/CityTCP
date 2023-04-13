package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import client.Commands.Receiver;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

/**
 * Class for add new element of collection
 */
public class InsertClient implements Command, Serializable {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public InsertClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws ParseException, IOException {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде insert null");
            }
            receiver.Insert(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex){
            System.out.println("Не введён или не правильно введён ключ для создания коллекции");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда insert - создаёт новый элемент коллекции. Формат ввода: insert key");
    }
}