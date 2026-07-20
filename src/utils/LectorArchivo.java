package utils;

import model.Cliente;
import model.Rut;
import model.RutInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase utilitaria encargada de leer datos desde un archivo de texto
 * plano y convertirlos en objetos Cliente.
 *
 * Cada linea del archivo debe tener el siguiente formato, separado por
 * punto y coma:
 *   nombre;rut;correo;numeroDeReservas
 */
public class LectorArchivo {

    // Metodo estatico ya que no necesita guardar estado propio, solo
    // procesa el archivo y entrega la lista de clientes resultante
    public static ArrayList<Cliente> leerClientes(String rutaArchivo) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

                // Se espera que cada linea tenga exactamente 4 datos
                if (datos.length == 4) {
                    try {
                        Rut rut = new Rut(datos[1].trim());
                        int numeroReservas = Integer.parseInt(datos[3].trim());
                        Cliente cliente = new Cliente(datos[0].trim(), rut, datos[2].trim(), numeroReservas);
                        clientes.add(cliente);
                    } catch (RutInvalidoException e) {
                        System.out.println("Linea omitida por RUT invalido: " + linea);
                    } catch (NumberFormatException e) {
                        System.out.println("Linea omitida, numero de reservas invalido: " + linea);
                    }
                } else {
                    System.out.println("Linea omitida, formato incorrecto: " + linea);
                }
            }

        } catch (IOException e) {
            // Si el archivo no existe o no se puede leer, se informa por consola
            System.out.println("No se pudo leer el archivo de clientes: " + e.getMessage());
        }

        return clientes;
    }
}
