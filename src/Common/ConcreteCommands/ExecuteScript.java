package Common.ConcreteCommands;

import Common.SeriMessage;
import Common.interfase.Command;
import Server.Commands.ReceiverServer;
import Server.ServerCity;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;

/**
 * Class for a command that reads commands from a specified file and sends them for execution
 */
public class ExecuteScript implements Command {
    private final ReceiverServer receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public ExecuteScript(ReceiverServer receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) throws IOException {
        try {
            if (args.length == 2) {
                receiver.Execute(args[1]);
            } else {
                System.out.println("Некорректное количество аргументов. Для справки напишите help.");
            }
        } catch (StackOverflowError ex){
            System.out.println("Обнаружен выход за переделы стека.");
        } catch (NoSuchFileException ex) {
            System.out.println("Не введено название файла");
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Команда execute_script - она позволяет считывать команды из файла." +
                " Формат ввода: execute_script file_name"));
    }
}