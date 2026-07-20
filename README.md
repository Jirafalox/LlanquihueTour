# LlanquihueTourEFT

Prototipo de sistema de gestión desarrollado para la agencia de turismo **Llanquihue Tour**, como Evaluación Final Transversal de la asignatura Desarrollo Orientado a Objetos I.

## Descripción general del sistema

El prototipo busca digitalizar parte de la operación de la agencia, permitiendo gestionar clientes, guías turísticos, operadores de transporte, proveedores de alojamiento y reservas de paquetes turísticos, aplicando los principios de la Programación Orientada a Objetos: encapsulamiento, composición, herencia, polimorfismo, interfaces y manejo de colecciones.

Los datos de los clientes se cargan desde un archivo de texto externo (`recursos/clientes.txt`), y el resto de las entidades se crean directamente desde el código como datos de prueba.

## Estructura del proyecto

```
src/
├── model/
│   ├── Persona.java              (clase base común)
│   ├── Rut.java                  (valida formato y se relaciona por composición con Persona)
│   ├── RutInvalidoException.java (excepción personalizada)
│   ├── Direccion.java            (usada por composición en ProveedorAlojamiento)
│   ├── Cliente.java              (hereda de Persona)
│   ├── Registrable.java          (interfaz: registrar(), mostrarDatos())
│   ├── GuiaTuristico.java        (hereda de Persona, implementa Registrable)
│   ├── OperadorTransporte.java   (hereda de Persona, implementa Registrable)
│   ├── ProveedorAlojamiento.java (hereda de Persona, implementa Registrable)
│   ├── PaqueteTuristico.java
│   └── Reserva.java              (compuesta por Cliente y PaqueteTuristico, constructor sobrecargado)
├── data/
│   ├── GestorClientes.java       (colección de clientes: agregar, mostrar, buscar)
│   ├── GestorRegistrables.java   (List<Registrable>, recorrido con instanceof)
│   └── GestorReservas.java       (colección de reservas: agregar, mostrar, filtrar por estado)
├── utils/
│   └── LectorArchivo.java        (lee recursos/clientes.txt y genera objetos Cliente)
└── app/
    └── Main.java                 (punto de entrada del programa)
    └── MenuInteractivo		  (interfaz gráfica del programa para el usuario)
	

recursos/
└── clientes.txt                  (datos de prueba para la carga de clientes)
```

## Clases e interfaces principales

- **Persona / Rut / Direccion**: clases base que aplican encapsulamiento y composición (Persona contiene un Rut, ProveedorAlojamiento contiene una Direccion).
- **RutInvalidoException**: excepción personalizada, se lanza cuando el formato de un RUT no es válido.
- **Cliente, GuiaTuristico, OperadorTransporte, ProveedorAlojamiento**: heredan de Persona y representan las distintas entidades del sistema.
- **Registrable**: interfaz común implementada por GuiaTuristico, OperadorTransporte y ProveedorAlojamiento, con los métodos `registrar()` y `mostrarDatos()`.
- **PaqueteTuristico / Reserva**: modelan los paquetes turísticos y sus reservas (Reserva se compone de un Cliente y un PaqueteTuristico, y cuenta con un constructor sobrecargado).
- **GestorClientes / GestorRegistrables / GestorReservas**: administran las distintas colecciones del sistema, incluyendo recorrido, búsqueda, filtrado y uso de `instanceof`.
- **LectorArchivo**: clase utilitaria que lee el archivo `clientes.txt` y construye los objetos `Cliente` correspondientes.

## Instrucciones para clonar y ejecutar el proyecto

1. Clonar el repositorio:
   ```
   git clone <url-del-repositorio>
   ```
2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Verificar que la carpeta `recursos/` (con el archivo `clientes.txt`) se mantenga en la raíz del proyecto, ya que `Main` la lee con una ruta relativa.
4. Ubicar la clase `Main`, dentro del paquete `app`.
5. Ejecutar `Main.java` (botón derecho -> Run 'Main.main()').
6. El programa mostrará por consola, en orden: la carga de clientes desde archivo, el registro de guías/operadores/proveedores, y la gestión de reservas.

> Requisito: JDK 17 o superior.