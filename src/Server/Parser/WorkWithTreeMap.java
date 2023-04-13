package Server.Parser;

import Server.Collections.City;
import Server.Collections.Coordinates;
import Server.Collections.Human;
import Server.Collections.StandardOfLiving;
import Server.Commands.ReceiverServer;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;
import java.lang.String;

/**
 * Class for work with collection
 */

public class WorkWithTreeMap {
    /**
     * Method for adding an item to a collection
     * @param map collection
     * @param j key
     * @param line1 elements
     * @throws ParseException mistake
     */
    public static void AddToTreeMap(Map<Integer,City> map, int j, String[] line1) throws ParseException {
        //System.out.println(line1[11]);
        map.put(j,new City(Integer.parseInt(line1[0]), line1[1],
                        new Coordinates(Long.parseLong(line1[2]), Integer.parseInt(line1[3])),
                        LocalDate.parse(line1[11]), Float.parseFloat(line1[4]),
                        Integer.parseInt(line1[5]), Long.parseLong(line1[6]),
                        Long.parseLong(line1[7]), Long.parseLong(line1[8]),
                        StandardOfLiving.valueOf(line1[9]),
                        new Human((new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).parse(line1[10]))));
    }

    /**
     * Method for replacing an item to a collection
     * @param map collection
     * @param j key
     * @param line1 elements
     * @throws ParseException mistake
     */
    public static void ReplaceTreeMap(Map<Integer,City> map, int j, String[] line1) throws ParseException {
        map.replace(j, new City(Integer.parseInt(line1[0]), line1[1],
                new Coordinates(Long.parseLong(line1[2]), Integer.parseInt(line1[3])),
                LocalDate.parse(line1[11]), Float.parseFloat(line1[4]),
                Integer.parseInt(line1[5]), Long.parseLong(line1[6]),
                Long.parseLong(line1[7]), Long.parseLong(line1[8]),
                StandardOfLiving.valueOf(line1[9]),
                new Human((new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).parse(line1[10]))));
    }

    /**
     * Method for removing an item to a collection
     * @param j key
     */
    public static void RemoveElementTreeMap(int j){
        Map<Integer,City> map = ReceiverServer.getmap();
        map.remove(j);
    }
}