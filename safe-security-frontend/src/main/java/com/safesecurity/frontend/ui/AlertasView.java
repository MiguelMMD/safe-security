package com.safesecurity.frontend.ui;

import com.safesecurity.frontend.http.HttpClient;

import javax.swing.*;
import java.awt.*;

public class AlertasView extends JFrame {

    private JTextField usuarioId;
    private JButton cargar;
    private JTextArea resultado;

    public AlertasView() {

        setTitle("Alertas");
        setSize(500,400);
        setLocationRelativeTo(null);

        usuarioId = new JTextField();
        cargar = new JButton("Cargar alertas");
        resultado = new JTextArea();

        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(new JLabel("ID usuario:"));
        panel.add(usuarioId);
        panel.add(cargar);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        cargar.addActionListener(e -> cargar());
    }

    private void cargar() {
        try {
            String id = usuarioId.getText();

            String response = HttpClient.get(
                    "http://localhost:9090/alertas/" + id
            );

            resultado.setText(response);

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "No se pudieron cargar alertas.");
        }
    }
}
