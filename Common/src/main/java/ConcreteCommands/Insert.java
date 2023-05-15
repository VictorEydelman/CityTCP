package ConcreteCommands;

import interfase.Command;
import sr.Commands.ReceiverServer;

import java.io.IOException;
import java.text.ParseException;

/**
 * Class for add new element of collection
 */
public class Insert implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Insert(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws ParseException, IOException {
        try {
            if (args.length > 15) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде insert null");
            }
            String[] newCollection=new String[args.length-2];
            for(int i=2;i<args.length;i++){
                newCollection[i-2]=args[i];
            }
            receiver.Insert(Integer.parseInt(args[1]),newCollection);
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
    public String Information() throws IOException {
        return "Команда insert - создаёт новый элемент коллекции." +
                " Формат ввода: insert key";
    }
}