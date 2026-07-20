package model;

/**
 * Excepcion personalizada que se lanza cuando un RUT no cumple con el
 * formato esperado. Al extender de Exception, es una excepcion
 * verificada (checked), por lo que el codigo que crea un Rut debe
 * manejarla explicitamente con try-catch o propagarla con throws.
 */
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
