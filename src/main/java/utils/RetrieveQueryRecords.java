package utils;

import enums.Queries;
import helpers.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveQueryRecords {
    static ResultSet rS;



    public static ResultSet retrieveRecords(Statement statement, String query) throws SQLException, ClassNotFoundException {
        statement = DBConnect.connect().createStatement();
        rS = statement.executeQuery(Queries.valueOf(query).getValue());
        return rS;
    }




}
