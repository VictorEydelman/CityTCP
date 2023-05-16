package sr.Commands;

import ConcreteCommands.*;
import interfase.Invoker;
import interfase.ReceiverServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Class for recording which commands exist and reading which command was received at the input
 */
public class CommandManagerServer {

    static Logger logger = LogManager.getLogger(CommandManagerServer.class);
    /**
     * Method for recording which commands exist and reading which command was received at the input
     * @throws IOException mistake
     */
     public static void start() {
         Invoker invoker = new Invoker();
         ReceiverServer r = new ReceiverServer(invoker);
         invoker.register("help", new Help(r));
         invoker.register("info", new Info(r));
         invoker.register("show", new Show(r));
         invoker.register("insert", new Insert(r));
         invoker.register("update_id", new UpdateId(r));
         invoker.register("remove_key", new RemoveKey(r));
         invoker.register("execute_script", new ExecuteScript(r));
         invoker.register("exit", new Exit(r));
         invoker.register("history", new History(r));
         invoker.register("remove_greater_key", new RemoveGreaterKey(r));
         invoker.register("remove_lower_key", new RemoveLowerKey(r));
         invoker.register("max_by_meters_above_sea_level", new MaxMeters(r));
         invoker.register("filter_less_than_standard_of_living", new FilterStandardOfLiving(r));
         invoker.register("print_ascending", new PrintAscending(r));
         logger.info("Все команды загружены");
     }
}