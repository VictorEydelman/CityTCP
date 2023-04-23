package client.Commands;

import Common.Invoker;
import client.Commands.ConcreteCommands.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for recording which commands exist and reading which command was received at the input
 */
public class CommandManager {
    /**
     * Method for recording which commands exist and reading which command was received at the input
     */
     public static void start() {
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
    static ArrayList<String> filehistory=new ArrayList<>();
     public static void Scan() throws IOException{
         Invoker invoker = new Invoker();
         try (Scanner sc = new Scanner(System.in)) {
             filehistory=new ArrayList<>();
             System.out.print(">");
             while (true) {
                 String[] s = sc.nextLine().trim().split(" ");
                 invoker.executeCommand(s);
                 filehistory=new ArrayList<>();
                 System.out.print(">");
             }
         } catch (NoSuchElementException ex) {
             System.out.println("Вы ввели выход из программы");
             System.exit(0);
         } catch (ParseException e) {
             throw new RuntimeException(e);
         }
     }
     public static void setFile(String m){
         filehistory.add(m);
     }
     public static ArrayList<String> getFile(String file){
         return filehistory;
     }
}