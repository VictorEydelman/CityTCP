package Server.Parser;
import Server.Collections.*;
import Server.Commands.ReceiverServer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

/**
 * Class of reading CSV fail and parse
 */

public class CSVParser {
    final String[] args;

    private static Path fileName;

    /**
     * Method for
     * @param args argument
     */
    public CSVParser(String[] args) {
        this.args = args;
    }


    /**
     * Method for reading file
     * @param arg arg
     * @throws IOException mistake
     * @throws ParseException mistake
     */
    public static void Reader(String[] arg) throws IOException, ParseException {
        String file="";

        if (arg.length>0) {
            //System.out.println(arg[0]);
            arg[0]=arg[0].replace("/","//");
            //System.out.println(arg[0]);
            fileName = Path.of(arg[0]);
        } else {
            file = "file.csv";
            fileName = Path.of(file);
        }
        Parse(fileName);
    }

    /**
     * Method for Parse CSV file
     * @param fileName name of file
     * @throws IOException mistake
     * @throws ParseException mistake
     */
    public static void Parse(Path fileName) throws IOException, ParseException {
        FileInputStream input = new FileInputStream(fileName.toFile());
        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        Map<Integer,City> map = ReceiverServer.getmap();
        int i;
        String line = "";
        String[] line1;
        Boolean t=false;
        while ((i = reader.read()) != -1) {
            char point = (char) i;
            if (point!='\r' && point!='\n') {
                line += point;
            }
            if (point =='\n') {
                if (t) {
                    String creation=String.valueOf(LocalDate.now());
                    line += ","+creation;
                    line1 = line.split(",");
                    int key = Integer.parseInt(line1[0]);
                    line1[0] = Integer.toString(map.size()+1);
                    WorkWithTreeMap.AddToTreeMap(map, key, line1);
                }
                t=true;
                line = "";
            }
        }
        String creation=String.valueOf(LocalDate.now());
        line+=","+creation;
        line1 = line.split(",");
        int key = Integer.parseInt(line1[0]);
        line1[0] = Integer.toString(map.size()+1);
        WorkWithTreeMap.AddToTreeMap(map, key, line1);
    }

    /**
     * Method for getting file name
     * @return fileName
     */
    public static Path getfile(){
        return fileName;
    }
}