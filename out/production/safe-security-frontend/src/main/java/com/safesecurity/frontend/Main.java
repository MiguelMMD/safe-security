package com.safesecurity.frontend;


import com.safesecurity.frontend.ui.LoginView;

public class Main {
    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicia el login
        new LoginView();
    }
}
