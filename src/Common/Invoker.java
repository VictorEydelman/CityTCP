package client.Commands;

import Common.interfase.Command;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Class that execute commands, stores the registered commands and a list of the last called commands
 */
public class Invoker implements Serializable {
    private static final ArrayList<String> CommandHistory = new ArrayList<>();

    private static final HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Method for stores registered commands
     * @param commandName command name
     * @param command command
     */
    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    /**
     * Method for determining which team should work and writing the team to the history
     * @param commandName command name
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void executeCommand(String[] commandName) throws ParseException, IOException, NoSuchElementException {
        try {
            if (commandName.length>0) {
                CommandHistory.add(commandName[0]);
                Command command = commandMap.get(commandName[0]);
                System.out.println(commandMap);
                System.out.println(command);
                command.execute(commandName);
            } else {
                System.out.println("Вы не ввели команду.");
            }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("Не существует команды " + commandName[0] + ". Для справки используйте - help");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for get commandMap
     * @return commandMap
     */
    public static HashMap<String, Command> getCommandMap(){
        System.out.println(commandMap);
        return commandMap;
    }

    /**
     * Method for get commandHistory
     * @return commandHistory
     */
    public static ArrayList<String> getCommandHistory(){
        return CommandHistory;
    }
}