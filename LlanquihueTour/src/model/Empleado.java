package model;

public class Empleado extends Persona {

    private String cargo;
    private double sueldo;
    private Direccion direccion;

    public Empleado(String nombre, String apellido, String rut, String telefono,
                    String cargo, double sueldo, Direccion direccion) {
        super(nombre, apellido, rut, telefono);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rut='" + getRut() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", cargo='" + cargo + '\'' +
                ", sueldo=" + sueldo +
                ", direccion=" + direccion +
                '}';
    }
}
