package model;

/**
 * Interfaz que establece un contrato comun de comportamiento para las
 * distintas entidades del sistema que deben poder registrarse y
 * mostrar un resumen de si mismas (guias, vehiculos, colaboradores externos).
 *
 * Al ser una interfaz, no contiene logica, solo declara el metodo que
 * toda clase que la implemente esta obligada a definir.
 */
public interface Registrable {

    // Cada clase que implemente esta interfaz debe entregar su propia
    // version de este metodo, con el mensaje que corresponda segun su tipo
    String mostrarResumen();
}
