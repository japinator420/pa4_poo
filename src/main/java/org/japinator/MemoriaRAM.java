package org.japinator;

public class MemoriaRAM extends Producto {
    private String tipo;
    private int capacidadGB;
    private int velocidadMHz;

    public MemoriaRAM(String id, String marca, String modelo, double precio, int stock,
                      String tipo, int capacidadGB, int velocidadMHz) {
        super(id, marca, modelo, precio, stock);
        this.tipo = tipo;
        this.capacidadGB = capacidadGB;
        this.velocidadMHz = velocidadMHz;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidadGB() {
        return capacidadGB;
    }

    public int getVelocidadMHz() {
        return velocidadMHz;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | RAM (%s, %d GB, %d MHz)",
                tipo, capacidadGB, velocidadMHz);
    }
}