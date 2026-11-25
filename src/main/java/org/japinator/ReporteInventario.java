
package org.japinator;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// APORTE INDIVIDUAL - Andreu Rangel
// Reporte general del inventario PCLAB

public class ReporteInventario {

    public static void mostrarReporte(Inventario inventario) {

        List<Producto> productos = inventario.obtenerTodos();

        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        int totalProductos = productos.size();
        long totalUnidades = 0;
        double valorTotal = 0;
        double sumaPrecios = 0;

        Producto mayorPrecio = productos.get(0);
        Producto menorPrecio = productos.get(0);

        Map<String, Double> valorPorCategoria = new TreeMap<>();

        for (Producto p : productos) {

            totalUnidades += p.getStock();

            double subtotal = p.getPrecio() * p.getStock();

            valorTotal += subtotal;
            sumaPrecios += p.getPrecio();

            if (p.getPrecio() > mayorPrecio.getPrecio()) {
                mayorPrecio = p;
            }

            if (p.getPrecio() < menorPrecio.getPrecio()) {
                menorPrecio = p;
            }

            String categoria = p.getClass().getSimpleName();

            valorPorCategoria.merge(
                    categoria,
                    subtotal,
                    Double::sum
            );
        }

        double precioPromedio = sumaPrecios / totalProductos;

        System.out.println("\n==========================================");
        System.out.println("    REPORTE GENERAL DE INVENTARIO PCLAB");
        System.out.println("==========================================");

        System.out.println("Productos diferentes: " + totalProductos);
        System.out.println("Unidades disponibles: " + totalUnidades);

        System.out.printf("Valor total del inventario: $%.2f%n",
                valorTotal);

        System.out.printf("Precio promedio: $%.2f%n",
                precioPromedio);

        System.out.println("------------------------------------------");

        System.out.println("PRODUCTO DE MAYOR PRECIO");
        System.out.println(mayorPrecio);

        System.out.println("------------------------------------------");

        System.out.println("PRODUCTO DE MENOR PRECIO");
        System.out.println(menorPrecio);

        System.out.println("------------------------------------------");
        System.out.println("VALOR DEL INVENTARIO POR CATEGORÍA");
        System.out.println("------------------------------------------");

        for (Map.Entry<String, Double> entrada
                : valorPorCategoria.entrySet()) {

            System.out.printf("%-20s $%.2f%n",
                    entrada.getKey(),
                    entrada.getValue());
        }

        System.out.println("==========================================");
    }
}
