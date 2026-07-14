package model;

/**
 * Subclase que representa un paseo lacustre.
 * Hereda de ServicioTuristico y agrega el atributo tipoEmbarcacion.
 */
public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String mostrarInformacion() {
        return "Paseo lacustre: " + getNombre() + " (" + getDuracionHoras()
                + " horas) - Embarcacion: " + tipoEmbarcacion;
    }
}
