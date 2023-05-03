package client.src.main.java.Commands;

import Server.src.main.java.Collections.Human;
import Server.src.main.java.Collections.StandardOfLiving;
import client.src.main.java.Commands.Reader.Reader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Class for getting data about a new collection item
 */
public class CreatCollection {
    /**
     * Method for getting data about a new collection item
     * @return newCity new element of collection
     */
    public static String[] creatCollection() throws IOException {
        /*String id = Integer.toString(ReceiverServer.getsize()+1);
        while (!boolid(id)){
            id = Integer.toString(ReceiverServer.getsize()+1);
        }*/

        String name = Reader.read("Введите название города: ");
        while (!boolName(name)){
            name = Reader.read("Введите название города: ");
        }

        String coordinates_X = Reader.read("Введите широту города: ");
        while (!boolCoordinatesX(coordinates_X)){
            coordinates_X = Reader.read("Введите широту города: ");
        }

        String coordinates_Y = Reader.read("Введите долготу города: ");
        while (!boolCoordinatesY(coordinates_Y)){
            coordinates_Y = Reader.read("Введите долготу города: ");
        }

        String creationDate = String.valueOf(LocalDate.now());
        while (!boolLocalDate(creationDate)){
            creationDate = String.valueOf(LocalDate.now());
        }

        String area = Reader.read("Укажите площадь города: ");
        while (!boolFloat(area)){
            area = Reader.read("Укажите площадь города: ");
        }

        String population = Reader.read("Население города: ");
        while (!boolpopulation(population)){
            population = Reader.read("Население города: ");
        }

        String metersAboveSeaLevel = Reader.read("Высота город над уровнем моря: ");
        while (!boolmeters(metersAboveSeaLevel)){
            metersAboveSeaLevel = Reader.read("Высота город над уровнем моря: ");
        }

        String populationDensity = Reader.read("Плотность населения города: ");
        while (!boolpopulationDensity(populationDensity)){
            populationDensity = Reader.read("Плотность населения города: ");
        }

        String telephoneCode = Reader.read("Код города: ");
        while (!booltelephoneCode(telephoneCode)){
            telephoneCode = Reader.read("Код города: ");
        }

        String standardOfLiving = Reader.read("Уровень жизни в городе (VERY_HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE): ");
        while (!boolStandardOfLiving(standardOfLiving)){
            standardOfLiving = Reader.read("Уровень жизни в городе (VERY_HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE): ");
        }

        String governor = Reader.read("Дата рождения губернатора (формат ввода: dd.mm.yyyy HH:mm:ss): ");
        while (!boolHuman(governor)){
            governor = Reader.read("Дата рождения губернатора (формат ввода: dd.mm.yyyy HH:mm:ss): ");
        }

        return new String[]{name, coordinates_X, coordinates_Y,
                area, population, metersAboveSeaLevel, populationDensity,
                telephoneCode, standardOfLiving, governor,creationDate};
    }



    public static boolean creatCollectionCSV(String[] line) {
        return (boolName(line[1]) && boolCoordinatesX(line[2]) && boolCoordinatesY(line[3])
                && boolFloat(line[4]) && boolpopulation(line[5]) && boolmeters(line[6])
                && boolpopulationDensity(line[7]) && booltelephoneCode(line[8])
                && boolStandardOfLiving(line[9]) && boolHuman(line[10]));
    }
    /**
     * Method for getting data about a new collection item
     * @return newCity new element of collection
     * @throws IOException mistake
     */
    public static String[] creatCollectionExecute() throws IOException {
        String name = Reader.readExecute();
        while (!boolName(name)){
            name = Reader.readExecute();
        }

        String coordinates_X = Reader.readExecute();
        while (!boolCoordinatesX(coordinates_X)){
            coordinates_X = Reader.readExecute();
        }

        String coordinates_Y = Reader.readExecute();
        while (!boolCoordinatesY(coordinates_Y)){
            coordinates_Y = Reader.readExecute();
        }

        String creationDate = String.valueOf(LocalDate.now());
        while (!boolLocalDate(creationDate)){
            creationDate = String.valueOf(LocalDate.now());
        }

        String area = Reader.readExecute();
        while (!boolFloat(area)){
            area = Reader.readExecute();
        }

        String population = Reader.readExecute();
        while (!boolpopulation(population)){
            population = Reader.readExecute();
        }

        String metersAboveSeaLevel = Reader.readExecute();
        while (!boolmeters(metersAboveSeaLevel)){
            metersAboveSeaLevel = Reader.readExecute();
        }

        String populationDensity = Reader.readExecute();
        while (!boolpopulationDensity(populationDensity)){
            populationDensity = Reader.readExecute();
        }

        String telephoneCode = Reader.readExecute();
        while (!booltelephoneCode(telephoneCode)){
            telephoneCode = Reader.readExecute();
        }

        String standardOfLiving = Reader.readExecute();
        while (!boolStandardOfLiving(standardOfLiving)){
            standardOfLiving = Reader.readExecute();
        }

        String governor = Reader.readExecute();
        while (!boolHuman(governor)){
            governor = Reader.readExecute();
        }

        return new String[]{name, coordinates_X, coordinates_Y,
                area, population, metersAboveSeaLevel, populationDensity,
                telephoneCode, standardOfLiving, governor,creationDate};
    }

     /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolid(String arg){
        try {
            int n=Integer.parseInt(arg);
            return n > 0;
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolpopulation(String arg){
        try {
            int n=Integer.parseInt(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolName(String arg){
        try {
            if (arg!="") {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolCoordinatesX(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n<=735) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolCoordinatesY(String arg){
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolLocalDate(String arg){
        try {
            LocalDate.parse(arg);
            return true;
        } catch (DateTimeParseException | NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolFloat(String arg){
        try {
            float n = Float.parseFloat(arg);
            return n > 0;
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolmeters(String arg){
        try {
            Long.parseLong(arg);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolpopulationDensity(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean booltelephoneCode(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n>0 && n<=100000) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolStandardOfLiving(String arg){
        try {
            StandardOfLiving.valueOf(arg);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex){
            return false;
        }
    }

    /**
     * Method verification
     * @param arg argument
     * @return boolean result
     */
    public static boolean boolHuman(String arg){
        try {
            new Human((new SimpleDateFormat("dd.mm.yyyy HH:mm:ss")).parse(arg));
            return true;
        } catch (RuntimeException | ParseException ex) {
            return false;
        }
    }


}