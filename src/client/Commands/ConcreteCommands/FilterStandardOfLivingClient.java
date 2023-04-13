package client.Commands.ConcreteCommands;

import Common.interfase.Command;
import Server.Collections.StandardOfLiving;
import client.Commands.Receiver;

import java.io.IOException;

/**
 * Class for a command that outputs all elements of a collection whose standardOfLiving field value is less than the specified one
 */
public class FilterStandardOfLivingClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public FilterStandardOfLivingClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде filter_less_than_standard_of_living");
            }
            receiver.FilterStandardOfLiving(StandardOfLiving.valueOf(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Не введён ключ для создания коллекции");
        } catch (IllegalArgumentException ex){
            System.out.println("Введён не правильное значение StandardOfLiving");
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
    public void Information(){
        System.out.println("Команда filter_less_than_standard_of_living - она выводит элементы, значение поля standardOfLiving которых меньше заданного." +
                "Формат ввода: filter_less_than_standard_of_living standardOfLiving(VERY-HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE");
    }
}