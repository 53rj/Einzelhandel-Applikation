package ProjektSupermarkt;

import java.util.Scanner;
import javax.swing.*;

public class LoginGUI extends JFrame {

    private JTextField nameField, passwordField; // grafische Elemente
    private JPanel hauptPanel;
    JButton loginButton;
    private Scanner sc;

    public LoginGUI(String titel) {

        super(titel); // Konstruktor von JFrame
        hauptPanel = new JPanel(); // neues Panel wird erzeugt
        nameField = new JTextField("Name");
        hauptPanel.add(nameField);
        passwordField = new JTextField("Password");
        hauptPanel.add(passwordField);
        this.add(hauptPanel);

        loginButton = new JButton("Login");
        hauptPanel.add(loginButton);

        this.setSize(300, 200);
        this.setVisible(true);
    }

}
