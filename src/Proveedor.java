import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    // Propiedades
    private List<String> nombreProveedores = new ArrayList<>(List.of("MultiPharms", "DrugsWorld", "Umbrella"));
    private List<String> tipoDeFarmacos = new ArrayList<>(
            List.of("antidepresivos", "anticolinergicos", "antiinflamatorios"));
    private List<String> productosMultiPharms = new ArrayList<>(
            List.of("Nortriptilina", "Amoxapina", "Desipramina", "Amitriptilina"));
    private List<String> productosDrugsWorld = new ArrayList<>(
            List.of("Diciclomina", "Flavoxato", "Ipratropio", "Oxibutinina"));
    private List<String> productosUmbrella = new ArrayList<>(
            List.of("Aspirina", "Diclofenaco", "Ibuprofeno", "Flurbiprofeno"));

    // Métodos

    // Método para obtener proveedores en forma de String
    public String getProveedores() {

        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < this.nombreProveedores.size(); i++) {

            mensaje.append(i + 1).append(". ").append(this.nombreProveedores.get(i));

            if (i < this.nombreProveedores.size() - 1) {
                mensaje.append("\n");
            }
        }

        return mensaje.toString();
    }

    // Método para obtener proveedores en forma de List
    public List<String> getNombreProveedores() {
        return nombreProveedores;
    }

    // Método para obtener el tipo de Farmacos de los Proveedores
    public List<String> getTipoDeFarmacos() {
        return tipoDeFarmacos;
    }

    // Método para obtener los productos de MultiPharms
    public List<String> getProductosMultiPharms() {
        return productosMultiPharms;
    }

    // Método para obtener los productos de DrugsWorld
    public List<String> getProductosDrugsWorld() {
        return productosDrugsWorld;
    }

    // Método para obtener los productos de Umbrella
    public List<String> getProductosUmbrella() {
        return productosUmbrella;
    }

    // Método para elegir al proveedor
    public int elegirProveedor() {
        int i = 1;

        StringBuilder msj = new StringBuilder("Sistema de Proveedores\nEscoja al proveedor (coloque el numero asignado):\n");

        try {
            for (String nombres : getNombreProveedores()) {
                msj.append(i++).append(". ").append(nombres).append("\n");
            }

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, msj.toString()));

            // Verificar si la opción está dentro del rango válido
            if (opcion < 1 || opcion > getNombreProveedores().size()) {
                JOptionPane.showMessageDialog(null, "Error, opción fuera de rango");
                return -1; // Opción inválida, salimos del método
            }

            return opcion;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debes ingresar un número entero");
            return -1; // Llamada recursiva en caso de error
        }
    }

    // Método para escoger los productos del proveedor seleccionado
    public int escogerProductos(List<String> farmacos, int opcs) {
        int i = 1;

        StringBuilder msj = new StringBuilder("Escoja un producto (coloque el numero asignado):\n");

        try {
            for (String producto : farmacos) {
                msj.append(i++).append(". ").append(producto).append("\n");
            }

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, msj.toString()));

            // Verificar si la opción está dentro del rango válido
            if (opcion < 1 || opcion > farmacos.size()) {
                JOptionPane.showMessageDialog(null, "Error, opción fuera de rango");
                return -1; // Opción inválida, salimos del método
            }

            return opcion;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debes ingresar un número entero");
            return -1; // Llamada recursiva en caso de error
        }
    }

    // Método para solicitar del productos que se escogió
    public String solicitud(int opc) {
        List<String> farmacos;

        switch (opc) {
            case 1:
                farmacos = getProductosMultiPharms();
                break;

            case 2:
                farmacos = getProductosDrugsWorld();
                break;

            case 3:
                farmacos = getProductosUmbrella();
                break;

            default:
                return null; // Retorna null si la opción no es válida
        }

        try {
            int opcionProducto = escogerProductos(farmacos, opc - 1);

            if (opcionProducto >= 1 && opcionProducto <= farmacos.size()) {
                String msj = "Su solicitud de un paquete del producto '" + farmacos.get(opcionProducto - 1) + "', fue realizada con éxito.\n\nDebe esperar 24 horas para que sea procesada y aprobada";
                JOptionPane.showMessageDialog(null, msj);
                return farmacos.get(opcionProducto - 1);

            } else {
                return null; // Retorna null si la opción de producto no es válida
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debes ingresar un número entero");
            return solicitud(opc); // Llamada recursiva en caso de error
        }
    }

    // Ejecuta todo el código
    public void proovedores() {
        int opc = elegirProveedor();
        solicitud(opc);
    }
}