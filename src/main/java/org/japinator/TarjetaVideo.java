package org.japinator;

public class TarjetaVideo extends Producto {
    private int vramGB;
    private int longitudMm;

    public TarjetaVideo(String id, String marca, String modelo, double precio, int stock, int vramGB, int longitudMm) {
        super(id, marca, modelo, precio, stock);
        this.vramGB = vramGB;
        this.longitudMm = longitudMm;
    }

    public int getVramGB() {
        return vramGB;
    }

    public int getLongitudMm() {
        return longitudMm;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | GPU (%d GB VRAM, %d mm)", vramGB, longitudMm);
    }
}
