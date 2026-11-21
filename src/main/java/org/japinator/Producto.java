package org.japinator;

public class Producto {
    private String id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;

    public Producto(String id, String marca, String modelo, double precio, int stock) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s | $%.2f | Stock: %d", id, marca, modelo, precio, stock);
    }
}
