package Server.Commands;

import Common.SeriMessage;
import Server.Collections.City;
import Server.Collections.StandardOfLiving;
import Common.ConcreteCommands.Additional.IdToKey;
import Common.ConcreteCommands.Additional.StandardToInt;
import Server.Parser.CSVWriter;
import Server.Parser.WorkWithTreeMap;
import Server.ServerCity;
import client.Commands.CreatCollection;
import client.Commands.Invoker;
import client.write.write;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class ReceiverServer implements Serializable {
    private final Invoker invoker;
    private static Map<Integer, City> map;
    private static ZonedDateTime creationDate;
    private static Path path;
    private static int NumberLine;
    private static int CommandNumber=0;
    private static DataOutputStream douts;

    static {
        try {
            douts = write.gets();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for
     * @param invoker invoker
     */
    public ReceiverServer(Invoker invoker) {
        this.invoker = invoker;
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
    public void Help(){
        invoker.getCommandMap().forEach((commandname,command)-> {
            try {
                System.out.println(command);
                command.Information();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("yes");
    }

    /**
     * Command implementation info
     */
    public void Info() throws IOException {
        //System.out.println(ServerCity.getss());
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Тип коллекции - "+ReceiverServer.getName()+"\n"
                +"Дата и время инициализации - "+ReceiverServer.getcreatTime()+"\n"+
                "Количество элементов коллекции - "+ReceiverServer.getsize()));
    }

    /**
     * Command implementation insert
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Insert(int arg) throws ParseException, IOException {
        ArrayList<String> m = InvokerServer.getCommandHistory();
        if (m.get(m.size() - CommandNumber-1).equals("execute_script")){
            WorkWithTreeMap.AddToTreeMap(ReceiverServer.getmap(),arg, CreatCollection.creatCollectionExecute());
        } else {
            WorkWithTreeMap.AddToTreeMap(ReceiverServer.getmap(), arg, CreatCollection.creatCollection());
        }
        douts.writeUTF("Новый элемент коллекции создан");
    }

    /**
     * Command implementation update
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Update(int arg) throws ParseException, IOException {
        int key = IdToKey.getKey(map, arg);
        ArrayList<String> m = InvokerServer.getCommandHistory();
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
        
        path = Paths.get(file);
        CommandNumber=0;
        try(Scanner scanner = new Scanner(path)) {
           while(scanner.hasNextLine()) {
               ArrayList<String> m = InvokerServer.getCommandHistory();
               CommandNumber++;
               invoker.executeCommand(scanner.nextLine().trim().split(" "));
               if (m.get(m.size() - 1).equals("insert") || m.get(m.size() - 1).equals("update_id")) {
                   for (int i = 0; i < NumberLine-2; i++) {
                       scanner.nextLine();}
               }
               NumberLine = 0;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException ex){
            douts.writeUTF("Ошибка в вводе команды");
        }
    }

    /**
     * Method for get File
     * @return path
     */
    public static Path getFile(){
        return path;
    }

    /**
     * Method for get number of line
     * @return NumberLine
     */
    public static int getNumberLine(){
        NumberLine++;
        return NumberLine;
    }

    /**
     * Command implementation history
     */
    public void History() throws IOException {
        ArrayList<String> History=InvokerServer.getCommandHistory();
        if (History.size()>10){
            for (int i=History.size()-1;i>History.size()-11;i--){
                douts.writeUTF(History.get(i)+" ");
            }
        } else {
            for (int i=History.size()-1;i>=0;i--){
                douts.writeUTF(History.get(i)+" ");
            }
        }
    }

    /**
     * Command implementation remove_greater_key
     * @param key key
     */
    public void RemoveGreater(int key) throws IOException {
        int size = ReceiverServer.getsize();
        for (int i = key + 1; i <= size; i++) {
            WorkWithTreeMap.RemoveElementTreeMap(i);
        }
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Все элементы коллекции с ключами большими " + key + " удалены."));
    }

    /**
     * Command implementation remove_lower_key
     * @param key key
     */
    public void RemoveLower(int key) throws IOException {
        for (int i = key - 1; i >0; i--) {
            WorkWithTreeMap.RemoveElementTreeMap(i);
        }
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Все элементы коллекции с ключами меньшими " + key + " удалены."));
    }

    /**
     * Command implementation max_by_meters_above_sea_level
     */
    public void MaxMeters() throws IOException {
        Long max=0L;
        String ElementOfCollection = null;
        for (Map.Entry<Integer, City> entry : map.entrySet()) {
            if ((entry.getValue().getMetersAboveSeaLevel()) > max) {
                max = entry.getValue().getMetersAboveSeaLevel();
                ElementOfCollection = entry.toString();
            }
        }
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage(ElementOfCollection));
    }

    /**
     * Command implementation filter_less_than_standard_of_living
     * @param standard StandardOfLiving
     */
    public void FilterStandardOfLiving(StandardOfLiving standard) throws IOException {
        String ListToSend="";
        for (Map.Entry<Integer, City> entry : ReceiverServer.getmap().entrySet()) {
            if (StandardToInt.StandToInt(standard) > StandardToInt.StandToInt(entry.getValue().getStandardOfLiving())) {
                ListToSend+=entry.toString()+'\n';
            }
        }
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage(ListToSend));
    }

    /**
     * Command implementation print_ascending
     */
    public void PrintAscending() throws IOException {
        String ListToSend="";
        List<Map.Entry<Integer,City>> mappings = new ArrayList<>(map.entrySet());
        mappings.sort(Comparator.comparing(o -> o.getValue().getid()));
        Map<Integer,City> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,City> entry: mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer,City> entry:linkedHashMap.entrySet()){
            ListToSend+=entry.toString()+'\n';
        }
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage(ListToSend));
    }

    /**
     * Command implementation show
     */
    public void Show() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage(getAllElements()));
    }

    /**
     * Command implementation remove_key
     * @param arg argument
     */
    public void RemoveKey(int arg) throws IOException {
        WorkWithTreeMap.RemoveElementTreeMap(arg);
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Удалён город "+arg));
    }

    /**
     * Command implementation clear
     */
    public void Clear() throws IOException {
        map.clear();
        ObjectOutputStream out = new ObjectOutputStream(ServerCity.getss().getOutputStream());
        out.writeObject(new SeriMessage("Все элементы коллекции удалены"));
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