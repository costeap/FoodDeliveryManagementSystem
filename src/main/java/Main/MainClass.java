package Main;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import PresentationLayer.AdministratorGraphicalUserInterface;
import PresentationLayer.ClientGraphicalUserInterface;
import PresentationLayer.Controller;
import PresentationLayer.View;

import java.io.IOException;

public class MainClass {


    public static void main(String[] args) throws IOException {

        View db = new View();
        Controller controller = new Controller(db);
        db.setVisible(true);


    }
}