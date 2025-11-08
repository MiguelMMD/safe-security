package com.safesecurity.frontend.ui;

import com.safesecurity.frontend.http.HttpClient;
import javax.swing.*;
import java.awt.*;

public class ContactosView extends JFrame {

    private JTextField userIdField;
    private JButton cargarButton;

    private JTextArea resultadoArea;

    public ContactosView() {

        setTitle("Contactos");
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,1));

        userIdField = new JTextField();
        cargarButton = new JButton("Cargar contactos");
        resultadoArea = new JTextArea();

        panel.add(new JLabel("ID del usuario:"));
        panel.add(userIdField);
        panel.add(cargarButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        cargarButton.addActionListener(e -> cargar());
    }

    private void cargar() {
        try {
            String id = userIdField.getText();

            String response = HttpClient.get("http://localhost:9090/contactos/" + id);

            resultadoArea.setText(response);

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al consultar contactos.");
        }
    }
}
