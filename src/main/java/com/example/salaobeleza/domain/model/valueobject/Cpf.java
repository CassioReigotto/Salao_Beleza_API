package com.example.salaobeleza.domain.model.valueobject;

public class Cpf {

    private final String numero;

    public Cpf(String numero) {
        if (!numero.matches("\\d{11}")){
            throw new IllegalArgumentException("Cpf invalido");
        }

        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cpf)) return false;
        Cpf cpf = (Cpf) obj;
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }


}
