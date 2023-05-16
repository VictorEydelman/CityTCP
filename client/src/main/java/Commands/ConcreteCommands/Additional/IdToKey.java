package Commands.ConcreteCommands.Additional;

import Collections.City;

import java.util.Map;

/**
 * Class that finds the key by id
 */
public class IdToKey {
    /**
     * Method that finds the key by id
     * @param map collection
     * @param arg id
     * @return key
     */
    public static int getKey(Map<Integer, City> map, int arg) {
        int key = -1;
        for (Map.Entry<Integer, City> entry : map.entrySet()) {
            if ((entry.getValue().getid()) == arg) {
                key = entry.getKey();
            }
        }
        return key;
    }
}