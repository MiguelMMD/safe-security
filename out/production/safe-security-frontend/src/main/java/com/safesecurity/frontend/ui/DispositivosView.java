package com.safesecurity.frontend.ui;

import com.safesecurity.frontend.http.HttpClient;

import javax.swing.*;
import java.awt.*;

public class DispositivosView extends JFrame {

    private JTextField usuarioId;
    private JTextArea resultado;
    private JButton cargar;

    public DispositivosView() {
        setTitle("Dispositivos");
        setSize(500,400);
        setLocationRelativeTo(null);

        usuarioId = new JTextField();
        cargar = new JButton("Cargar dispositivos");
        resultado = new JTextArea();

        JPanel top = new JPanel(new GridLayout(3,1));
        top.add(new JLabel("ID de usuario:"));
        top.add(usuarioId);
        top.add(cargar);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        cargar.addActionListener(e -> cargar());
    }

    private void cargar() {
        try {
            String id = usuarioId.getText();

            String response = HttpClient.get(
                    "http://localhost:9090/dispositivos/" + id
            );

            resultado.setText(response);

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al consultar dispositivos.");
        }
    }
}
