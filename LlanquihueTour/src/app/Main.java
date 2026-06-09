package app;

import model.Direccion;
import model.Empleado;

public class Main {

    public static void main(String[] args) {

        // Crear objetos de tipo Direccion
        Direccion direccion1 = new Direccion("Calle Las Torres", "911", "Llanquihue", "Los Lagos");
        Direccion direccion2 = new Direccion("Av. Manuel Montt", "6767", "Puerto Montt", "Los Lagos");
        Direccion direccion3 = new Direccion("Pasaje Las Rosas", "777", "Llanquihue", "Los Lagos");

        // Crear objetos de tipo Empleado usando composición con Direccion
        Empleado empleado1 = new Empleado("Carlos", "Soto", "12.345.678-9", "+56912345678",
                "Guía Turístico", 850000, direccion1);

        Empleado empleado2 = new Empleado("María", "González", "14.567.890-1", "+56987654321",
                "Coordinadora de Tours", 980000, direccion2);

        Empleado empleado3 = new Empleado("Pedro", "Ramírez", "16.789.012-3", "+56911223344",
                "Chofer", 750000, direccion3);

        // Mostrar los objetos por consola usando toString()
        System.out.println("=== Sistema Llanquihue Tour ===");
        System.out.println();
        System.out.println(empleado1);
        System.out.println();
        System.out.println(empleado2);
        System.out.println();
        System.out.println(empleado3);
    }
}
