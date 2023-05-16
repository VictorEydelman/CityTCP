package sr.Parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Collections.City;
import Collections.Coordinates;
import Collections.Human;
import Collections.StandardOfLiving;
import interfase.ReceiverServer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;

/**
 * Class for work with collection
 */

public class WorkWithTreeMap {
    static Logger logger = LogManager.getLogger(WorkWithTreeMap.class);
    /**
     * Method for adding an item to a collection
     * @param map collection
     * @param j key
     * @param line1 elements
     * @throws ParseException mistake
     */
    public static void AddToTreeMap(Map<Integer, City> map, int j, String[] line1) throws ParseException, SQLException, ClassNotFoundException {
        if(WorkWithSQL.AddToTreeMap(line1)) {
            map.put(j, new City(Integer.parseInt(line1[0]), line1[1],
                    new Coordinates(Long.parseLong(line1[2]), Integer.parseInt(line1[3])),
                    LocalDate.parse(line1[11]), Float.parseFloat(line1[4]),
                    Integer.parseInt(line1[5]), Long.parseLong(line1[6]),
                    Long.parseLong(line1[7]), Long.parseLong(line1[8]),
                    StandardOfLiving.valueOf(line1[9]),
                    new Human((new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).parse(line1[10]))));
            logger.info("Элемент добавлен" + j);
        }
    }

    /**
     * Method for replacing an item to a collection
     * @param map collection
     * @param j key
     * @param line1 elements
     * @throws ParseException mistake
     */
    public static void ReplaceTreeMap(Map<Integer, City> map, int j, String[] line1) throws ParseException {
        map.replace(j, new City(Integer.parseInt(line1[0]), line1[1],
                new Coordinates(Long.parseLong(line1[2]), Integer.parseInt(line1[3])),
                LocalDate.parse(line1[11]), Float.parseFloat(line1[4]),
                Integer.parseInt(line1[5]), Long.parseLong(line1[6]),
                Long.parseLong(line1[7]), Long.parseLong(line1[8]),
                StandardOfLiving.valueOf(line1[9]),
                new Human((new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).parse(line1[10]))));
        logger.info("Элемент обновлён"+j);
    }

    /**
     * Method for removing an item to a collection
     * @param j key
     */
    public static void RemoveElementTreeMap(int j){
        Map<Integer, City> map = ReceiverServer.getmap();
        map.remove(j);
        logger.info("Элемент удалён"+j);
    }
}