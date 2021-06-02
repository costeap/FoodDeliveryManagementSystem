package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BusinessLayer.*;
import BusinessLayer.MenuItem;

public class ClientGraphicalUserInterface extends JFrame {

    private JPanel contentPane;
    private JLabel placeOrder;
    private JLabel addCompositeProduct;
    private JLabel updateProduct;
    private JLabel totalPrice;
    private JLabel generateBill;
    private JLabel clientid;
    private JLabel menuItems;
    private JTextField clientidT;
    private JTextField menuItemsT;
    private JButton placeO;
    private JButton showPrice;
    private JButton billB;
    private JButton closeButton;
    private JLabel loginB;
    private JButton meniu;
    private JTextField clientid1T;
    private JLabel clientid1;
    private JTextField clientid2T;
    private JLabel clientid2;
    private JLabel pretTotal;
    private JLabel ron;
    private JButton search;
    private JTextField searchT;
    private JTextField searchT1;
    private JComboBox combo;
    private JButton showOrders;

    public ClientGraphicalUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1800, 850);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(195, 215, 185));

        loginB = new JLabel("LOG IN AS CLIENT");
        loginB.setFont(new Font("Ink Free", Font.BOLD, 16));
        loginB.setBounds(200, 20, 200, 20);
        contentPane.add(loginB);

        placeOrder = new JLabel("PLACE ORDER");
        placeOrder.setFont(new Font("Ink Free", Font.BOLD, 16));
        placeOrder.setBounds(100, 60, 200, 20);
        contentPane.add(placeOrder);

        /*totalPrice = new JLabel("TOTAL PRICE");
        totalPrice.setFont(new Font("Ink Free", Font.BOLD, 16));
        totalPrice.setBounds(100, 160, 300, 20);
        contentPane.add(totalPrice);*/

        generateBill = new JLabel("GENERATE BILL");
        generateBill.setFont(new Font("Ink Free", Font.BOLD, 16));
        generateBill.setBounds(100, 260, 200, 20);
        contentPane.add(generateBill);

        /*clientid = new JLabel("ID_Client");
        clientid.setFont(new Font("Ink Free", Font.BOLD, 16));
        clientid.setBounds(110, 100, 200, 20);
        contentPane.add(clientid);

        clientidT = new JTextField();
        clientidT.setBackground(new Color(200, 220, 230));
        clientidT.setBounds(100, 130, 100, 20);
        contentPane.add(clientidT);
        clientidT.setColumns(10);*/

        menuItems = new JLabel("Menu Items ");
        menuItems.setFont(new Font("Ink Free", Font.BOLD, 16));
        menuItems.setBounds(240, 100, 200, 20);
        contentPane.add(menuItems);

        menuItemsT = new JTextField();
        menuItemsT.setBackground(new Color(200, 220, 230));
        menuItemsT.setBounds(220, 130, 700, 20);
        contentPane.add(menuItemsT);
        menuItemsT.setColumns(10);

        placeO = new JButton("PLACE ORDER");
        placeO.setBackground(new Color(255, 255, 255));
        placeO.setFont(new Font("Ink Free", Font.BOLD, 16));
        placeO.setBounds(940, 110, 200, 40);
        contentPane.add(placeO);

        /*clientid1 = new JLabel("ID_Client");
        clientid1.setFont(new Font("Ink Free", Font.BOLD, 16));
        clientid1.setBounds(110, 200, 200, 20);
        contentPane.add(clientid1);

        clientid1T = new JTextField();
        clientid1T.setBackground(new Color(200, 220, 230));
        clientid1T.setBounds(100, 230, 100, 20);
        contentPane.add(clientid1T);
        clientid1T.setColumns(10);

        showPrice = new JButton("SHOW PRICE");
        showPrice.setBackground(new Color(255, 255, 255));
        showPrice.setFont(new Font("Ink Free", Font.BOLD, 16));
        showPrice.setBounds(300, 210, 200, 40);
        contentPane.add(showPrice);

        pretTotal = new JLabel("");
        pretTotal.setFont(new Font("Ink Free", Font.BOLD, 16));
        pretTotal.setBounds(600, 230, 200, 20);
        contentPane.add(pretTotal);

        ron = new JLabel("RON");
        ron.setFont(new Font("Ink Free", Font.BOLD, 16));
        ron.setBounds(800, 230, 200, 20);
        contentPane.add(ron);*/


        clientid2 = new JLabel("ID_Client");
        clientid2.setFont(new Font("Ink Free", Font.BOLD, 16));
        clientid2.setBounds(110, 300, 200, 20);
        contentPane.add(clientid2);

        clientid2T = new JTextField();
        clientid2T.setBackground(new Color(200, 220, 230));
        clientid2T.setBounds(100, 330, 100, 20);
        contentPane.add(clientid2T);
        clientid2T.setColumns(10);

        billB = new JButton("Generate Bill");
        billB.setBackground(new Color(255, 255, 255));
        billB.setFont(new Font("Ink Free", Font.BOLD, 16));
        billB.setBounds(300, 310, 200, 40);
        contentPane.add(billB);

        meniu = new JButton("MENU");
        meniu.setBackground(new Color(255, 255, 255));
        meniu.setFont(new Font("Ink Free", Font.BOLD, 16));
        meniu.setBounds(300, 410, 200, 40);
        contentPane.add(meniu);


        search = new JButton("SEARCH");
        search.setBackground(new Color(255, 255, 255));
        search.setFont(new Font("Ink Free", Font.BOLD, 16));
        search.setBounds(500, 410, 200, 40);
        contentPane.add(search);

        searchT = new JTextField();
        searchT.setBackground(new Color(200, 220, 230));
        searchT.setBounds(900, 410, 200, 40);
        contentPane.add(searchT);
        searchT.setColumns(10);


        closeButton = new JButton("Close");
        closeButton.setBackground(new Color(255, 255, 255));
        closeButton.setFont(new Font("Ink Free", Font.BOLD, 16));
        closeButton.setBounds(1300, 750, 200, 40);
        contentPane.add(closeButton);

        showOrders = new JButton("Show Orders");
        showOrders.setBackground(new Color(255, 255, 255));
        showOrders.setFont(new Font("Ink Free", Font.BOLD, 16));
        showOrders.setBounds(1300, 710, 200, 40);
        contentPane.add(showOrders);

        Criteriu[] criterii = new Criteriu[]{Criteriu.TITLE, Criteriu.RATING, Criteriu.CALORIES, Criteriu.PROTEIN, Criteriu.FAT, Criteriu.SODIUM, Criteriu.PRICE};
        combo = new JComboBox<Criteriu>(criterii);
        combo.setBackground(new Color(255, 255, 255));
        combo.setFont(new Font("Ink Free", Font.BOLD, 16));
        combo.setBounds(700, 410, 200, 40);
        contentPane.add(combo);


    }

    public void addCloseListener(ActionListener actionListener) {
        this.closeButton.addActionListener(actionListener);
    }

    public void showMenuListener(ActionListener actionListener) {
        this.meniu.addActionListener(actionListener);
    }

    public void searchListener(ActionListener actionListener) {
        this.search.addActionListener(actionListener);
    }

    public void addOrderListener(ActionListener actionListener) {
        this.placeO.addActionListener(actionListener);
    }

    public void showOrdersListener(ActionListener actionListener) {
        this.showOrders.addActionListener(actionListener);
    }

    public void billListener(ActionListener actionListener) {
        this.billB.addActionListener(actionListener);
    }


    public String searchP() {
        return this.searchT.getText();
    }

    public String searchP1() {
        return this.searchT1.getText();
    }

    public String menuItemsText() {
        return this.menuItemsT.getText();
    }

    public String idClientText() {
        return this.clientidT.getText();
    }

    public String idClient2Text() {
        return this.clientid2T.getText();
    }

    public Criteriu getComboCriteriu() {
        return (Criteriu) this.combo.getSelectedItem();
    }




  /*  @Override
    public void addProduct(MenuItem mi) {

    }

    @Override
    public void deleteProduct(MenuItem mi) {

    }

    @Override
    public void editProduct(MenuItem mi) {

    }

    @Override
    public HashSet<BaseProduct> searchTitle(String nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchRating(int nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchCalories(int nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchProtein(int nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchFat(int nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchSodium(int nr) {
        return null;
    }

    @Override
    public HashSet<BaseProduct> searchPrice(int nr) {
        return null;
    }

    @Override
    public void createNewOrder(Order order, List<MenuItem> produse) {

    }

    @Override
    public int computePrice(Order order) {
        return 0;
    }

    @Override
    public void generateBill(Order order) {

    }

    @Override
    public void importProducts() throws IOException {

    }

    @Override
    public JTable showProducts() {
        return null;
    }

    @Override
    public void raportUnu(int ora1, int min1, int ora2, int min2) {

    }

    @Override
    public void raportDoi(int nrComenzi) {

    }

    @Override
    public void raportTrei(int nrComenzi, int valoare) {

    }

    @Override
    public void raportPatru(int z, int nrComenzi) {

    }*/
}