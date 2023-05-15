package ConcreteCommands;

import interfase.Command;
import sr.Commands.ReceiverServer;

import java.io.IOException;
import java.text.ParseException;

/**
 * Сlass for the command that updates the collection item
 */
public class UpdateId implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public UpdateId(ReceiverServer receiver){
            this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     * @throws ParseException mistake
     */
    @Override
    public void execute(String[] args) throws ParseException {
        try {
            if (args.length > 15) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            boolean t = true;
            /*for (Map.Entry<Integer, City> entry : ReceiverServer.getmap().entrySet()) {
                if (entry.getKey().equals(args[1])) {
                    t = true;
                    break;
                }
            }*/
            if (t) {
                String[] newCollection=new String[args.length-2];
                for(int i=2;i<args.length;i++){
                    newCollection[i-2]=args[i];
                }
                receiver.Update(Integer.parseInt(args[1]),newCollection);
            } else{
                System.out.println("Введён элемент, которого нет в коллекции.");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public String Information() throws IOException {
        return "Команда update_id - обновляет элемент" +
                " коллекции по заданному id. Формат ввода: update_id id";
    }
}