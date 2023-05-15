package sr.Commands;

//import Common.ConcreteCommands.Additional.IdToKey;
//import Common.ConcreteCommands.Additional.StandardToInt;
//import Common.Serialized.SeriMessage;

//import Collections.StandardOfLiving;

import Common.src.main.java.ConcreteCommands.Additional.StandardToInt;
import ConcreteCommands.Additional.IdToKey;
import Collections.City;
import Collections.StandardOfLiving;
import interfase.Invoker;
import sr.Parser.CSVWriter;
import sr.Parser.WorkWithTreeMap;
import sr.read.sendserver;

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
public class ReceiverServer implements Serializable {
    private final Invoker invoker;
    private static Map<Integer, City> map;
    private static ZonedDateTime creationDate;
    private static Path path;
    private static int NumberLine;
    private static int CommandNumber=0;


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
        map=new TreeMap<Integer, City>();
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
        for (Map.Entry<Integer, City> entry:map.entrySet()) {
            list += entry.getKey() + " = ";
            list += entry.getValue();
            list += '\n';
        }
        return list;
    }

    /**
     * Method for get map
     *
     * @return map
     */
    public static Map<Integer, City> getmap(){
        return map;
    }

    /**
     * Command implementation help
     */
    public void Help() throws IOException {
        final String[] list = {""};
        Invoker.getCommandMap().forEach((commandname, command)-> {
            try {
                list[0] +=command.Information()+'\n';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //System.out.println(list[0]);
        sendserver.send(list[0]);
    }

    /**
     * Command implementation info
     */
    public void Info() throws IOException {
        //System.out.println(ServerCity.getss());
        sendserver.send("Тип коллекции - "+ReceiverServer.getName()+"\n"
                +"Дата и время инициализации - "+ReceiverServer.getcreatTime()+"\n"+
                "Количество элементов коллекции - "+ReceiverServer.getsize());
    }

    /**
     * Command implementation insert
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Insert(int arg, String[] newCollection) throws ParseException, IOException {
        WorkWithTreeMap.AddToTreeMap(ReceiverServer.getmap(),arg, newCollection);
        sendserver.send("добавлен элемент");
    }

    /**
     * Command implementation update
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Update(int arg,String[] newCollection) throws ParseException, IOException {
        int key = IdToKey.getKey(map, arg);
        WorkWithTreeMap.ReplaceTreeMap(map,key,newCollection);
        sendserver.send("элемент обновлён");
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
                ArrayList<String> m = Invoker.getCommandHistory();
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
            System.out.println("Ошибка в вводе команды");
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
        ArrayList<String> History = Invoker.getCommandHistory();
        if (History.size()>10){
            for (int i=History.size()-1;i>History.size()-11;i--){
                System.out.println(History.get(i)+" ");
            }
        } else {
            for (int i=History.size()-1;i>=0;i--){
                System.out.println(History.get(i)+" ");
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
        sendserver.send("Все элементы коллекции с ключами большими " + key + " удалены.");
    }

    /**
     * Command implementation remove_lower_key
     * @param key key
     */
    public void RemoveLower(int key) throws IOException {
        for (int i = key - 1; i >0; i--) {
            WorkWithTreeMap.RemoveElementTreeMap(i);
        }
        sendserver.send("Все элементы коллекции с ключами меньшими " + key + " удалены.");
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
        sendserver.send(ElementOfCollection);
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
        sendserver.send(ListToSend);
    }

    /**
     * Command implementation print_ascending
     */
    public void PrintAscending() throws IOException {
        String ListToSend="";
        List<Map.Entry<Integer,City>> mappings = new ArrayList<>(map.entrySet());
        mappings.sort(Comparator.comparing(o -> o.getValue().getid()));
        Map<Integer, City> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,City> entry: mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer,City> entry:linkedHashMap.entrySet()){
            ListToSend+=entry.toString()+'\n';
        }
        sendserver.send(ListToSend);
    }

    /**
     * Command implementation show
     */
    public void Show() throws IOException {
        sendserver.send(getAllElements());
    }

    /**
     * Command implementation remove_key
     * @param arg argument
     */
    public void RemoveKey(int arg) throws IOException {
        WorkWithTreeMap.RemoveElementTreeMap(arg);
        sendserver.send("Удалён город "+arg);
    }

    /**
     * Command implementation clear
     */
    public void Clear() throws IOException {
        map.clear();
        sendserver.send("Все элементы коллекции удалены");
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
    public static void Save() {
        CSVWriter.Writer(map);
        System.out.println("Коллекция сохранена");
    }
}