package com.example.salaobeleza.domain.model.valueobject;


import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private final String endereco;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    public Email(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("O e-mail não pode ser nulo ou vazio.");
        }

        if (!EMAIL_PATTERN.matcher(endereco).matches()) {
            throw new IllegalArgumentException("E-mail inválido: " + endereco);
        }

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return endereco.equalsIgnoreCase(email.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco.toLowerCase());
    }

    @Override
    public String toString() {
        return endereco;
    }
}
