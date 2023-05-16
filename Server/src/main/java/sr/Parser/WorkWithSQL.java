package sr.Parser;

import Collections.City;
import Collections.Coordinates;
import Collections.Human;
import Collections.StandardOfLiving;
import interfase.ReceiverServer;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;

public class WorkWithSQL {
    public static boolean AddToTreeMap(String[] line1) throws ParseException, SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/studs",
                "s291485", "qz6XMfGNKAgNOWkq");
        System.out.println(2);
        String addQuery = "INSERT INTO City (id,name,CoordinatesX,CoordinatesY,creationData,area,population, "
                + "metersAboveSeaLevel,populationDensity,telephoneCode,stadardOfLiving,Human) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";
        for (int i=0;i<12;i++) {
            System.out.println(line1[i]);
        }
        PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
        preparedStatement.setInt(1, Integer.parseInt(line1[0]));
        preparedStatement.setString(2,line1[1]);
        preparedStatement.setLong(3, Long.parseLong(line1[2]));
        preparedStatement.setInt(4, Integer.parseInt(line1[3]));
        preparedStatement.setString(5, line1[11]);
        preparedStatement.setFloat(6, Float.parseFloat(line1[4]));
        preparedStatement.setInt(7, Integer.parseInt(line1[5]));
        preparedStatement.setLong(8, Long.parseLong(line1[6]));
        preparedStatement.setLong(9, Long.parseLong(line1[7]));
        preparedStatement.setLong(10, Long.parseLong(line1[8]));
        preparedStatement.setString(11, line1[9]);
        preparedStatement.setString(12, line1[10]);
        ResultSet result = preparedStatement.getGeneratedKeys();
        Statement statement = connection.createStatement();
        //System.out.println(preparedStatement);
        statement.execute(String.valueOf(preparedStatement));

        //statement.execute("insert into City(id,name,CoordinatesX,CoordinatesY,creationData,area,population," +
          //      "metersAboveSeaLevel,populationDensity,telephoneCode,stadardOfLiving,Human)"+
            //    "values (");
        return true;
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

    }

    /**
     * Method for removing an item to a collection
     * @param j key
     */
    public static void RemoveElementTreeMap(int j){
        Map<Integer, City> map = ReceiverServer.getmap();
        map.remove(j);

    }
}
