import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Producto {

    // Propiedades
    private ArrayList<String> productosFarmacia = new ArrayList<>(
            List.of("Nortriptilina", "Diciclomina", "Desipramina", "Ibuprofeno", "Diclofenaco"));
    private ArrayList<Double> preciosProductos = new ArrayList<>(List.of(1.5, 2.5, 4.6, 2.2, 0.85));
    private ArrayList<Integer> cantidadProductos = new ArrayList<>(List.of(2, 3, 5, 10, 4));

    // Métodos

    public List<String> getProductosFarmacia() {
        return this.productosFarmacia;
    }

    public List<Double> getPreciosProductos() {
        return this.preciosProductos;
    }

    public List<Integer> getCantidadProductos() {
        return this.cantidadProductos;
    }

    // Método para saber la cantidad de productos
    public int getTamanyoListaProductos() {
        return this.productosFarmacia.size();
    }

    // Método para mostrar productos
    public String getProductos(int opcion) {
        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < this.productosFarmacia.size(); i++) {
            mensaje.append(i + 1).append(". ").append(this.productosFarmacia.get(i))
                    .append(" -- Precio: $").append(this.preciosProductos.get(i))
                    .append(" -- Cantidad: ").append(this.cantidadProductos.get(i));

            if (opcion == 1 && i == this.productosFarmacia.size() - 1) {
                mensaje.append("\n\nInserta el número del producto que deseas comprar:");
            } else if (i < this.productosFarmacia.size() - 1) {
                mensaje.append("\n\n");
            }

            // if (opcion == 1) {
            //     mensaje.append("Inserta el número del producto que deseas comprar:");
            // } else {
            //     mensaje.append("\n\n");
            // }
        }

        return mensaje.toString();
    }

    // Método para restar la cantidad de productos que el cliente escogió
    public String restarCantidadProductos(int opcion) {

        String mensajeCompraRealizada = "Compra realizada exitosamente";
        String cantidadStr;
        int cantidad = 0;

        for (int i = 0; i < this.productosFarmacia.size(); i++) {

            if (i == (opcion - 1)) {

                Boolean hayProductos = this.cantidadProductos.get(i) > 0 ? true: false;

                if (hayProductos) {

                    cantidadStr = JOptionPane.showInputDialog("Inserta la cantidad de productos que deseas comprar");

                    try {

                        cantidad = Integer.parseInt(cantidadStr);

                        if (cantidad > 0 && cantidad <= this.cantidadProductos.get(i)) {
                            this.cantidadProductos.set(i, this.cantidadProductos.get(i) - cantidad);
                            return mensajeCompraRealizada;
                        } else {
                            return "Error, no hay la cantidad de productos suficiente";
                        }

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Error, debes ingresar un número entero");
                        return restarCantidadProductos(opcion);
                        
                    }
                } else {

                    return "No hay productos";

                }
            }
        }

        return "Error desconocido";
    }

    // Método para añadir un nuevo producto
    public void agregarNuevoProducto(String nombre, double precio, int cantidad) {
        productosFarmacia.add(nombre);
        preciosProductos.add(precio);
        cantidadProductos.add(cantidad);
    }

    // Método para añadir un nuevo precio
    public void agregarNuevoPrecio(double precio) {
        preciosProductos.add(precio);
    }

    // Método para añadir una cantidad
    public void agregarNuevaCantidad(int cantidad) {
        cantidadProductos.add(cantidad);
    }
}
