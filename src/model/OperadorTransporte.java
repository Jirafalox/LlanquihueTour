package model;

/**
 * Representa a un operador de transporte que trabaja con la agencia.
 * Hereda de Persona e implementa Registrable.
 */
public class OperadorTransporte extends Persona implements Registrable {

    private String patenteVehiculo;
    private int capacidadPasajeros;

    public OperadorTransporte(String nombre, Rut rut, String correo, String patenteVehiculo, int capacidadPasajeros) {
        super(nombre, rut, correo);
        this.patenteVehiculo = patenteVehiculo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando operador de transporte: " + getNombre());
    }

    @Override
    public String mostrarDatos() {
        return "Operador de transporte: " + getNombre() + " | Patente: " + patenteVehiculo
                + " | Capacidad: " + capacidadPasajeros + " pasajeros";
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}
