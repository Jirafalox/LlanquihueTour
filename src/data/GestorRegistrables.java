package data;

import model.Registrable;
import model.GuiaTuristico;
import model.OperadorTransporte;
import model.ProveedorAlojamiento;

import java.util.ArrayList;

/**
 * Clase encargada de administrar la coleccion de entidades registrables
 * del sistema (guias turisticos, operadores de transporte y proveedores
 * de alojamiento).
 *
 * Se utiliza una lista polimorfica List<Registrable>, y se recorre
 * aplicando instanceof para diferenciar el comportamiento segun el
 * tipo real de cada objeto.
 */
public class GestorRegistrables {

    private ArrayList<Registrable> registrables;

    public GestorRegistrables() {
        registrables = new ArrayList<>();
    }

    // Agrega una nueva entidad y la registra de inmediato
    public void agregar(Registrable entidad) {
        registrables.add(entidad);
        entidad.registrar();
    }

    // Recorre la coleccion mostrando los datos de cada entidad y
    // agregando una linea adicional segun el tipo real detectado
    public void mostrarTodos() {
        for (Registrable entidad : registrables) {
            System.out.println(entidad.mostrarDatos());

            if (entidad instanceof GuiaTuristico) {
                System.out.println("   -> Tipo: Guia turistico");
            } else if (entidad instanceof OperadorTransporte) {
                System.out.println("   -> Tipo: Operador de transporte");
            } else if (entidad instanceof ProveedorAlojamiento) {
                System.out.println("   -> Tipo: Proveedor de alojamiento");
            }
        }
    }

    // Filtra y retorna solo los guias turisticos de la coleccion, usando instanceof
    public ArrayList<GuiaTuristico> filtrarGuias() {
        ArrayList<GuiaTuristico> guias = new ArrayList<>();
        for (Registrable entidad : registrables) {
            if (entidad instanceof GuiaTuristico) {
                guias.add((GuiaTuristico) entidad);
            }
        }
        return guias;
    }

    public ArrayList<Registrable> getRegistrables() {
        return registrables;
    }
}
