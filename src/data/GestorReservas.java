package data;

import model.Reserva;

import java.util.ArrayList;

/**
 * Clase encargada de administrar la coleccion de reservas del sistema.
 * Permite agregar, mostrar y filtrar reservas segun su estado.
 */
public class GestorReservas {

    private ArrayList<Reserva> reservas;

    public GestorReservas() {
        reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void mostrarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    // Filtra las reservas segun su estado (por ejemplo, "Confirmada")
    public ArrayList<Reserva> filtrarPorEstado(String estado) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
