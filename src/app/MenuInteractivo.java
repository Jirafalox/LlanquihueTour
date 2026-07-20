package app;

import data.GestorClientes;
import data.GestorRegistrables;
import data.GestorReservas;
import model.*;
import utils.LectorArchivo;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Menu grafico simple, construido con JOptionPane, que permite usar el
 * sistema de forma interactiva: cargar clientes desde archivo, buscar
 * clientes, registrar nuevas entidades, crear reservas y consultar las
 * distintas colecciones, en vez de ejecutar todo de forma fija por
 * consola como en la primera version del programa.
 *
 * No se requiere persistencia ni un diseño complejo, solo una
 * secuencia de cuadros de dialogo encadenados.
 */
public class MenuInteractivo {

    private GestorClientes gestorClientes;
    private GestorRegistrables gestorRegistrables;
    private GestorReservas gestorReservas;

    // Paquetes turisticos de ejemplo, disponibles para armar reservas
    private ArrayList<PaqueteTuristico> paquetesDisponibles;

    public MenuInteractivo() {
        gestorClientes = new GestorClientes();
        gestorRegistrables = new GestorRegistrables();
        gestorReservas = new GestorReservas();

        paquetesDisponibles = new ArrayList<>();
        paquetesDisponibles.add(new PaqueteTuristico("Circuito Lagos y Volcanes", "Puerto Varas", 3, 120000));
        paquetesDisponibles.add(new PaqueteTuristico("Ruta Gastronomica Frutillar", "Frutillar", 1, 45000));
    }

    // Muestra el menu principal en un ciclo hasta que el usuario elige salir
    public void iniciar() {

        boolean continuar = true;

        while (continuar) {

            String[] opciones = {
                    "Cargar clientes desde archivo",
                    "Buscar cliente por nombre",
                    "Registrar nueva entidad",
                    "Ver entidades registradas",
                    "Crear una reserva",
                    "Ver reservas registradas",
                    "Salir"
            };

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opcion:",
                    "Llanquihue Tour - Menu principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    cargarClientes();
                    break;
                case 1:
                    buscarCliente();
                    break;
                case 2:
                    registrarEntidad();
                    break;
                case 3:
                    verEntidades();
                    break;
                case 4:
                    crearReserva();
                    break;
                case 5:
                    verReservas();
                    break;
                default:
                    // El usuario eligio "Salir" o cerro la ventana
                    continuar = false;
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema de Llanquihue Tour.");
    }

    // Opcion: lee recursos/clientes.txt y agrega los clientes encontrados a la coleccion
    private void cargarClientes() {
        ArrayList<Cliente> clientesDesdeArchivo = LectorArchivo.leerClientes("recursos/clientes.txt");

        for (Cliente cliente : clientesDesdeArchivo) {
            gestorClientes.agregarCliente(cliente);
        }

        if (clientesDesdeArchivo.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No se cargo ningun cliente. Revisa que exista el archivo recursos/clientes.txt.");
        } else {
            StringBuilder mensaje = new StringBuilder("Se cargaron " + clientesDesdeArchivo.size() + " clientes:\n\n");
            for (Cliente cliente : clientesDesdeArchivo) {
                mensaje.append(cliente).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());

            // Se deja constancia por consola tambien, util para el video de presentacion
            System.out.println(mensaje);
        }
    }

    // Opcion: busca un cliente ya cargado, por nombre
    private void buscarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente a buscar:");

        if (nombre == null) {
            return; // el usuario cancelo el cuadro de dialogo
        }

        Cliente encontrado = gestorClientes.buscarPorNombre(nombre);

        if (encontrado != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + encontrado);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese nombre.");
        }
    }

    // Opcion: pregunta que tipo de entidad se quiere registrar y deriva al formulario correspondiente
    private void registrarEntidad() {
        String[] tipos = {"Guia turistico", "Operador de transporte", "Proveedor de alojamiento"};

        int tipo = JOptionPane.showOptionDialog(
                null,
                "Que tipo de entidad quieres registrar?",
                "Registrar entidad",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );

        switch (tipo) {
            case 0:
                registrarGuia();
                break;
            case 1:
                registrarOperador();
                break;
            case 2:
                registrarProveedor();
                break;
            default:
                // el usuario cerro el cuadro sin elegir un tipo
                break;
        }
    }

    private void registrarGuia() {
        String nombre = JOptionPane.showInputDialog("Nombre del guia:");
        String rutTexto = JOptionPane.showInputDialog("RUT (formato 12345678-9):");
        String correo = JOptionPane.showInputDialog("Correo:");
        String idiomas = JOptionPane.showInputDialog("Idiomas que maneja:");
        String experienciaTexto = JOptionPane.showInputDialog("Anios de experiencia:");

        // Tanto la creacion del Rut como el parseo del numero pueden fallar,
        // por eso se validan ambos con try-catch
        try {
            Rut rut = new Rut(rutTexto);
            int experiencia = Integer.parseInt(experienciaTexto);
            GuiaTuristico guia = new GuiaTuristico(nombre, rut, correo, idiomas, experiencia);
            gestorRegistrables.agregar(guia);
            JOptionPane.showMessageDialog(null, "Guia registrado correctamente.");
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(null, "No se registro el guia: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los anios de experiencia deben ser un numero.");
        }
    }

    private void registrarOperador() {
        String nombre = JOptionPane.showInputDialog("Nombre o razon social del operador:");
        String rutTexto = JOptionPane.showInputDialog("RUT (formato 12345678-9):");
        String correo = JOptionPane.showInputDialog("Correo:");
        String patente = JOptionPane.showInputDialog("Patente del vehiculo:");
        String capacidadTexto = JOptionPane.showInputDialog("Capacidad de pasajeros:");

        try {
            Rut rut = new Rut(rutTexto);
            int capacidad = Integer.parseInt(capacidadTexto);
            OperadorTransporte operador = new OperadorTransporte(nombre, rut, correo, patente, capacidad);
            gestorRegistrables.agregar(operador);
            JOptionPane.showMessageDialog(null, "Operador de transporte registrado correctamente.");
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(null, "No se registro el operador: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La capacidad de pasajeros debe ser un numero.");
        }
    }

    private void registrarProveedor() {
        String nombre = JOptionPane.showInputDialog("Nombre del proveedor:");
        String rutTexto = JOptionPane.showInputDialog("RUT (formato 12345678-9):");
        String correo = JOptionPane.showInputDialog("Correo:");
        String calle = JOptionPane.showInputDialog("Calle:");
        String comuna = JOptionPane.showInputDialog("Comuna:");
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        String tipoAlojamiento = JOptionPane.showInputDialog("Tipo de alojamiento (hostal, cabañas, hotel, etc):");

        try {
            Rut rut = new Rut(rutTexto);
            // La direccion se arma primero y luego se "inyecta" en el proveedor (composicion)
            Direccion direccion = new Direccion(calle, comuna, ciudad);
            ProveedorAlojamiento proveedor = new ProveedorAlojamiento(nombre, rut, correo, direccion, tipoAlojamiento);
            gestorRegistrables.agregar(proveedor);
            JOptionPane.showMessageDialog(null, "Proveedor de alojamiento registrado correctamente.");
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(null, "No se registro el proveedor: " + e.getMessage());
        }
    }

    // Opcion: recorre la coleccion de Registrable y muestra el resumen de cada entidad,
    // diferenciando el tipo real con instanceof (igual que en la version por consola)
    private void verEntidades() {
        if (gestorRegistrables.getRegistrables().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aun no hay entidades registradas.");
            return;
        }

        StringBuilder mensaje = new StringBuilder();
        for (Registrable entidad : gestorRegistrables.getRegistrables()) {
            mensaje.append(entidad.mostrarDatos());

            if (entidad instanceof GuiaTuristico) {
                mensaje.append("\n   -> Tipo: Guia turistico\n");
            } else if (entidad instanceof OperadorTransporte) {
                mensaje.append("\n   -> Tipo: Operador de transporte\n");
            } else if (entidad instanceof ProveedorAlojamiento) {
                mensaje.append("\n   -> Tipo: Proveedor de alojamiento\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
        System.out.println(mensaje);
    }

    // Opcion: crea una reserva a partir de un cliente ya cargado y un paquete disponible
    private void crearReserva() {
        if (gestorClientes.getClientes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debes cargar al menos un cliente.");
            return;
        }

        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente que hace la reserva:");
        Cliente cliente = gestorClientes.buscarPorNombre(nombreCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese nombre.");
            return;
        }

        // Se arma la lista de nombres de paquetes para que el usuario elija uno como boton
        String[] nombresPaquetes = new String[paquetesDisponibles.size()];
        for (int i = 0; i < paquetesDisponibles.size(); i++) {
            nombresPaquetes[i] = paquetesDisponibles.get(i).getNombre();
        }

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Que paquete turistico desea reservar?",
                "Seleccionar paquete",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresPaquetes,
                nombresPaquetes[0]
        );

        if (seleccion == -1) {
            return; // el usuario cerro el cuadro sin elegir un paquete
        }

        PaqueteTuristico paquete = paquetesDisponibles.get(seleccion);
        String fecha = JOptionPane.showInputDialog("Fecha de la reserva (dd-mm-aaaa):");

        // Se usa el constructor sobrecargado de Reserva: al no indicar estado,
        // la reserva queda como "Pendiente" por defecto
        Reserva reserva = new Reserva(cliente, paquete, fecha);
        gestorReservas.agregarReserva(reserva);

        JOptionPane.showMessageDialog(null, "Reserva creada correctamente:\n" + reserva);
    }

    // Opcion: muestra todas las reservas, con la opcion de filtrarlas por estado
    private void verReservas() {
        if (gestorReservas.getReservas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aun no hay reservas registradas.");
            return;
        }

        int filtrar = JOptionPane.showConfirmDialog(
                null,
                "Quieres filtrar las reservas por estado?",
                "Ver reservas",
                JOptionPane.YES_NO_OPTION
        );

        ArrayList<Reserva> reservasAMostrar;

        if (filtrar == JOptionPane.YES_OPTION) {
            String estado = JOptionPane.showInputDialog("Ingrese el estado a filtrar (Pendiente, Confirmada, Cancelada):");
            reservasAMostrar = gestorReservas.filtrarPorEstado(estado);
        } else {
            reservasAMostrar = gestorReservas.getReservas();
        }

        if (reservasAMostrar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas que coincidan con ese estado.");
            return;
        }

        StringBuilder mensaje = new StringBuilder();
        for (Reserva reserva : reservasAMostrar) {
            mensaje.append(reserva).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
        System.out.println(mensaje);
    }
}
