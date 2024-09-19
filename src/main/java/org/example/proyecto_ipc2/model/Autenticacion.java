package org.example.proyecto_ipc2.model;

public class Autenticacion {
    private String email;
    private String password;

    public Autenticacion(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean autenticar(String emailInput, String passwordInput) {
        return this.email.equals(emailInput) && this.password.equals(passwordInput);
    }
}
