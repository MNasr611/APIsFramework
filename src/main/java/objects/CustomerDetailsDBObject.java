package objects;

import java.util.Date;

public class CustomerDetailsDBObject {
    // for each row in DB u have to create the same column name and type in the class
    // ex : if column name is string xX then the java object will be string xX
    private String CourseName;
    private Date PurchaseDate;
    private int Amount;
    private String Location;

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
