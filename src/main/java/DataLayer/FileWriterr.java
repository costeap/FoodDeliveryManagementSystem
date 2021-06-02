package DataLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class FileWriterr {
    DeliveryService ds = new DeliveryService();

    public FileWriterr(Set<Order> c) {
        raportUnuAfis(c);
    }

    public FileWriterr(StringBuilder s) {
        raportDoiAfis(s);
    }

    public FileWriterr(StringBuilder s, int a) {
        raportTreiAfis(s, a);
    }

    public FileWriterr(StringBuilder s, char a) {
        raportPatruAfis(s, a);
    }

    public FileWriterr(String s, int order) {
        writeFile(s, order);
    }

    private void writeFile(String s, int order) {
        File f = new File("Bill for order " + order + ".txt");
        try {
            f.createNewFile();
            FileWriter w;
            w = new FileWriter(f);
            w.write(s);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void raportUnuAfis(Set<Order> com) {
        File f = new File("Raport1.txt");
        try {
            FileWriter fw;
            fw = new FileWriter(f);
            String s = "";
            for (Order o : com) {
                s = s + "  " + o.toString();
            }
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void raportDoiAfis(StringBuilder s) {
        File f = new File("Raport2.txt");
        try {
            FileWriter fw;
            fw = new FileWriter(f);
            fw.write(String.valueOf(s));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void raportTreiAfis(StringBuilder s, int a) {
        File f = new File("Raport3.txt");
        try {
            FileWriter fw;
            fw = new FileWriter(f);
            fw.write(String.valueOf(s));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void raportPatruAfis(StringBuilder s, char a) {
        File f = new File("Raport4.txt");
        try {
            FileWriter fw;
            fw = new FileWriter(f);
            fw.write(String.valueOf(s));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
