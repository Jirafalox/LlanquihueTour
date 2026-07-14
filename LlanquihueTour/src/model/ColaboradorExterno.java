package model;

/**
 * Representa a un colaborador externo de la agencia (por ejemplo, un
 * proveedor o socio de una empresa aliada). Hereda de RecursoAgencia
 * e implementa Registrable.
 */
public class ColaboradorExterno extends RecursoAgencia implements Registrable {

    private String empresa;
    private String servicioOfrecido;

    public ColaboradorExterno(String nombre, String identificador, String empresa, String servicioOfrecido) {
        super(nombre, identificador);
        this.empresa = empresa;
        this.servicioOfrecido = servicioOfrecido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getServicioOfrecido() {
        return servicioOfrecido;
    }

    public void setServicioOfrecido(String servicioOfrecido) {
        this.servicioOfrecido = servicioOfrecido;
    }

    @Override
    public String mostrarResumen() {
        return "Colaborador externo: " + getNombre() + " | Empresa: " + empresa
                + " | Servicio ofrecido: " + servicioOfrecido;
    }
}
