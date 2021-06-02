package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BusinessLayer.DeliveryService;
import BusinessLayer.Order;

@SuppressWarnings({"deprecation", "serial"})
public class EmployeeGraphicalUserInterface extends JFrame implements Observer {
    private JLabel loginB;
    private JPanel contentPane;
    private JButton closeButton;
    public DeliveryService ds = new DeliveryService();

    public EmployeeGraphicalUserInterface() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1800, 850);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(195, 215, 185));

        loginB = new JLabel("LOG IN AS EMPLOYEE");
        loginB.setFont(new Font("Ink Free", Font.BOLD, 16));
        loginB.setBounds(200, 20, 400, 20);
        contentPane.add(loginB);

        closeButton = new JButton("Close");
        closeButton.setBackground(new Color(255, 255, 255));
        closeButton.setFont(new Font("Ink Free", Font.BOLD, 16));
        closeButton.setBounds(1300, 750, 200, 40);
        contentPane.add(closeButton);
    }

    public void addCloseListener(ActionListener actionListener) {
        this.closeButton.addActionListener(actionListener);
    }


    public void update() {

        this.setVisible(true);
        int i = JOptionPane.showConfirmDialog(null, "Command", "Notification !", 2);
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Employee will prepare the order!");
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Employee is busy now, but will still prepare the order later!");
            this.setVisible(false);
        }


    }

    @Override
    public void update(Observable o, Object arg) {

    }
}