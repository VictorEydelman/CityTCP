package sr.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    public static void SQL() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println(1);
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/studs",
                    "s291485", "qz6XMfGNKAgNOWkq");
            Statement statement = connection.createStatement();
            System.out.println(1);
            statement.execute("Create table if not exists City ("
                    + "id integer,"
                    + "name text,"
                    + "CoordinatesX integer,"
                    + "CoordinatesY integer,"
                    + "creationData text,"
                    + "area integer,"
                    + "population integer,"
                    + "metersAboveSeaLevel integer,"
                    + "populationDensity integer,"
                    + "telephoneCode integer,"
                    + "stadardOfLiving text,"
                    + "Human text"+
                    ");"
            );
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
