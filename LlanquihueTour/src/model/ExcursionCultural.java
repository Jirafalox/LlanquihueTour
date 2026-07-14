package model;

/**
 * Subclase que representa una excursion cultural.
 * Hereda de ServicioTuristico y agrega el atributo lugarHistorico.
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String mostrarInformacion() {
        return "Excursion cultural: " + getNombre() + " (" + getDuracionHoras()
                + " horas) - Lugar: " + lugarHistorico;
    }
}
