package Database;

import java.sql.*;

public class Database implements IDB {

    public Connection getConnection(){
        String connectionURL = "jdbc:postgresql://localhost:5432/medicine";
        try{

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL,"postgres","1234");

            return con;
        }
        catch (Exception e){
            System.out.println("Cannot connect to Database");
            return null;
        }
    }
}