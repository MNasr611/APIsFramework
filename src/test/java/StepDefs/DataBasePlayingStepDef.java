package StepDefs;
import enums.Queries;
import helpers.CleanObject;
import helpers.DBConnect;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.request.CustomerDetialsRequestModel;
import objects.CustomerDetailsDBObject;
import utils.RetrieveQueryRecords;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasePlayingStepDef {
    Statement statement;
    ResultSet rS ;
    CustomerDetailsDBObject customerDetailsDBObject ;
    CustomerDetialsRequestModel customerDetialsRequestModel;
    String CourseName;
    String PurchaseDate;
    int Amount;
    String Location;
    @Then("I connect to DB")
    public void connectToDB() throws SQLException, ClassNotFoundException {
          statement = DBConnect.connect().createStatement();

    }

    @Then("I execute some query")
    public void executeQuery() throws SQLException {
        rS = statement.executeQuery("SELECT * FROM CustomerInfo WHERE Location = 'Asia' LIMIT 1;");
        //LIMIT 1 to get only one record out of DB

    }


    @And("I get info from query and convert it into JAVA object")
    public void iGetInfoFromQuery() throws SQLException {
        while (rS.next()) // setting the pointer at the first row
            //this will return true each time and if tru then execute below
            //if there is no records then rS.next() will return false and this will end the while loop
            {
//                rS.getString(1); // if first row is string then this will retrive info from it
//                rS.getInt(3);
//                rS.getString(4);
                CustomerDetialsRequestModel customerDetialsRequestModel = new CustomerDetialsRequestModel();
                customerDetialsRequestModel.CourseName = rS.getString(1);
                System.out.println(customerDetialsRequestModel.CourseName + " CourseName");
            }

    }



    @Then("I close the DB connection")
    public void iCloseTheDBConnection() throws SQLException, ClassNotFoundException {
        DBConnect.closeDB();
    }




    @Given("I execute specific query {string} and get records")
    public void iExecuteSpecificQueryAndGetRecords(String query) throws SQLException, ClassNotFoundException {
        rS = RetrieveQueryRecords.retrieveRecords(statement, query);

    }


    @When("I convert query {string} results into Request Model")
    public void iConvertQueryResultsIntoRequestModel(String query) throws SQLException, ClassNotFoundException {
        customerDetialsRequestModel = CustomerDetailsDBObject.convertDBRecordsToJavaObject(rS,query);
        System.out.println("CourseName : "+ customerDetialsRequestModel.CourseName);

    }



    @And("I convert object into JSON file {string}")
    public void iConvertObjectIntoJSONFile(String fileName) throws IOException, SQLException, ClassNotFoundException {
        CustomerDetailsDBObject.convertObjectIntoJson(customerDetialsRequestModel,fileName);

    }
}
