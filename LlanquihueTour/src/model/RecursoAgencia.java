package model;

/**
 * Clase base para los recursos que la agencia utiliza en su operacion
 * diaria: guias turisticos, vehiculos y colaboradores externos.
 *
 * Agrupa los datos que comparten todos estos recursos (nombre e
 * identificador). Las subclases agregan atributos propios segun su
 * naturaleza y ademas implementan la interfaz Registrable.
 */
public class RecursoAgencia {

    private String nombre;
    private String identificador; // segun el recurso puede ser un rut, codigo o patente

    public RecursoAgencia(String nombre, String identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return nombre + " (" + identificador + ")";
    }
}
