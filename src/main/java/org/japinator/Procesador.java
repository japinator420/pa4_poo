package org.japinator;

public class Procesador extends Producto{
    private String socket;
    private int nucleos;

    public Procesador(String id, String marca, String modelo, double precio, int stock, String socket, int nucleos) {
        super(id, marca, modelo, precio, stock);
        this.socket = socket;
        this.nucleos = nucleos;
    }

    public String getSocket() {
        return socket;
    }

    public int getNucleos() {
        return nucleos;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | CPU (%s, %d núcleos)", socket, nucleos);
    }
}
