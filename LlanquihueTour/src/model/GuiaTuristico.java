package model;

/**
 * Representa a un guia turistico de la agencia. Hereda los datos
 * generales de RecursoAgencia e implementa Registrable, ya que debe
 * poder mostrar un resumen de si mismo dentro del sistema.
 */
public class GuiaTuristico extends RecursoAgencia implements Registrable {

    private String idioma;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, String identificador, String idioma, int aniosExperiencia) {
        super(nombre, identificador);
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    // Implementacion personalizada del metodo declarado en la interfaz Registrable
    @Override
    public String mostrarResumen() {
        return "Guia turistico: " + getNombre() + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " anios";
    }
}
