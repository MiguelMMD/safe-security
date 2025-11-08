package com.safesecurity.frontend.ui;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {

    private JButton contactosBtn;
    private JButton alertasBtn;
    private JButton dispositivosBtn;
    private JButton salirBtn;

    public MenuPrincipalView() {

        setTitle("Safe Security - Menú Principal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        contactosBtn = new JButton("Gestión de Contactos");
        alertasBtn = new JButton("Ver Alertas");
        dispositivosBtn = new JButton("Gestionar Dispositivos");
        salirBtn = new JButton("Salir");

        panel.add(contactosBtn);
        panel.add(alertasBtn);
        panel.add(dispositivosBtn);
        panel.add(salirBtn);

        add(panel);

        // ✅ ABRIR CONTACTOS
        contactosBtn.addActionListener(e -> {
            new ContactosView().setVisible(true);
        });

        // ✅ ABRIR ALERTAS
        alertasBtn.addActionListener(e -> {
            new AlertasView().setVisible(true);
        });

        // ✅ ABRIR DISPOSITIVOS
        dispositivosBtn.addActionListener(e -> {
            new DispositivosView().setVisible(true);
        });

        // ✅ SALIR
        salirBtn.addActionListener(e -> {
            System.exit(0);
        });
    }
}
