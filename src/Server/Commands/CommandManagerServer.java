package Server.Commands;

import Common.ConcreteCommands.*;
import client.Commands.Invoker;

import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for recording which commands exist and reading which command was received at the input
 */
public class CommandManagerServer {
    /**
     * Method for recording which commands exist and reading which command was received at the input
     * @throws IOException mistake
     */
     public static void start() throws IOException {
         Invoker invoker = new Invoker();
         ReceiverServer r = new ReceiverServer(invoker);
         invoker.register("help", new Help(r));
         invoker.register("info", new Info(r));
         invoker.register("show", new Show(r));
         invoker.register("insert", new Insert(r));
         invoker.register("update_id", new UpdateId(r));
         invoker.register("remove_key", new RemoveKey(r));
         invoker.register("clear", new Clear(r));
         invoker.register("save", new Save(r));
         invoker.register("execute_script", new ExecuteScript(r));
         invoker.register("exit", new Exit(r));
         invoker.register("history", new History(r));
         invoker.register("remove_greater_key", new RemoveGreaterKey(r));
         invoker.register("remove_lower_key", new RemoveLowerKey(r));
         invoker.register("max_by_meters_above_sea_level", new MaxMeters(r));
         invoker.register("filter_less_than_standard_of_living", new FilterStandardOfLiving(r));
         invoker.register("print_ascending", new PrintAscending(r));
     }
     public static void Scan() throws IOException {
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