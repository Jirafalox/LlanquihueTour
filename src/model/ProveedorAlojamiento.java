package model;

/**
 * Representa a un proveedor de alojamiento (hostal, cabañas, hotel, etc)
 * que trabaja con la agencia. Hereda de Persona e implementa Registrable.
 *
 * Se relaciona con la clase Direccion mediante composicion: cada
 * proveedor "contiene" una Direccion propia.
 */
public class ProveedorAlojamiento extends Persona implements Registrable {

    private Direccion direccion;
    private String tipoAlojamiento;

    public ProveedorAlojamiento(String nombre, Rut rut, String correo, Direccion direccion, String tipoAlojamiento) {
        super(nombre, rut, correo);
        this.direccion = direccion;
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando proveedor de alojamiento: " + getNombre());
    }

    @Override
    public String mostrarDatos() {
        return "Proveedor de alojamiento: " + getNombre() + " | Tipo: " + tipoAlojamiento
                + " | Direccion: " + direccion;
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}
