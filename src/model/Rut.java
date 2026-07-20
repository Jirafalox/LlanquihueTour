package model;

/**
 * Representa un RUT chileno dentro del sistema. Se encarga de guardar
 * el valor y validar que tenga un formato basico correcto al momento
 * de crearlo.
 *
 * Nota: la validacion aqui es basica (formato numeros-digito verificador),
 * no se implementa el calculo real del digito verificador, ya que no
 * fue parte de lo solicitado en la actividad.
 */
public class Rut {

    private String valor;

    public Rut(String valor) throws RutInvalidoException {
        if (!esValido(valor)) {
            throw new RutInvalidoException("El RUT ingresado no tiene un formato valido: " + valor);
        }
        this.valor = valor;
    }

    // Verifica que el RUT tenga el formato NNNNNNNN-D (7 u 8 numeros, guion y digito verificador)
    private boolean esValido(String valor) {
        if (valor == null) {
            return false;
        }
        return valor.matches("\\d{7,8}-[0-9kK]");
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) throws RutInvalidoException {
        if (!esValido(valor)) {
            throw new RutInvalidoException("El RUT ingresado no tiene un formato valido: " + valor);
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
