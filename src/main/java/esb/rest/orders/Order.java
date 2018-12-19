package esb.rest.orders;

import java.util.Date;

public class Order {

    private int id;
    private String number;
    private Date createdDate;

    public Order(){}

    public Order(int id, String number, Date createdDate) {
        this.id = id;
        this.number = number;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
