
package com.ulp;

public class Usuario {
    private String user;
    private int pass;

    public Usuario() {
    }

    public Usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public boolean validarPassword(int contra) {
        return this.pass == contra;
    }

    public void cambioPassword(String newPass) {
        this.pass = Integer.parseInt(newPass);
    }

    public void delay(int mili) throws InterruptedException {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
            throw e;
        }
    }

    public boolean usuariosDiferentes(Usuario u2) {
        if (u2 == null) return true;
        return !(this.user.equals(u2.getUser()) && this.pass == u2.getPass());
    }

    public String getUser() { return user; }
    public int getPass() { return pass; }
}