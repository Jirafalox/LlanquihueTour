package model;

/**
 * Representa un vehiculo utilizado por la agencia para trasladar a los
 * turistas. Hereda de RecursoAgencia e implementa Registrable.
 */
public class Vehiculo extends RecursoAgencia implements Registrable {

    private int capacidadPasajeros;

    public Vehiculo(String nombre, String patente, int capacidadPasajeros) {
        // Se reutiliza el atributo identificador de la superclase como patente del vehiculo
        super(nombre, patente);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public String mostrarResumen() {
        return "Vehiculo: " + getNombre() + " | Patente: " + getIdentificador()
                + " | Capacidad: " + capacidadPasajeros + " pasajeros";
    }
}
