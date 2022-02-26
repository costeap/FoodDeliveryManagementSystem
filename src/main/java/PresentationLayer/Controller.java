package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Costea Paula-Maria
 * @since Iunie, 2021
 *
 */

public class Controller {
    private View db;
    private ArrayList<User> utilizatori = new ArrayList<User>();
    DeliveryService ds = new DeliveryService();

    public Controller(View db) {
        this.db = db;
        this.db.administratorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = db.getUser();
                String b = db.getPassword();
                System.out.println(a.toString());
                System.out.println(b.toString());

                All model = new All();
                for (User user : model.getUtilizatori()) {
                    if (a.equals(user.getUsername()) && b.equals(user.getPassword())) {
                        if (user.getRole() == Role.ADMIN) {


                            AdministratorGraphicalUserInterface ai = new AdministratorGraphicalUserInterface();

                            ai.importBListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    ds.importProducts();

                                }
                            });
                            ai.deleteListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String a = ai.nameDelete();
                                    MenuItem menui = null;
                                    List<MenuItem> lista = new ArrayList();
                                    for (MenuItem mi : ds.meniu) {
                                        if (mi.getTitle().equals(a)) {
                                            menui = mi;
                                            lista.add(mi);
                                        }
                                    }

                                    ds.meniu.removeAll(lista);
                                    ds.deleteProduct(menui);
                                }
                            });
                            ai.report1Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int o1 = Integer.parseInt(ai.getOra1());
                                    int o2 = Integer.parseInt(ai.getOra2());
                                    //int m1 = Integer.parseInt(ai.getMin1());
                                    //int m2 = Integer.parseInt(ai.getMin2());
                                    ds.raportUnu(o1, o2);

                                }
                            });

                            ai.report2Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int a = Integer.parseInt(ai.getNrCom2());
                                    ds.raportDoi(a);
                                }
                            });

                            ai.report3Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int a = Integer.parseInt(ai.getNrCom3());
                                    int b = Integer.parseInt(ai.getValoare());
                                    ds.raportTrei(a,b);
                                }
                            });

                            ai.report4Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int a = Integer.parseInt(ai.getNrCom4());
                                    ds.raportPatru(a);
                                }
                            });
                            ai.updateListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String z = ai.numeUpdate();
                                    String c = ai.getTitle1();
                                    Float d = Float.parseFloat(ai.getRating1());
                                    Integer f = Integer.parseInt(ai.getCalories1());
                                    Integer g = Integer.parseInt(ai.getProteins1());
                                    Integer h = Integer.parseInt(ai.getFat1());
                                    Integer i = Integer.parseInt(ai.getSodium1());
                                    Integer j = Integer.parseInt(ai.getPrice1());
                                    for (MenuItem mi : ds.meniu) {
                                        if (mi.getTitle().equals(z)) {
                                            ds.editProduct(z, c, d, f, g, h, i, j);

                                        }
                                    }


                                }
                            });
                            ai.adaugareLaMeniuListener(new ActionListener() {


                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String c = ai.getTitle();
                                    Float d = Float.parseFloat(ai.getRating());
                                    Integer f = Integer.parseInt(ai.getCalories());
                                    Integer g = Integer.parseInt(ai.getProteins());
                                    Integer h = Integer.parseInt(ai.getFat());
                                    Integer i = Integer.parseInt(ai.getSodium());
                                    Integer j = Integer.parseInt(ai.getPrice());

                                    BaseProduct bs = new BaseProduct(c, d, f, g, h, i, j);
                                    ds.addProduct(bs);
                                    System.out.println(ds.meniu.size());
                                }
                            });

                            ai.adaugareLaMeniuListener1(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ds.addComp1(ai);
                                }
                            });

                            ai.addCloseListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    ai.dispose();
                                }
                            });
                            ai.setVisible(true);
                        }
                        if (user.getRole() == Role.EMPLOYEE) {
                            EmployeeGraphicalUserInterface ei = new EmployeeGraphicalUserInterface();
                            ei.addCloseListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ei.dispose();
                                }
                            });
                            ei.setVisible(true);
                        }

                        if (user.getRole() == Role.CLIENT) {
                            ClientGraphicalUserInterface ci = new ClientGraphicalUserInterface();
                            //ds.memoriseLastIndex(0);
                            ci.showMenuListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame tabelProduse = new JFrame("Products");
                                    JTable tabel1 = ds.showProducts();
                                    JScrollPane scroll = new JScrollPane(tabel1);
                                    tabelProduse.add(scroll);
                                    tabelProduse.setBounds(100, 500, 600, 300);
                                    tabelProduse.setVisible(true);
                                }
                            });

                            ci.searchListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    HashSet<MenuItem> mi = new HashSet<>();
                                    Criteriu crt = ci.getComboCriteriu();
                                    if (crt.equals(Criteriu.TITLE)) {
                                        String a = ci.searchP();
                                        mi = ds.searchTitle(a);

                                    }
                                    if (crt.equals((Criteriu.RATING))) {
                                        Float a = Float.parseFloat(ci.searchP());
                                        mi = ds.searchRating(a);
                                    }
                                    if (crt.equals((Criteriu.CALORIES))) {
                                        Integer a = Integer.parseInt(ci.searchP());
                                        mi = ds.searchCalories(a);
                                    }
                                    if (crt.equals((Criteriu.PROTEIN))) {
                                        Integer a = Integer.parseInt(ci.searchP());
                                        mi = ds.searchProtein(a);
                                    }
                                    if (crt.equals((Criteriu.FAT))) {
                                        Integer a = Integer.parseInt(ci.searchP());
                                        mi = ds.searchFat(a);
                                    }
                                    if (crt.equals((Criteriu.SODIUM))) {
                                        Integer a = Integer.parseInt(ci.searchP());
                                        mi = ds.searchSodium(a);
                                    }
                                    if (crt.equals((Criteriu.PRICE))) {
                                        Integer a = Integer.parseInt(ci.searchP());
                                        mi = ds.searchPrice(a);
                                    }
                                    JFrame tabelProduse = new JFrame("Products");
                                    JTable tabel1 = ds.list(mi);
                                    JScrollPane scroll = new JScrollPane(tabel1);
                                    tabelProduse.add(scroll);
                                    tabelProduse.setBounds(100, 500, 600, 300);
                                    tabelProduse.setVisible(true);

                                }
                            });

                            ci.addOrderListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int client1 = user.getNri();
                                    List<MenuItem> items = ds.getMenuItems(ci.menuItemsText());

                                    Order o = new Order(client1);
                                    ds.createNewOrder(o, items);

                                    EmployeeGraphicalUserInterface ei = new EmployeeGraphicalUserInterface();
                                    ei.update();
                                }
                            });

                            ci.showOrdersListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame tabelComenzi = new JFrame("Orders");
                                    JTable tabel1 = ds.showProducts2();
                                    JScrollPane scroll = new JScrollPane(tabel1);
                                    tabelComenzi.add(scroll);
                                    tabelComenzi.setBounds(100, 500, 600, 300);
                                    tabelComenzi.setVisible(true);

                                }
                            });
                            ci.billListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int table = Integer.parseInt(ci.idClient2Text());

                                    Order o = ds.findOrder(table);

                                    ds.generateBill(o);
                                }
                            });
                            ci.addCloseListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ci.dispose();
                                }
                            });
                            ci.setVisible(true);
                        }


                    }
                }
            }
        });

        this.db.adaugareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = db.getUser1();
                String b = db.getPassword1();
                Role c = db.getUserCombo1();
                System.out.println(a.toString());
                System.out.println(b.toString());
                All model = new All();
                model.adaugareUtilizator(a, b, c);
                for (User u : model.getUtilizatori()) {
                    System.out.println(u.toString());
                    System.out.println("\n");
                }
            }
        });


    }
}
