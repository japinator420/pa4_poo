package org.japinator;

public class Almacenamiento extends Producto {
    private String interfaz;
    private int capacidadGB;

    public Almacenamiento(String id, String marca, String modelo, double precio, int stock,
                          String interfaz, int capacidadGB) {
        super(id, marca, modelo, precio, stock);
        this.interfaz = interfaz;
        this.capacidadGB = capacidadGB;
    }

    public String getInterfaz() {
        return interfaz;
    }

    public int getCapacidadGB() {
        return capacidadGB;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Almacenamiento (%s, %d GB)",
                interfaz, capacidadGB);
    }
}
