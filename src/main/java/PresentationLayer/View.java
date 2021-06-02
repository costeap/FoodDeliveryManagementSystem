package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
    Role[] r = {};
    private JPanel contentPane;
    private JButton administrator;
    private JButton adaugare;
    private JButton employee;
    private JLabel login;
    private JLabel login1;
    private JLabel userLabel;
    private JTextField userText;
    private JLabel userLabel1;
    private JTextField userText1;
    private JLabel passwordLabel;
    private JLabel passwordLabel1;
    private JTextField roleText1;
    private JLabel roleLabel1;
    private JPasswordField passwordText;
    private JPasswordField passwordText1;
    private JComboBox c1;


    public View() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(195, 215, 185));

        login = new JLabel("SIGN IN");
        login.setFont(new Font("Ink Free", Font.BOLD, 16));
        login.setBounds(150, 50, 200, 40);
        contentPane.add(login);

        login1 = new JLabel("+");
        login1.setFont(new Font("Ink Free", Font.BOLD, 16));
        login1.setBounds(750, 50, 200, 40);
        contentPane.add(login1);

        administrator = new JButton("->");
        administrator.setBackground(new Color(255, 255, 255));
        administrator.setFont(new Font("Ink Free", Font.BOLD, 16));
        administrator.setBounds(100, 100, 200, 40);
        contentPane.add(administrator);

        /*client = new JButton("Client");
        client.setBackground(new Color(255, 255, 255));
        client.setFont(new Font("Ink Free", Font.BOLD, 16));
        client.setBounds(100, 160, 200, 40);
        contentPane.add(client);

        employee = new JButton("Employee");
        employee.setBackground(new Color(255, 255, 255));
        employee.setFont(new Font("Ink Free", Font.BOLD, 16));
        employee.setBounds(100, 220, 200, 40);
        contentPane.add(employee);*/

        userLabel = new JLabel("User");
        userLabel.setFont(new Font("Ink Free", Font.BOLD, 16));
        userLabel.setBounds(400, 100, 80, 25);
        contentPane.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(450, 100, 165, 25);
        contentPane.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Ink Free", Font.BOLD, 16));
        passwordLabel.setBounds(365, 140, 80, 25);
        contentPane.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(450, 140, 165, 25);
        contentPane.add(passwordText);

        ////////////////////////////////////////////////////
        userLabel1 = new JLabel("User");
        userLabel1.setFont(new Font("Ink Free", Font.BOLD, 16));
        userLabel1.setBounds(700, 100, 80, 25);
        contentPane.add(userLabel1);

        userText1 = new JTextField(20);
        userText1.setBounds(750, 100, 165, 25);
        contentPane.add(userText1);

        passwordLabel1 = new JLabel("Password");
        passwordLabel1.setFont(new Font("Ink Free", Font.BOLD, 16));
        passwordLabel1.setBounds(665, 140, 80, 25);
        contentPane.add(passwordLabel1);

        passwordText1 = new JPasswordField();
        passwordText1.setBounds(750, 140, 165, 25);
        contentPane.add(passwordText1);

        roleLabel1 = new JLabel("Role");
        roleLabel1.setFont(new Font("Ink Free", Font.BOLD, 16));
        roleLabel1.setBounds(705, 180, 80, 25);
        contentPane.add(roleLabel1);

        /*roleText1 = new JPasswordField();
        roleText1.setBounds(750, 180, 165, 25);
        contentPane.add(roleText1);*/

        adaugare = new JButton("+");
        adaugare.setBackground(new Color(255, 255, 255));
        adaugare.setFont(new Font("Ink Free", Font.BOLD, 16));
        adaugare.setBounds(750, 240, 165, 40);
        contentPane.add(adaugare);

        Role[] roluri = new Role[]{Role.ADMIN, Role.EMPLOYEE, Role.CLIENT};
        c1 = new JComboBox<Role>(roluri);
        c1.setBackground(new Color(255, 255, 255));
        c1.setFont(new Font("Ink Free", Font.BOLD, 16));
        c1.setBounds(750, 180, 165, 25);
        contentPane.add(c1);

    }

    public void administratorListener(ActionListener actionListener) {
        this.administrator.addActionListener(actionListener);
    }

    public void adaugareListener(ActionListener actionListener) {
        this.adaugare.addActionListener(actionListener);
    }

    public void employeeListener(ActionListener actionListener) {
        this.employee.addActionListener(actionListener);
    }

    public String getUser() {
        return this.userText.getText();
    }

    public String getPassword() {
        return this.passwordText.getText();
    }

    public String getUser1() {
        return this.userText1.getText();
    }

    public String getPassword1() {
        return this.passwordText1.getText();
    }

    public String getRole1() {
        return this.roleText1.getText();
    }

    public Role getUserCombo1() {
        return (Role) this.c1.getSelectedItem();
    }


}
