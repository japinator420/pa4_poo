package org.japinator;

public class Monitor extends Producto implements Garantizable{

    private int pulgadas;
    private int mesesGarantia;

    public Monitor(String id, String marca, String modelo, double precio, int stock,
                   int pulgadas, int mesesGarantia){
        super(id, marca, modelo, precio, stock);
        this.pulgadas=pulgadas;
        this.mesesGarantia=mesesGarantia;
    }

    @Override
    public String obtenerDetalleGarantia() {
        return mesesGarantia + " meses de garantía oficial con "+ getMarca();
    }

    @Override
    public String toString() {
        return super.toString() + "| Monitor (" + pulgadas +"\")";
    }
}
