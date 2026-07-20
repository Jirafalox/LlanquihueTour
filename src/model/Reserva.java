package model;

/**
 * Representa la reserva de un paquete turistico realizada por un
 * cliente. Se relaciona mediante composicion con las clases Cliente
 * y PaqueteTuristico: una Reserva "contiene" a ambos objetos.
 */
public class Reserva {

    private Cliente cliente;
    private PaqueteTuristico paquete;
    private String fecha;
    private String estado; // por ejemplo: "Pendiente", "Confirmada", "Cancelada"

    // Constructor completo, recibe todos los datos incluyendo el estado
    public Reserva(Cliente cliente, PaqueteTuristico paquete, String fecha, String estado) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Constructor sobrecargado: si no se indica un estado, la reserva
    // se crea como "Pendiente" por defecto (sobrecarga de constructores)
    public Reserva(Cliente cliente, PaqueteTuristico paquete, String fecha) {
        this(cliente, paquete, fecha, "Pendiente");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva [" + fecha + "] - Cliente: " + cliente.getNombre()
                + " - Paquete: " + paquete.getNombre() + " - Estado: " + estado;
    }
}
