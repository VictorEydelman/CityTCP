package Server.Parser;

import Server.Collections.City;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class for writing a collection to a file
 */
public class CSVWriter {
    /**
     * Method for writing a collection to a file
     * @param map collection
     */
    public static void Writer(Map<Integer,City> map){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVParser.getfile().toFile()))) {
            writer.write(City.NameCity()+'\n');
            int quantity=0;
            for (Map.Entry<Integer, City> entry:map.entrySet()) {
                quantity+=1;
                if (quantity == map.size()){
                    writer.write(entry.getKey() + entry.getValue().String());
                } else {
                    writer.write(entry.getKey() + entry.getValue().String() + '\n');
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}