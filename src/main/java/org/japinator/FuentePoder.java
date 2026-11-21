package org.japinator;

public class FuentePoder extends Producto {
    private int vatios;
    private String certificacion;

    public FuentePoder(String id, String marca, String modelo, double precio, int stock,
                       int vatios, String certificacion) {
        super(id, marca, modelo, precio, stock);
        this.vatios = vatios;
        this.certificacion = certificacion;
    }

    public int getVatios() {
        return vatios;
    }

    public String getCertificacion() {
        return certificacion;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | PSU (%dW, %s)", vatios, certificacion);
    }
}
