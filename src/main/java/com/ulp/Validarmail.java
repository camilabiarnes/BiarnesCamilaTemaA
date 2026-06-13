package com.ulp;

import javax.swing.JOptionPane;

public class Validarmail {
    public static void main(String[] args) {
        boolean arroba = false;
        boolean punto = false;
        String mail = JOptionPane.showInputDialog("Ingrese su email por favor: ");
        if (mail != null) {
            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba = true;
                }
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }
            if (arroba == true && punto == true) {
                System.out.println("El mail ingresado es correcto");
            } else {
                System.out.println("El mail ingresado es incorrecto");
            }
        }
    }
}