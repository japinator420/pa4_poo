
# PA4 – Sistema de Inventario PCLAB

**Institución:** ISIL  
**Curso:** Programación Orientada a Objetos  
**Evaluación:** PA4 – Semanas 11 a 13  
**Repositorio:** [pa4_poo](https://github.com/japinator420/pa4_poo)

## 1. Descripción del proyecto

PCLAB es una aplicación de consola desarrollada en Java para administrar el inventario de componentes de computadoras. Permite registrar, consultar, modificar, eliminar y ordenar productos, consultar alertas de reposición y garantías, y generar un reporte general del inventario.

## 2. Objetivos

### Objetivo general

Desarrollar un sistema de gestión de inventario aplicando los principios de programación orientada a objetos y las colecciones de Java.

### Objetivos específicos

- Aplicar abstracción, encapsulamiento, herencia y polimorfismo.
- Utilizar interfaces, colecciones y métodos genéricos.
- Administrar productos, precios y existencias.
- Facilitar el ordenamiento y la búsqueda de productos.
- Generar información para el control del inventario.
- Fomentar el trabajo colaborativo mediante Git y GitHub.

## 3. Tecnologías utilizadas

| Tecnología | Aplicación |
|---|---|
| Java | Lenguaje de programación |
| IntelliJ IDEA | Entorno de desarrollo |
| Apache Maven | Gestión y construcción del proyecto |
| Git | Control de versiones |
| GitHub | Repositorio colaborativo |
| Markdown | Documentación técnica |
| Windows PowerShell | Prueba de ejecución del reporte |

## 4. Funcionamiento del sistema

### Entrada

El usuario selecciona opciones e introduce datos mediante la consola, utilizando Scanner.

### Procesamiento

La aplicación administra objetos de tipo Producto y sus especializaciones mediante la clase Inventario. Se realizan operaciones de búsqueda, registro, modificación, eliminación, ordenamiento y generación de reportes.

### Salida

Los resultados se presentan en la consola, incluyendo información de productos, existencias, precios, alertas y reportes.

## 5. Colecciones y programación orientada a objetos

- **ArrayList:** almacena los productos del inventario.
- **HashMap:** permite localizar productos mediante su identificador.
- **TreeMap:** organiza los valores del reporte por categoría.
- **Comparator:** permite ordenar productos por precio y marca.
- **Genéricos:** permiten filtrar productos según su tipo de clase.
- **Abstracción:** la clase abstracta Producto representa los atributos comunes.
- **Encapsulamiento:** los atributos privados se consultan o modifican mediante métodos de acceso.
- **Herencia y polimorfismo:** permiten gestionar diferentes tipos de componentes mediante la referencia Producto.
- **Interfaces:** el proyecto incluye Garantizable para representar el contrato relacionado con garantías.

Ejemplo de colecciones utilizadas en Inventario:

```java
private final List<Producto> productos;
private final Map<String, Producto> indicePorId;
```

## 6. Estructura del proyecto

```text
pa4_poo/
├── src/main/java/org/japinator/
│   ├── Almacenamiento.java
│   ├── CasePC.java
│   ├── FuentePoder.java
│   ├── Garantizable.java
│   ├── GestorReposicion.java
│   ├── Inventario.java
│   ├── Main.java
│   ├── MemoriaRAM.java
│   ├── Monitor.java
│   ├── Motherboard.java
│   ├── Procesador.java
│   ├── Producto.java
│   ├── ReporteInventario.java
│   └── TarjetaVideo.java
├── .gitignore
├── pom.xml
└── README.md
```

| Clase o interfaz | Responsabilidad |
|---|---|
| Main | Ejecutar la aplicación y administrar el menú |
| Producto | Definir ID, marca, modelo, precio y stock |
| Inventario | Administrar productos y operaciones de búsqueda y ordenamiento |
| Almacenamiento | Representar dispositivos de almacenamiento |
| CasePC | Representar gabinetes de computadora |
| FuentePoder | Representar fuentes de alimentación |
| MemoriaRAM | Representar memorias RAM |
| Monitor | Representar monitores |
| Motherboard | Representar placas base |
| Procesador | Representar procesadores |
| TarjetaVideo | Representar tarjetas gráficas |
| Garantizable | Representar el contrato asociado a garantías |
| GestorReposicion | Gestionar la consulta de alertas de reposición y garantías |
| ReporteInventario | Generar el reporte general del inventario |

## 7. Funcionalidades del sistema

| Opción | Funcionalidad |
|---|---|
| 1 | Ver productos |
| 2 | Registrar producto |
| 3 | Modificar producto |
| 4 | Eliminar producto |
| 5 | Ordenar por precio |
| 6 | Ordenar por marca |
| 7 | Alertas de reposición y garantías |
| 8 | Salir |
| 9 | Reporte general de inventario |

## 8. Validaciones implementadas

- Se rechazan productos nulos o con identificadores nulos o vacíos al registrarlos.
- Se evita el registro de identificadores duplicados, normalizando espacios y mayúsculas.
- Se verifica la existencia del producto antes de actualizarlo o eliminarlo.
- Se rechazan precios menores o iguales a cero al actualizar el precio.
- Se rechazan cantidades negativas al actualizar el stock.
- Se controla el ingreso de números enteros mediante el manejo de NumberFormatException.
- Se contempla el inventario vacío antes de generar el reporte.

## 9. Instrucciones de ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/japinator420/pa4_poo.git
```

2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Configurar un JDK compatible con pom.xml y esperar la carga de Maven.
4. Abrir src/main/java/org/japinator/Main.java.
5. Ejecutar el método main() mediante Run.
6. Seleccionar una opción del menú.
7. Para consultar el reporte general, seleccionar 9. Para salir, seleccionar 8.

### Prueba automática desde Windows PowerShell

Con el proyecto compilado y las clases disponibles en target/classes, ejecutar desde la raíz del proyecto:

```powershell
"9","8" | java -cp target/classes org.japinator.Main
```

## 10. Integrantes del equipo y porcentajes de participación

| Integrante | Porcentaje de participación |
|---|---|
| Ariana Tiparra Reyes |100%|
| Amir Alvarez Alvarez |100% |
| Andreu Antonio Rangel |100% |
| Diana Cueva Cerna |100% |
| Fátima Gallardo Ramírez |100% |

## 11. Distribución de responsabilidades y aportes individuales

### Ariana Tiparra Reyes

**Aporte:**  Producto: se agregó abstract a la clase. Inventario: se agregaron los métodos para ordenar por precio y marca.

### Amir Alvarez Alvarez

**Aporte:** Creación de clase Producto e hijos (componentes de PC), Creación de clase Inventario y métodos para mostrar, agregar, actualizar y eliminar productos. Creación del menú persistente, funcionamiento y métodos de control para el input de datos.

### Andreu Antonio Rangel

**Aporte:** Desarrollo e integración del reporte general de inventario PCLAB mediante la creación de la clase ReporteInventario.java, incorporación de la opción 9 en el menú de Main.java, prueba de ejecución mediante Windows PowerShell y elaboración de la documentación README.md.

La funcionalidad permite consultar la cantidad de productos diferentes, las unidades disponibles, el valor total del inventario, el precio promedio, los productos de mayor y menor precio y el valor del inventario por categoría.

Se conservaron las funcionalidades existentes del equipo.

### Diana Cueva Cerna

**Aporte:**  Creacion de la interfaz garantizable y subclase Monitor. Implementación del módulo GestorReposicion.

### Fátima Gallardo Ramírez

**Aporte:**  Creación de método seleccionarCategoría, y métodos para eliminar productos por id, por categoría y todos en general.

## 12. Pruebas realizadas

| Prueba | Estado |
|---|---|
| Compilación y ejecución inicial | Comprobada |
| Visualización del menú con opción 9 | Comprobada |
| Generación automática del reporte | Comprobada |
| Retorno al menú y salida mediante opción 8 | Comprobada |
| Suma de valores por categoría | Comprobada |

## 13. Evidencias del proyecto

Espacio reservado para incorporar las capturas de pantalla:

- Estructura del proyecto en IntelliJ IDEA.
- Menú principal y operaciones de inventario.
- Código de ReporteInventario.java.
- Integración de la opción 9 en Main.java.
- Ejecución del reporte en PowerShell.
- Historial de commits y Pull Requests en GitHub.

## 14. Video de exposición

**Enlace del video: https://youtu.be/EHlN57b03Dw**

Contenido sugerido: presentación del proyecto, objetivos, tecnologías, estructura de clases, demostración del menú, reporte general y aportes individuales.

## 15. Trabajo colaborativo con GitHub

El proyecto utiliza un repositorio compartido y ramas individuales para organizar los cambios.

Flujo de trabajo:

1. Clonar el repositorio.
2. Crear o seleccionar una rama individual.
3. Desarrollar la funcionalidad asignada.
4. Guardar y probar los cambios.
5. Realizar un commit descriptivo.
6. Subir la rama mediante push.
7. Crear un Pull Request.
8. Revisar e integrar los cambios en la rama principal.

La publicación e integración del aporte de Andreu quedan pendientes al momento de esta documentación.

## 16. Reporte general de inventario

El método `ReporteInventario.mostrarReporte(inventario)` obtiene los productos registrados y calcula indicadores para facilitar el control del inventario.

### Resultados observados

| Indicador | Resultado |
|---|---:|
| Productos diferentes | 8 |
| Unidades disponibles | 60 |
| Valor total del inventario | $6,854.00 |
| Precio promedio reportado | $133.63 |
| Producto de mayor precio | NVIDIA RTX 4060 – $310.00 |
| Producto de menor precio | Gigabyte P550B – $52.00 |

### Valor por categoría

| Categoría | Valor |
|---|---:|
| Almacenamiento | $930.00 |
| CasePC | $360.00 |
| FuentePoder | $364.00 |
| MemoriaRAM | $900.00 |
| Monitor | $480.00 |
| Motherboard | $870.00 |
| Procesador | $1,400.00 |
| TarjetaVideo | $1,550.00 |
| **Total** | **$6,854.00** |

El valor del inventario se calcula multiplicando el precio unitario de cada producto por su stock y sumando los subtotales. El precio promedio corresponde a la media de los precios de los productos diferentes, no al valor total dividido entre las unidades disponibles. Los resultados corresponden a la ejecución observada; queda pendiente contrastar los datos individuales.

## 17. Conclusiones

El proyecto PCLAB permite aplicar los principios de programación orientada a objetos al desarrollo de un sistema de inventario de componentes informáticos.

El uso de colecciones facilita la organización, búsqueda y procesamiento de productos. La incorporación del reporte general aporta información económica y operativa para el control de existencias.

Asimismo, Git y GitHub permiten organizar las contribuciones individuales y mantener un historial de cambios para su posterior revisión e integración por el equipo.
