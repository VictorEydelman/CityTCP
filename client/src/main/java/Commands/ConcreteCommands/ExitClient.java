package Commands.ConcreteCommands;

import Commands.Receiver;
import interfase.Command;

/**
 * Class for the team that exits the program
 */
public class ExitClient implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public ExitClient(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде exit");
        }
        receiver.Exit();
    }

    /**
     * Method with information
     */
    @Override
    public String Information(){
        return "Команда exit - завершение программы.";
    }
}