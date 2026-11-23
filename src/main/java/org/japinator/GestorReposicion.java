package org.japinator;

import java.util.*;

public class GestorReposicion {

    public static void mostrarAlertas(Inventario inventario) {

        List<Producto> criticos = inventario.obtenerTodos();

        criticos.removeIf(p -> p.getStock() > 5);

        if (criticos.isEmpty()){
            System.out.println("Todo el inventario tiene stock suficiente");
            return;
        }

        Set<String> marcasPorReponer = new HashSet<>();

        List<Integer> stocksCriticos = new ArrayList<>();

        System.out.println(" ALERTA DE REPOSICION (STOCK <=5) ");

        Iterator<Producto> it = criticos.iterator();
        while (it.hasNext()){
            Producto p = it.next();
            System.out.println("- "+p);
            marcasPorReponer.add(p.getMarca().toUpperCase());
            stocksCriticos.add(p.getStock());
        }

        int stockMinimo = stocksCriticos.get(0);
        for (Integer s : stocksCriticos) {
            stockMinimo = Integer.min(stockMinimo, s);
        }

        System.out.println("Marcas a contactar (" + marcasPorReponer.size() + "): " + marcasPorReponer);
        System.out.println("Nivel de stock más bajo registrado: " + stockMinimo + " unidades.");

        System.out.println("--- GARANTÍA DE MONITORES ---");
        for (Monitor m : inventario.filtrarPorTipo(Monitor.class)) {
            System.out.println(m.getMarca() + " " + m.getModelo() + " -> " + m.obtenerDetalleGarantia());
        }
    }
}
