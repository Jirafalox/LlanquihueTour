package model;

/**
 * Representa a un guia turistico de la agencia. Hereda de Persona
 * e implementa Registrable, ya que debe poder registrarse en el
 * sistema y mostrar sus datos.
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String idiomas;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, Rut rut, String correo, String idiomas, int aniosExperiencia) {
        super(nombre, rut, correo);
        this.idiomas = idiomas;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    // Se ejecuta al momento de incorporar al guia a la coleccion de entidades
    @Override
    public void registrar() {
        System.out.println("Registrando guia turistico: " + getNombre());
    }

    @Override
    public String mostrarDatos() {
        return "Guia turistico: " + getNombre() + " | Idiomas: " + idiomas
                + " | Experiencia: " + aniosExperiencia + " anios";
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}
