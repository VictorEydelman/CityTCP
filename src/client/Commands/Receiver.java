package client.Commands;

import Common.ConcreteCommands.*;
import Common.Serialized.Seri;
import Common.Serialized.Seriobject;
import Common.Serialized.Seritwo;
import Server.Collections.City;
import Server.Collections.StandardOfLiving;
import Server.Commands.ReceiverServer;
import Server.Parser.CSVWriter;
import Server.Parser.WorkWithTreeMap;
import client.Commands.ConcreteCommands.Additional.IdToKey;
import client.write.send;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.*;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 * Class for describing the logic of commands
 */
public class Receiver implements Serializable {
    private final Invoker invoker;
    private static Map<Integer, City> map;
    private static ZonedDateTime creationDate;
    private static Path path;
    private static int NumberLine;
    private static int CommandNumber=0;


    /**
     * Method for
     *
     * @param invoker  invoker
     */
    public Receiver(Invoker invoker){
        this.invoker=invoker;

    }

    /**
     * Method for determining the time of collection creation
     */
    public static void creationTree(){
        if (map==null){
            creationDate=ZonedDateTime.now();
        }
        map=new TreeMap<>();
    }

    /**
     * Method for get map name
     * @return map.getClass().getName()
     */
    public static String getName(){
        return map.getClass().getName();
    }

    /**
     * Method for creation date
     * @return creationDate
     */
    public static ZonedDateTime getcreatTime(){
        return creationDate;
    }

    /**
     * Method for get map size
     * @return map.size()
     */
    public static int getsize(){
        return map.size();
    }

    /**
     * Method for get all elements
     * @return list of all elements
     */
    public static String getAllElements(){
        String list="";
        for (Map.Entry<Integer,City> entry:map.entrySet()) {
            list += entry.getKey() + " = ";
            list += entry.getValue();
            list += '\n';
        }
        return list;
    }

    /**
     * Method for get map
     * @return map
     */
    public static Map<Integer,City> getmap(){
        return map;
    }

    /**
     * Command implementation help
     */
    public void Help() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new Help(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation info
     */
    public void Info() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new Info(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation insert
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Insert(int arg) throws ParseException, IOException {
        //send.send(new Seri(new Insert(new Receiver(invoker))));
    }

    /**
     * Command implementation update
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Update(int arg) throws ParseException, IOException {
        int key = IdToKey.getKey(map, arg);
        ArrayList<String> m = Invoker.getCommandHistory();
        if (m.get(m.size() - CommandNumber - 1).equals("execute_script")) {
            WorkWithTreeMap.ReplaceTreeMap(map, key, CreatCollection.creatCollectionExecute());
        } else {
            WorkWithTreeMap.ReplaceTreeMap(map, key, CreatCollection.creatCollection());
        }
        System.out.println("Элемент с id равным " + arg + " заменён в коллекции");
    }

    /**
     * Command implementation execute_script
     * @param file file name
     * @throws IOException mistake
     */
    public void Execute(String file) throws IOException {
        Invoker invoker = new Invoker();
        path = Paths.get(file);
        CommandNumber = 0;
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                ArrayList<String> m = Invoker.getCommandHistory();
                CommandNumber++;
                invoker.executeCommand(scanner.nextLine().trim().split(" "));
                if (m.get(m.size() - 1).equals("insert") || m.get(m.size() - 1).equals("update_id")) {
                    for (int i = 0; i < NumberLine - 2; i++) {
                        scanner.nextLine();
                    }
                }
                NumberLine = 0;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException ex) {
            System.out.println("Ошибка в вводе команды");
        }
    }

    /**
     * Command implementation history
     */
    public void History() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new History(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation remove_greater_key
     * @param key key
     */
    public void RemoveGreater(int key) throws IOException {
        try {
            send.send(new Seritwo( new RemoveGreaterKey(new ReceiverServer(invoker)),key));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Command implementation remove_lower_key
     * @param key key
     */
    public void RemoveLower(int key) throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seritwo( new RemoveLowerKey(new ReceiverServer(invoker)),key));
    }

    /**
     * Command implementation max_by_meters_above_sea_level
     */
    public void MaxMeters() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new MaxMeters(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation filter_less_than_standard_of_living
     * @param standard StandardOfLiving
     */
    public void FilterStandardOfLiving(StandardOfLiving standard) throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seriobject(new FilterStandardOfLiving(new ReceiverServer(invoker)),standard));
    }

    /**
     * Command implementation print_ascending
     */
    public void PrintAscending() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new PrintAscending(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation show
     */
    public void Show() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new Show(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation remove_key
     * @param arg argument
     */
    public void RemoveKey(int arg) throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seritwo(new RemoveKey(new ReceiverServer(invoker)),arg));
    }

    /**
     * Command implementation clear
     */
    public void Clear() throws IOException, ClassNotFoundException, InterruptedException {
        send.send(new Seri(new Clear(new ReceiverServer(invoker))));
    }

    /**
     * Command implementation exit
     */
    public void Exit(){
        System.exit(0);
    }

    /**
     * Command implementation save
     */
    public void Save() {
        CSVWriter.Writer(map);
        System.out.println("Коллекция сохранена");
    }
}