package org.japinator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    private final List<Producto> productos;
    private final Map<String, Producto> indicePorId;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.indicePorId = new HashMap<>();
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null || producto.getId() == null || producto.getId().isBlank()) {
            return false;
        }
        String clave = producto.getId().trim().toUpperCase();
        if (indicePorId.containsKey(clave)) {
            return false; // Evita IDs duplicados
        }
        productos.add(producto);
        indicePorId.put(clave, producto);
        return true;
    }

    public Producto buscarPorId(String id) {
        if (id == null) {
            return null;
        }
        return indicePorId.get(id.trim().toUpperCase());
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    public <T extends Producto> List<T> filtrarPorTipo(Class<T> tipoClase) {
        List<T> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (tipoClase.isInstance(p)) {
                resultado.add(tipoClase.cast(p));
            }
        }
        return resultado;
    }

    public boolean actualizarPrecio(String id, double nuevoPrecio) {
        Producto encontrado = buscarPorId(id);
        if (encontrado == null || nuevoPrecio <= 0) {
            return false;
        }
        encontrado.setPrecio(nuevoPrecio);
        return true;
    }

    public boolean actualizarStock(String id, int nuevoStock) {
        Producto encontrado = buscarPorId(id);
        if (encontrado == null || nuevoStock < 0) {
            return false;
        }
        encontrado.setStock(nuevoStock);
        return true;
    }

    public boolean eliminarProducto(String id) {
        Producto eliminado = buscarPorId(id);
        if (eliminado == null) {
            return false;
        }
        String clave = eliminado.getId().trim().toUpperCase();
        productos.remove(eliminado);
        indicePorId.remove(clave);
        return true;
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
