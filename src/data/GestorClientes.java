package data;

import model.Cliente;

import java.util.ArrayList;

/**
 * Clase encargada de administrar la coleccion de clientes del sistema.
 * Permite agregar, mostrar y buscar clientes.
 */
public class GestorClientes {

    private ArrayList<Cliente> clientes;

    public GestorClientes() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Recorre la coleccion e imprime cada cliente por consola
    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Busqueda simple por nombre (no distingue mayusculas de minusculas)
    public Cliente buscarPorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
