package PresentationLayer;


import BusinessLayer.BaseProduct;
import BusinessLayer.IDeleveryServiceProcessing;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;


public class AdministratorGraphicalUserInterface extends JFrame {

    private JPanel contentPane;
    private JLabel addBaseProduct;
    private JLabel addCompositeProduct;
    private JLabel updateProduct;
    private JLabel title;
    private JLabel rating;
    private JLabel calories;
    private JLabel protein;
    private JLabel fat;
    private JLabel sodium;
    private JLabel price;
    private JTextField titleT;
    private JTextField ratingT;
    private JTextField caloriesT;
    private JTextField proteinT;
    private JTextField fatT;
    private JTextField sodiumT;
    private JTextField priceT;
    private JButton addToMenu;
    private JButton addToMenu2;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel name;
    private JTextField nameT;
    private JLabel components;
    private JTextField componentsT;
    private JLabel deleteProduct;
    private JLabel named;
    private JTextField namedT;
    private JLabel nameu;
    private JTextField nameuT;
    private JLabel title1;
    private JLabel rating1;
    private JLabel calories1;
    private JLabel protein1;
    private JLabel fat1;
    private JLabel sodium1;
    private JLabel price1;
    private JTextField titleT1;
    private JTextField ratingT1;
    private JTextField caloriesT1;
    private JTextField proteinT1;
    private JTextField fatT1;
    private JTextField sodiumT1;
    private JTextField priceT1;
    private JButton closeButton;
    private JLabel loginB;
    private JButton importB;
    private JTextField ora1;
    private JTextField ora2;
    private JTextField min1;
    private JTextField min2;
    private JButton report1B;
    private JTextField ziuaT;
    private JButton report2B;
    private JTextField nrCom3;
    private JTextField val;
    private JButton report3B;
    private JTextField nrCom2;
    private JTextField nrCom4;
    private JButton report4B;


    public AdministratorGraphicalUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1800, 850);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(195, 215, 185));

        addBaseProduct = new JLabel("ADD BASE PRODUCT");
        addBaseProduct.setFont(new Font("Ink Free", Font.BOLD, 16));
        addBaseProduct.setBounds(100, 60, 200, 20);
        contentPane.add(addBaseProduct);

        addCompositeProduct = new JLabel("ADD COMPOSITE PRODUCT");
        addCompositeProduct.setFont(new Font("Ink Free", Font.BOLD, 16));
        addCompositeProduct.setBounds(100, 160, 300, 20);
        contentPane.add(addCompositeProduct);

        deleteProduct = new JLabel("DELETE PRODUCT");
        deleteProduct.setFont(new Font("Ink Free", Font.BOLD, 16));
        deleteProduct.setBounds(100, 260, 200, 20);
        contentPane.add(deleteProduct);

        updateProduct = new JLabel("UPDATE PRODUCT");
        updateProduct.setFont(new Font("Ink Free", Font.BOLD, 16));
        updateProduct.setBounds(100, 360, 200, 20);
        contentPane.add(updateProduct);

        title = new JLabel("Title");
        title.setFont(new Font("Ink Free", Font.BOLD, 16));
        title.setBounds(130, 100, 200, 20);
        contentPane.add(title);

        titleT = new JTextField();
        titleT.setBackground(new Color(200, 220, 230));
        titleT.setBounds(100, 130, 100, 20);
        contentPane.add(titleT);
        titleT.setColumns(10);

        rating = new JLabel("Rating");
        rating.setFont(new Font("Ink Free", Font.BOLD, 16));
        rating.setBounds(240, 100, 200, 20);
        contentPane.add(rating);

        ratingT = new JTextField();
        ratingT.setBackground(new Color(200, 220, 230));
        ratingT.setBounds(220, 130, 100, 20);
        contentPane.add(ratingT);
        ratingT.setColumns(10);

        calories = new JLabel("Calories");
        calories.setFont(new Font("Ink Free", Font.BOLD, 16));
        calories.setBounds(360, 100, 200, 20);
        contentPane.add(calories);

        caloriesT = new JTextField();
        caloriesT.setBackground(new Color(200, 220, 230));
        caloriesT.setBounds(340, 130, 100, 20);
        contentPane.add(caloriesT);
        titleT.setColumns(10);

        protein = new JLabel("Protein");
        protein.setFont(new Font("Ink Free", Font.BOLD, 16));
        protein.setBounds(480, 100, 200, 20);
        contentPane.add(protein);

        proteinT = new JTextField();
        proteinT.setBackground(new Color(200, 220, 230));
        proteinT.setBounds(460, 130, 100, 20);
        contentPane.add(proteinT);
        titleT.setColumns(10);

        fat = new JLabel("Fat");
        fat.setFont(new Font("Ink Free", Font.BOLD, 16));
        fat.setBounds(610, 100, 200, 20);
        contentPane.add(fat);

        fatT = new JTextField();
        fatT.setBackground(new Color(200, 220, 230));
        fatT.setBounds(580, 130, 100, 20);
        contentPane.add(fatT);
        fatT.setColumns(10);

        sodium = new JLabel("Sodium");
        sodium.setFont(new Font("Ink Free", Font.BOLD, 16));
        sodium.setBounds(720, 100, 200, 20);
        contentPane.add(sodium);

        sodiumT = new JTextField();
        sodiumT.setBackground(new Color(200, 220, 230));
        sodiumT.setBounds(700, 130, 100, 20);
        contentPane.add(sodiumT);
        sodiumT.setColumns(10);

        price = new JLabel("Price");
        price.setFont(new Font("Ink Free", Font.BOLD, 16));
        price.setBounds(850, 100, 200, 20);
        contentPane.add(price);

        priceT = new JTextField();
        priceT.setBackground(new Color(200, 220, 230));
        priceT.setBounds(820, 130, 100, 20);
        contentPane.add(priceT);
        priceT.setColumns(10);

        addToMenu = new JButton("ADD TO MENU");
        addToMenu.setBackground(new Color(255, 255, 255));
        addToMenu.setFont(new Font("Ink Free", Font.BOLD, 16));
        addToMenu.setBounds(940, 110, 200, 40);
        contentPane.add(addToMenu);

        name = new JLabel("Name");
        name.setFont(new Font("Ink Free", Font.BOLD, 16));
        name.setBounds(130, 200, 200, 20);
        contentPane.add(name);

        nameT = new JTextField();
        nameT.setBackground(new Color(200, 220, 230));
        nameT.setBounds(100, 230, 100, 20);
        contentPane.add(nameT);
        nameT.setColumns(10);

        components = new JLabel("Components");
        components.setFont(new Font("Ink Free", Font.BOLD, 16));
        components.setBounds(240, 200, 200, 20);
        contentPane.add(components);

        componentsT = new JTextField();
        componentsT.setBackground(new Color(200, 220, 230));
        componentsT.setBounds(220, 230, 700, 20);
        contentPane.add(componentsT);
        nameT.setColumns(10);

        addToMenu2 = new JButton("ADD TO MENU");
        addToMenu2.setBackground(new Color(255, 255, 255));
        addToMenu2.setFont(new Font("Ink Free", Font.BOLD, 16));
        addToMenu2.setBounds(940, 210, 200, 40);
        contentPane.add(addToMenu2);

        named = new JLabel("Name");
        named.setFont(new Font("Ink Free", Font.BOLD, 16));
        named.setBounds(130, 300, 200, 20);
        contentPane.add(named);

        namedT = new JTextField();
        namedT.setBackground(new Color(200, 220, 230));
        namedT.setBounds(100, 330, 100, 20);
        contentPane.add(namedT);
        nameT.setColumns(10);

        deleteButton = new JButton("DELETE");
        deleteButton.setBackground(new Color(255, 255, 255));
        deleteButton.setFont(new Font("Ink Free", Font.BOLD, 16));
        deleteButton.setBounds(940, 310, 200, 40);
        contentPane.add(deleteButton);

        nameu = new JLabel("Name");
        nameu.setFont(new Font("Ink Free", Font.BOLD, 16));
        nameu.setBounds(130, 400, 200, 20);
        contentPane.add(nameu);

        nameuT = new JTextField();
        nameuT.setBackground(new Color(200, 220, 230));
        nameuT.setBounds(100, 430, 100, 20);
        contentPane.add(nameuT);
        nameuT.setColumns(10);

        ////////////////////////////////////////////////////////

        title1 = new JLabel("New Title");
        title1.setFont(new Font("Ink Free", Font.BOLD, 16));
        title1.setBounds(110, 480, 200, 20);
        contentPane.add(title1);

        titleT1 = new JTextField();
        titleT1.setBackground(new Color(200, 220, 230));
        titleT1.setBounds(100, 510, 100, 20);
        contentPane.add(titleT1);
        titleT1.setColumns(10);

        rating1 = new JLabel("New R.");
        rating1.setFont(new Font("Ink Free", Font.BOLD, 16));
        rating1.setBounds(240, 480, 200, 20);
        contentPane.add(rating1);

        ratingT1 = new JTextField();
        ratingT1.setBackground(new Color(200, 220, 230));
        ratingT1.setBounds(220, 510, 100, 20);
        contentPane.add(ratingT1);
        ratingT1.setColumns(10);

        calories1 = new JLabel("New C.");
        calories1.setFont(new Font("Ink Free", Font.BOLD, 16));
        calories1.setBounds(360, 480, 200, 20);
        contentPane.add(calories1);

        caloriesT1 = new JTextField();
        caloriesT1.setBackground(new Color(200, 220, 230));
        caloriesT1.setBounds(340, 510, 100, 20);
        contentPane.add(caloriesT1);
        titleT1.setColumns(10);

        protein1 = new JLabel("New P.");
        protein1.setFont(new Font("Ink Free", Font.BOLD, 16));
        protein1.setBounds(480, 480, 200, 20);
        contentPane.add(protein1);

        proteinT1 = new JTextField();
        proteinT1.setBackground(new Color(200, 220, 230));
        proteinT1.setBounds(460, 510, 100, 20);
        contentPane.add(proteinT1);
        titleT1.setColumns(10);

        fat1 = new JLabel("New F.");
        fat1.setFont(new Font("Ink Free", Font.BOLD, 16));
        fat1.setBounds(610, 480, 200, 20);
        contentPane.add(fat1);

        fatT1 = new JTextField();
        fatT1.setBackground(new Color(200, 220, 230));
        fatT1.setBounds(580, 510, 100, 20);
        contentPane.add(fatT1);
        fatT1.setColumns(10);

        sodium1 = new JLabel("New S.");
        sodium1.setFont(new Font("Ink Free", Font.BOLD, 16));
        sodium1.setBounds(720, 480, 200, 20);
        contentPane.add(sodium1);

        sodiumT1 = new JTextField();
        sodiumT1.setBackground(new Color(200, 220, 230));
        sodiumT1.setBounds(700, 510, 100, 20);
        contentPane.add(sodiumT1);
        sodiumT1.setColumns(10);

        price1 = new JLabel("New Price");
        price1.setFont(new Font("Ink Free", Font.BOLD, 16));
        price1.setBounds(830, 480, 200, 20);
        contentPane.add(price1);

        priceT1 = new JTextField();
        priceT1.setBackground(new Color(200, 220, 230));
        priceT1.setBounds(820, 510, 100, 20);
        contentPane.add(priceT1);
        priceT1.setColumns(10);

        updateButton = new JButton("UPDATE");
        updateButton.setBackground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Ink Free", Font.BOLD, 16));
        updateButton.setBounds(940, 490, 200, 40);
        contentPane.add(updateButton);


        closeButton = new JButton("Close");
        closeButton.setBackground(new Color(255, 255, 255));
        closeButton.setFont(new Font("Ink Free", Font.BOLD, 16));
        closeButton.setBounds(1300, 750, 200, 40);
        contentPane.add(closeButton);

        importB = new JButton("Import Products");
        importB.setBackground(new Color(255, 255, 255));
        importB.setFont(new Font("Ink Free", Font.BOLD, 16));
        importB.setBounds(1300, 700, 200, 40);
        contentPane.add(importB);


        loginB = new JLabel("LOG IN AS ADMINISTRATOR");
        loginB.setFont(new Font("Ink Free", Font.BOLD, 16));
        loginB.setBounds(200, 20, 400, 20);
        contentPane.add(loginB);

        ////////////////////////////////

        ora1 = new JTextField();
        ora1.setBackground(new Color(200, 220, 230));
        ora1.setBounds(100, 550, 100, 20);
        contentPane.add(ora1);
        ora1.setColumns(10);

        ora2 = new JTextField();
        ora2.setBackground(new Color(200, 220, 230));
        ora2.setBounds(100, 590, 100, 20);
        contentPane.add(ora2);
        ora2.setColumns(10);

        /*min1 = new JTextField();
        min1.setBackground(new Color(200, 220, 230));
        min1.setBounds(210, 550, 100, 20);
        contentPane.add(min1);
        min1.setColumns(10);

        min2 = new JTextField();
        min2.setBackground(new Color(200, 220, 230));
        min2.setBounds(210, 590, 100, 20);
        contentPane.add(min2);
        min2.setColumns(10);*/

        report1B = new JButton("Report1");
        report1B.setBackground(new Color(255, 255, 255));
        report1B.setFont(new Font("Ink Free", Font.BOLD, 16));
        report1B.setBounds(320, 590, 200, 20);
        contentPane.add(report1B);

        ////

        nrCom2 = new JTextField();
        nrCom2.setBackground(new Color(200, 220, 230));
        nrCom2.setBounds(100, 650, 100, 20);
        contentPane.add(nrCom2);
        nrCom2.setColumns(10);

        report2B = new JButton("Report2");
        report2B.setBackground(new Color(255, 255, 255));
        report2B.setFont(new Font("Ink Free", Font.BOLD, 16));
        report2B.setBounds(320, 650, 200, 20);
        contentPane.add(report2B);
        ////////////////////////
        nrCom3 = new JTextField();
        nrCom3.setBackground(new Color(200, 220, 230));
        nrCom3.setBounds(100, 710, 100, 20);
        contentPane.add(nrCom3);
        nrCom3.setColumns(10);

        val = new JTextField();
        val.setBackground(new Color(200, 220, 230));
        val.setBounds(210, 710, 100, 20);
        contentPane.add(val);
        val.setColumns(10);

        report3B = new JButton("Report3");
        report3B.setBackground(new Color(255, 255, 255));
        report3B.setFont(new Font("Ink Free", Font.BOLD, 16));
        report3B.setBounds(320, 710, 200, 20);
        contentPane.add(report3B);

        /////////////////

        nrCom4 = new JTextField();
        nrCom4.setBackground(new Color(200, 220, 230));
        nrCom4.setBounds(100, 770, 100, 20);
        contentPane.add(nrCom4);
        nrCom4.setColumns(10);


        report4B = new JButton("Report4");
        report4B.setBackground(new Color(255, 255, 255));
        report4B.setFont(new Font("Ink Free", Font.BOLD, 16));
        report4B.setBounds(320, 770, 200, 20);
        contentPane.add(report4B);

    }

    public void addCloseListener(ActionListener actionListener) {
        this.closeButton.addActionListener(actionListener);
    }

    public void importBListener(ActionListener actionListener) {
        this.importB.addActionListener(actionListener);
    }

    public void report1Listener(ActionListener actionListener) {
        this.report1B.addActionListener(actionListener);
    }

    public void report2Listener(ActionListener actionListener) {
        this.report2B.addActionListener(actionListener);
    }

    public String getNrCom2() {
        return this.nrCom2.getText();
    }


    public void report3Listener(ActionListener actionListener) {
        this.report3B.addActionListener(actionListener);
    }

    public String getNrCom3() {
        return this.nrCom3.getText();
    }

    public String getValoare() {
        return this.val.getText();
    }

    public void report4Listener(ActionListener actionListener) {
        this.report4B.addActionListener(actionListener);
    }

    public String getNrCom4() {
        return this.nrCom4.getText();
    }

    public String getZiua() {
        return this.ziuaT.getText();
    }

    public void updateListener(ActionListener actionListener) {
        this.updateButton.addActionListener(actionListener);
    }


    public String numeUpdate() {
        return this.nameuT.getText();
    }

    public String getOra1() {
        return this.ora1.getText();
    }

    public String getOra2() {
        return this.ora2.getText();
    }

    public String getMin1() {
        return this.min1.getText();
    }

    public String getMin2() {
        return this.min2.getText();
    }


    public String getTitle() {
        return this.titleT.getText();
    }

    public String getRating() {
        return this.ratingT.getText();
    }

    public String getCalories() {
        return this.caloriesT.getText();
    }

    public String getProteins() {
        return this.proteinT.getText();
    }

    public String getFat() {
        return this.fatT.getText();
    }

    public String getSodium() {
        return this.sodiumT.getText();
    }

    public String getPrice() {
        return this.priceT.getText();
    }

    //////////////////////////////

    public String getTitle1() {
        return this.titleT1.getText();
    }

    public String getRating1() {
        return this.ratingT1.getText();
    }

    public String getCalories1() {
        return this.caloriesT1.getText();
    }

    public String getProteins1() {
        return this.proteinT1.getText();
    }

    public String getFat1() {
        return this.fatT1.getText();
    }

    public String getSodium1() {
        return this.sodiumT1.getText();
    }

    public String getPrice1() {
        return this.priceT1.getText();
    }

    public void adaugareLaMeniuListener(ActionListener actionListener) {
        this.addToMenu.addActionListener(actionListener);
    }

    public void adaugareLaMeniuListener1(ActionListener actionListener) {
        this.addToMenu2.addActionListener(actionListener);
    }


    public void deleteListener(ActionListener actionListener) {
        this.deleteButton.addActionListener(actionListener);
    }

    public String getNameComp() {
        return this.nameT.getText();
    }

    public String nameDelete() {
        return this.namedT.getText();
    }

    public String getCompComp() {
        return this.componentsT.getText();
    }

}