package Commands.ConcreteCommands;

import Commands.Receiver;
import interfase.Command;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Class for a command that reads commands from a specified file and sends them for execution
 */
public class ExecuteScriptClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public ExecuteScriptClient(Receiver receiver){
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
    public String Information(){
        return "Команда execute_script - она позволяет считывать команды из файла. Формат ввода: execute_script file_name";
    }
}