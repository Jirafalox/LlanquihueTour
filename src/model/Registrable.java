package model;

/**
 * Interfaz que establece un contrato comun de comportamiento para las
 * entidades del sistema que deben poder registrarse y mostrar sus datos
 * (guias turisticos, operadores de transporte, proveedores de alojamiento).
 *
 * No contiene logica, solo declara los metodos que toda clase que la
 * implemente esta obligada a definir.
 */
public interface Registrable {

    // Se ejecuta cuando la entidad se incorpora al sistema
    void registrar();

    // Entrega un texto con los datos relevantes de la entidad
    String mostrarDatos();
}
