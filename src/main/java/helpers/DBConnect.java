package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    static Connection connect = null ;
    public static Connection connect() throws ClassNotFoundException,SQLException{
        if(connect == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "2213N@sr2213");
            //using the DriverManager you will connect using url(including DB name at tail) , username and pwd
        }
        return connect ;
    }
}
