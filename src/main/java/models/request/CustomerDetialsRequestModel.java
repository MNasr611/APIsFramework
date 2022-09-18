package models.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

// here you convert the DB records into java object
public class CustomerDetialsRequestModel {
    // for each row in DB u have to create the same column name and type in the class
    // ex : if column name is string xX then the java object will be string xX
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String CourseName;
    public Date PurchaseDate;
    public int Amount;
    public String Location;



}
