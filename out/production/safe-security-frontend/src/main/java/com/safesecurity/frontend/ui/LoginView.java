package com.safesecurity.frontend.ui;

import com.safesecurity.frontend.http.HttpClient;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {

        setTitle("Safe Security - Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        panel.add(new JLabel("Correo:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Ingresar");
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> login());
    }

    private void login() {
        try {
            JSONObject json = new JSONObject();
            json.put("email", emailField.getText());
            json.put("password", new String(passwordField.getPassword()));

            String response = HttpClient.post(
                    "http://localhost:9090auth/login",
                    json.toString()
            );

            JOptionPane.showMessageDialog(this, "Bienvenido: " + response);

            new MenuPrincipalView().setVisible(true);
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas");
        }
    }

    public static void main(String[] args) {
        new LoginView().setVisible(true);
    }
}
