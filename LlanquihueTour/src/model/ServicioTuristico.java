package model;

/**
 * Clase base (superclase) que representa un servicio turistico generico
 * ofrecido por la agencia Llanquihue Tour.
 *
 * Contiene los atributos y comportamientos que comparten todos los
 * servicios, sin importar su tipo especifico. Las subclases
 * (RutaGastronomica, PaseoLacustre, ExcursionCultural) heredan de esta
 * clase y agregan sus propios atributos.
 */
public class ServicioTuristico {

    // Atributos comunes a todo servicio turistico
    private String nombre;
    private int duracionHoras;

    // Constructor con los datos basicos del servicio
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    // Getters y setters (encapsulamiento de los atributos)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Metodo pensado para ser sobrescrito por cada subclase, de manera
     * que cada tipo de servicio pueda mostrar su propia informacion.
     * Aqui se deja una implementacion base por si alguna subclase no
     * la sobrescribe.
     */
    public String mostrarInformacion() {
        return "Servicio turistico: " + nombre + " (" + duracionHoras + " horas)";
    }

    // Se reutiliza mostrarInformacion() para no repetir el mismo texto dos veces
    @Override
    public String toString() {
        return mostrarInformacion();
    }
}
