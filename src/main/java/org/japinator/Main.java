package org.japinator;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        cargarDatosIniciales();
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();
            int opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> verProductos();
                case 2 -> registrarProducto();
                case 3 -> modificarProducto();
                case 4 -> eliminarProducto();
                case 5 -> imprimirLista(inventario.ordenarPorPrecio());
                case 6 -> imprimirLista(inventario.ordenarPorMarca());
                case 7 -> GestorReposicion.mostrarAlertas(inventario);
                case 8 -> {

                    System.out.println("Saliendo del sistema PCLAB. ¡Hasta luego!");
                    ejecutando = false;
                }
                // APORTE INDIVIDUAL - Andreu Rangel
                case 9 -> ReporteInventario.mostrarReporte(inventario);
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
    private static void mostrarMenu() {
        System.out.println("""

                ====================================================
                     BIENVENIDO AL SISTEMA DE INVENTARIO DE PCLAB
                ====================================================
                ¿Qué desea realizar hoy? (Seleccione una opción)
                ----------------------------------------------------
                1) VER PRODUCTOS
                2) REGISTRAR PRODUCTO
                3) MODIFICAR PRODUCTO
                4) ELIMINAR PRODUCTO
                5) ORDENAR POR PRECIO
                6) ORDENAR POR MARCA
                7) ALERTAS DE REPOSICIÓN Y GARANTÍAS
                8) SALIR
                9) REPORTE GENERAL DE INVENTARIO
                ----------------------------------------------------
                """);
    }

    private static void cargarDatosIniciales() {
        inventario.agregarProducto(new Procesador("CPU-01", "AMD", "Ryzen 5 5700X", 175.00, 8, "AM4", 8));
        inventario.agregarProducto(new Motherboard("MOB-01", "ASUS", "TUF Gaming B550-PLUS", 145.00, 6, "AM4", "ATX"));
        inventario.agregarProducto(new MemoriaRAM("RAM-01", "Corsair", "Vengeance LPX", 75.00, 12, "DDR4", 32, 3200));
        inventario.agregarProducto(new Almacenamiento("STO-01", "Kingston", "NV2 1TB", 62.00, 15, "NVMe M.2", 1000));
        inventario.agregarProducto(new CasePC("CASE-01", "NZXT", "H5 Flow", 90.00, 4, "ATX", "Negro"));
        inventario.agregarProducto(new FuentePoder("PSU-01", "Gigabyte", "P550B", 52.00, 7, 550, "80 Plus Bronze"));
        inventario.agregarProducto(new TarjetaVideo("GPU-01", "NVIDIA", "RTX 4060", 310.00, 5, 8, 242));
        inventario.agregarProducto(new Monitor("MON-01", "LG", "UltraGear 24GN60R", 160.00, 3, 24, 24));
    }

    // Metodos para trabajar los input del usuario de forma rapida, ademas de dar estetica.
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un monto numérico válido.");
            }
        }
    }

    /* Estas son las opciones del menu persistente, las llamamos con un switch en el metodo main */

    // Visualizar los productos del inventario
    private static void verProductos() {
        if (inventario.estaVacio()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("""
                --- VER PRODUCTOS ---
                1) Ver todos
                2) Filtrar por categoría
                3) Buscar por ID
                """);
        int subOpcion = leerEntero("Elige una opción: ");

        switch (subOpcion) {
            case 1 -> imprimirLista(inventario.obtenerTodos());
            case 2 -> filtrarPorCategoria();
            case 3 -> {
                String id = leerTexto("Ingresa el ID del producto: ");
                Producto p = inventario.buscarPorId(id);
                if (p == null) {
                    System.out.println("No se encontró ningún producto con ID: " + id);
                } else {
                    System.out.println(p);
                }
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    /* Aqui hacemos uso de los genericos, extendiendo nuestra clase producto y aprovechando cada
    * override que hicimos en las distintas clases */
    private static <T extends Producto> void imprimirLista(List<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay productos para mostrar en este criterio.");
            return;
        }
        System.out.println("----------------------------------------------------");
        for (T item : lista) {
            System.out.println(item);
        }
        System.out.println("----------------------------------------------------");
    }

    private static Class<? extends Producto> seleccionarCategoria() {
        System.out.println("""
                Categorías:
                1) Procesador       2) Motherboard      3) Memoria RAM
                4) Almacenamiento   5) Case PC          6) Fuente de Poder
                7) Tarjeta de Video 8) Monitor
                """);

        int cat = leerEntero("Selecciona categoría: ");

        return switch (cat) {
            case 1 -> Procesador.class;
            case 2 -> Motherboard.class;
            case 3 -> MemoriaRAM.class;
            case 4 -> Almacenamiento.class;
            case 5 -> CasePC.class;
            case 6 -> FuentePoder.class;
            case 7 -> TarjetaVideo.class;
            case 8 -> Monitor.class;
            default -> null;
        };
    }

    // Hacemos uso de otro metodo de inventario, simplemente solicitamos el tipo/categoria
    private static void filtrarPorCategoria() {
        Class<? extends Producto> categoria = seleccionarCategoria();

        if (categoria == null) {
            System.out.println("Categoría no válida.");
            return;
        }

        imprimirLista(inventario.filtrarPorTipo(categoria));
    }

    // Registro de productos, usamos yield para asignar todos los valores al objeto 'Producto nuevo' segun el tipo
    private static void registrarProducto() {
        System.out.println("""
                --- REGISTRAR PRODUCTO ---
                1) Procesador       2) Motherboard      3) Memoria RAM
                4) Almacenamiento   5) Case PC          6) Fuente de Poder
                7) Tarjeta de Video 8)Monitor
                """);
        int tipo = leerEntero("Tipo de componente: ");

        if (tipo < 1 || tipo > 8) {
            System.out.println("Tipo no válido.");
            return;
        }

        String id = leerTexto("ID único (ej. GPU-02): ");
        if (inventario.buscarPorId(id) != null) {
            System.out.println("Ya existe un producto con ese ID.");
            return;
        }

        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock inicial: ");

        Producto nuevo = switch (tipo) {
            case 1 -> {
                String socket = leerTexto("Socket (ej. AM5, LGA1700): ");
                int nucleos = leerEntero("Número de núcleos: ");
                yield new Procesador(id, marca, modelo, precio, stock, socket, nucleos);
            }
            case 2 -> {
                String socket = leerTexto("Socket: ");
                String factorForma = leerTexto("Factor de forma (ATX, Micro-ATX, Mini-ITX): ");
                yield new Motherboard(id, marca, modelo, precio, stock, socket, factorForma);
            }
            case 3 -> {
                String tipoRam = leerTexto("Tipo (DDR4, DDR5): ");
                int capacidad = leerEntero("Capacidad total (GB): ");
                int velocidad = leerEntero("Velocidad (MHz): ");
                yield new MemoriaRAM(id, marca, modelo, precio, stock, tipoRam, capacidad, velocidad);
            }
            case 4 -> {
                String interfaz = leerTexto("Interfaz (NVMe M.2, SATA): ");
                int capacidad = leerEntero("Capacidad (GB): ");
                yield new Almacenamiento(id, marca, modelo, precio, stock, interfaz, capacidad);
            }
            case 5 -> {
                String soporte = leerTexto("Factor de forma soportado: ");
                String color = leerTexto("Color: ");
                yield new CasePC(id, marca, modelo, precio, stock, soporte, color);
            }
            case 6 -> {

                int vatios = leerEntero("Potencia (W): ");
                String cert = leerTexto("Certificación (80 Plus Bronze, Gold, etc.): ");
                yield new FuentePoder(id, marca, modelo, precio, stock, vatios, cert);
            }
            case 7 -> {
                int vram = leerEntero("VRAM (GB): ");
                int longitud = leerEntero("Longitud (mm): ");
                yield new TarjetaVideo(id, marca, modelo, precio, stock, vram, longitud);
            }
            case 8 -> {
                int pulgadas = leerEntero("Tamaño (pulgadas): ");
                int mesesGarantia = leerEntero("Garantía (meses): ");
                yield new Monitor(id, marca, modelo, precio, stock, pulgadas, mesesGarantia);
            }
            default -> null;
        };

        if (nuevo != null && inventario.agregarProducto(nuevo)) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el producto. Revisa los datos.");
        }
    }

    // Modificamos productos, nos apoyamos de los metodos internos del inventario y sus comprobaciones
    private static void modificarProducto() {
        String id = leerTexto("Ingresa el ID del producto a modificar: ");
        Producto encontrado = inventario.buscarPorId(id);

        if (encontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto actual: " + encontrado);
        System.out.println("""
                1) Actualizar precio
                2) Actualizar stock
                3) Actualizar ambos
                """);
        int op = leerEntero("Elige qué modificar: ");

        switch (op) {
            case 1 -> {
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                if (inventario.actualizarPrecio(id, nuevoPrecio)) {
                    System.out.println("Precio actualizado.");
                } else {
                    System.out.println("Precio inválido (debe ser mayor a 0).");
                }
            }
            case 2 -> {
                int nuevoStock = leerEntero("Nuevo stock: ");
                if (inventario.actualizarStock(id, nuevoStock)) {
                    System.out.println("Stock actualizado.");
                } else {
                    System.out.println("Stock inválido (no puede ser negativo).");
                }
            }
            case 3 -> {
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                int nuevoStock = leerEntero("Nuevo stock: ");
                boolean okPrecio = inventario.actualizarPrecio(id, nuevoPrecio);
                boolean okStock = inventario.actualizarStock(id, nuevoStock);
                if (okPrecio && okStock) {
                    System.out.println("Precio y stock actualizados.");
                } else {
                    System.out.println("Revisa los valores: precio mayor a 0 y stock no negativo.");
                }
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // Eliminamos productos
    private static void eliminarProducto() {
        if (inventario.estaVacio()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("""
                --- ELIMINAR PRODUCTOS ---
                1) Eliminar por ID
                2) Eliminar productos de una categoría
                3) Eliminar todos los productos
                """);

        int subOpcion = leerEntero("Elige una opción: ");

        switch (subOpcion) {
            case 1 -> eliminarPorId();
            case 2 -> eliminarPorCategoria();
            case 3 -> eliminarTodos();
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void eliminarPorId() {
        String id = leerTexto("Ingresa el ID del producto a eliminar: ");
        Producto encontrado = inventario.buscarPorId(id);

        if (encontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Vas a eliminar: " + encontrado);
        String confirmacion = leerTexto("¿Confirmar? (S/N): ");

        if (confirmacion.equalsIgnoreCase("S") && inventario.eliminarProducto(id)) {
            System.out.println("Producto eliminado del inventario.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static void eliminarPorCategoria() {
        Class<? extends Producto> categoria = seleccionarCategoria();

        if (categoria == null) {
            System.out.println("Categoría no válida.");
            return;
        }

        List<? extends Producto> productosCategoria = inventario.filtrarPorTipo(categoria);

        if (productosCategoria.isEmpty()) {
            System.out.println("No existen productos en esta categoría.");
            return;
        }

        System.out.println("Productos que serán eliminados:");
        imprimirLista(productosCategoria);

        String confirmacion = leerTexto("¿Eliminar todos los productos de esta categoría? (S/N): ");

        if (confirmacion.equalsIgnoreCase("S")) {
            int cantidad = inventario.eliminarPorCategoria(categoria);
            System.out.println("Se eliminaron " + cantidad + " productos de la categoría.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static void eliminarTodos() {
        System.out.println("Vas a eliminar todos los productos");
        String confirmacion = leerTexto("¿Confirmar? (S/N): ");

        if (confirmacion.equalsIgnoreCase("S")) {
            int cantidad = inventario.eliminarTodos();
            System.out.println("Se eliminaron " + cantidad + " productos del inventario.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
}