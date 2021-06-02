package BusinessLayer;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int orderID;
    private int clientID;
    private Date date;
    private int pretTotal;
    public static int cheie = 0;

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return this.clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Date getDate() {
        return this.date;
    }

    public int getPretTotal() {
        return this.pretTotal;
    }

    public void setPretTotal(int pretTotal) {
        this.pretTotal = pretTotal;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int hashCode() {
        return this.orderID;
    }

    public Order(int clientID) {
        cheie++;
        this.orderID = cheie;
        this.clientID = clientID;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", date=" + date +
                '}';
    }
}
