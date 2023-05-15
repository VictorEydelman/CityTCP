package Commands;

import Collections.Human;
import Collections.StandardOfLiving;
import Commands.Reader.Reader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CreateCollection {
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
