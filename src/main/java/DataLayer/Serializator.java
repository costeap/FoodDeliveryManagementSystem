package DataLayer;

import BusinessLayer.DeliveryService;

import java.io.*;

public class Serializator {

    public static void  Serializare(Object ds, String nume) {
        try {
            FileOutputStream file;
            file = new FileOutputStream(nume);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(ds);
            System.out.println(ds.toString());
            out.close();
            file.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public Object Deserializare(String nume) {
        Object ds = null;
        try {
            ObjectInputStream inputObject;
            FileInputStream file = new FileInputStream(nume);
            inputObject = new ObjectInputStream(file);
            ds = (Object) inputObject.readObject();
            inputObject.close();
            file.close();

        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return ds;
    }
}
