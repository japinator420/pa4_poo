package org.japinator;

public class CasePC extends Producto {
    private String factorFormaSoporte;
    private String color;

    public CasePC(String id, String marca, String modelo, double precio, int stock,
                  String factorFormaSoporte, String color) {
        super(id, marca, modelo, precio, stock);
        this.factorFormaSoporte = factorFormaSoporte;
        this.color = color;
    }

    public String getFactorFormaSoporte() {
        return factorFormaSoporte;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Case (%s, %s)", factorFormaSoporte, color);
    }
}
