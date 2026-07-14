package model;

/**
 * Subclase que representa una ruta gastronomica.
 * Hereda de ServicioTuristico y agrega el atributo numeroDeParadas.
 */
public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        // super(...) reutiliza el constructor de la superclase
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    // Se sobrescribe el metodo de la superclase para agregar el dato propio de esta subclase
    @Override
    public String mostrarInformacion() {
        return "Ruta gastronomica: " + getNombre() + " (" + getDuracionHoras()
                + " horas) - Numero de paradas: " + numeroDeParadas;
    }
}
