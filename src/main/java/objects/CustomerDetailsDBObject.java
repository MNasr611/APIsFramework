package objects;

import enums.Queries;
import helpers.CleanObject;
import models.request.CustomerDetialsRequestModel;
import utils.RetrieveQueryRecords;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDetailsDBObject {
    static CustomerDetialsRequestModel customerDetialsRequestModel;
    static Statement statement ;

    public static CustomerDetialsRequestModel convertDBRecordsToJavaObject(ResultSet rS , String query) throws SQLException, ClassNotFoundException {
        customerDetialsRequestModel = new CustomerDetialsRequestModel();
        rS = RetrieveQueryRecords.retrieveRecords(statement, query);
        rS.next();
//        while (rS.next()){
//            rS.getString(1);
//        }
        customerDetialsRequestModel.CourseName = rS.getString(1);
        return customerDetialsRequestModel;
    }


    public static File convertObjectIntoJson(CustomerDetialsRequestModel customerDetialsRequestModel, String fileName) throws SQLException, ClassNotFoundException, IOException {
        return CleanObject.getObjectAsJSONFile(customerDetialsRequestModel,fileName);
    }





}
