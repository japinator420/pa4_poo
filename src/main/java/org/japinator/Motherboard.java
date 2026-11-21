package org.japinator;

public class Motherboard extends Producto {
    private String socket;
    private String factorForma;

    public Motherboard(String id, String marca, String modelo, double precio, int stock,
                       String socket, String factorForma) {
        super(id, marca, modelo, precio, stock);
        this.socket = socket;
        this.factorForma = factorForma;
    }

    public String getSocket() {
        return socket;
    }

    public String getFactorForma() {
        return factorForma;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Motherboard (%s, %s)", socket, factorForma);
    }
}
