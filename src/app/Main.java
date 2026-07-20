package app;

/**
 * Clase principal del prototipo LlanquihueTourEFT.
 *
 * El programa se maneja de forma interactiva a traves de un menu
 * grafico simple (MenuInteractivo), construido con JOptionPane, que
 * permite cargar clientes, registrar entidades, crear reservas y
 * consultar las distintas colecciones del sistema.
 */
public class Main {

    public static void main(String[] args) {
        MenuInteractivo menu = new MenuInteractivo();
        menu.iniciar();
    }
}
