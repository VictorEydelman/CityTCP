package client.Commands;

import client.Commands.ConcreteCommands.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for recording which commands exist and reading which command was received at the input
 */
public class CommandManager {
    /**
     * Method for recording which commands exist and reading which command was received at the input
     * @throws IOException mistake
     */
     public static void start() throws IOException {
         Invoker invoker = new Invoker();
         Receiver r = new Receiver(invoker);
         invoker.register("help", new HelpClient(r));
         invoker.register("info", new InfoClient(r));
         invoker.register("show", new ShowClient(r));
         invoker.register("insert", new InsertClient(r));
         invoker.register("update_id", new UpdateIdClient(r));
         invoker.register("remove_key", new RemoveKeyClient(r));
         invoker.register("clear", new ClearClient(r));
         invoker.register("save", new SaveClient(r));
         invoker.register("execute_script", new ExecuteScriptClient(r));
         invoker.register("exit", new ExitClient(r));
         invoker.register("history", new HistoryClient(r));
         invoker.register("remove_greater_key", new RemoveGreaterKeyClient(r));
         invoker.register("remove_lower_key", new RemoveLowerKeyClient(r));
         invoker.register("max_by_meters_above_sea_level", new MaxMetersClient(r));
         invoker.register("filter_less_than_standard_of_living", new FilterStandardOfLivingClient(r));
         invoker.register("print_ascending", new PrintAscendingClient(r));
     }
     public static void Scan() throws IOException{
         Invoker invoker = new Invoker();
         try (Scanner sc = new Scanner(System.in)) {
             System.out.print(">");
             while (true) {
                 String[] s= sc.nextLine().trim().split(" ");
                 System.out.println(s);
                 invoker.executeCommand(s);
                 System.out.print(">");
             }
         } catch (NoSuchElementException ex) {
             System.out.println("Вы ввели выход из программы");
             System.exit(0);
         } catch (ParseException e) {
             throw new RuntimeException(e);
         }
     }
}