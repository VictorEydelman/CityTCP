package Commands.ConcreteCommands;

import Commands.Receiver;
import interfase.Command;

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда insert - создаёт новый элемент коллекции. Формат ввода: insert key";
    }
}