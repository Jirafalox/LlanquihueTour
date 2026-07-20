package model;

/**
 * Representa un paquete turistico que la agencia ofrece a sus clientes
 * (por ejemplo, un circuito de varios dias por la zona de los lagos).
 */
public class PaqueteTuristico {

    private String nombre;
    private String destino;
    private int duracionDias;
    private int precio;

    public PaqueteTuristico(String nombre, String destino, int duracionDias, int precio) {
        this.nombre = nombre;
        this.destino = destino;
        this.duracionDias = duracionDias;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " | Destino: " + destino + " | Duracion: " + duracionDias
                + " dias | Precio: $" + precio;
    }
}
