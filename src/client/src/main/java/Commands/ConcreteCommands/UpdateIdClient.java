package client.src.main.java.Commands.ConcreteCommands;

import Common.src.main.java.interfase.Command;
import client.src.main.java.Commands.Receiver;

import java.io.IOException;
import java.text.ParseException;

/**
 * Сlass for the command that updates the collection item
 */
public class UpdateIdClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public UpdateIdClient(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Method execute
     * @param args arg
     * @throws ParseException mistake
     */
    @Override
    public void execute(String[] args) throws ParseException {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            receiver.Update(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
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