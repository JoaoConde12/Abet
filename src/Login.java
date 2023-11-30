import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {

    // Componentes de la interfaz de usuario
    private JLabel labelUsuario;
    private JTextField campoUsuario;
    private JLabel labelContraseña;
    private JPasswordField campoContraseña;
    private JButton botonIngresar;

    // Propiedades del programa
    private Admin admin = new Admin();
    private Cliente cliente = new Cliente();
    private Producto inventario = new Producto();
    private Proveedor proveedor = new Proveedor();

    // Métodos

    // Constructor de la clase LoginMain
    public Login() {

        super("Login"); // Título de la ventana

        // Inicialización de la ventana y sus componentes
        initializeComponents();

        // Configuración de la ventana: tamaño, ubicación y cierre
        configuracionVentana();

        // Hacer la ventana visible
        setVisible(true);
    }

    // Método para inicializar los componentes de la interfaz de usuario
    private void initializeComponents() {

        // Creación de componentes
        labelUsuario = new JLabel("Usuario:");
        campoUsuario = new JTextField();
        labelContraseña = new JLabel("Contraseña:");
        campoContraseña = new JPasswordField();
        botonIngresar = new JButton("Ingresar");

        // Configuración del diseño de la ventana
        setLayout(null); // Desactiva el diseño predeterminado para posicionar manualmente los componentes

        // Posicionamiento y tamaño de los componentes en la ventana
        labelUsuario.setBounds(10, 20, 100, 20); // (x, y, ancho, alto)
        campoUsuario.setBounds(120, 20, 200, 20);
        labelContraseña.setBounds(10, 50, 100, 20);
        campoContraseña.setBounds(120, 50, 200, 20);
        botonIngresar.setBounds(180, 80, 100, 20);

        // Agregar componentes al contenedor principal (el JFrame)
        add(labelUsuario);
        add(campoUsuario);
        add(labelContraseña);
        add(campoContraseña);
        add(botonIngresar);

        // ActionListener para el botón "Ingresar"
        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarPrograma(); // Método para validar las credenciales al hacer clic en el botón
            }
        });
    }

    // Método para configurar propiedades de la ventana
    private void configuracionVentana() {
        setSize(350, 150);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
    }

    // Método para mostrar un cuadro de diálogo con un mensaje
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Método para pedir un input
    private int pedirInformacion(String mensaje, int limite) {

        int opcion = 0;
        String opcionStr = JOptionPane.showInputDialog(this, mensaje);

        // Se convierte la opción del usuario en un int
        try {

            opcion = Integer.parseInt(opcionStr);

            // Se verifica que la opción insertada esté dentro del rango esperado
            if (opcion > 0 && opcion <= limite) {
                return opcion;
            } else {
                JOptionPane.showMessageDialog(null, "Error, fuera de rango");
                return pedirInformacion(mensaje, limite);
            }
        
        // Ejecución en caso de que no se inserte un int
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, debes ingresar un número entero");
            return pedirInformacion(mensaje, limite);
        }
    }

    // Método para validar las credenciales ingresadas
    private void ejecutarPrograma() {

        // Pedir información para el login
        String usuario = campoUsuario.getText();
        String contrasenya = new String(campoContraseña.getPassword());

        // Pasar los datos a la clase Admin y Cliente
        this.admin.setUsuario(usuario);
        this.admin.setContrasenya(contrasenya);
        this.cliente.setUsuario(usuario);
        this.cliente.setContrasenya(contrasenya);

        // Opciones del usuario
        int opcionUsuario = 0;
        int opcionCliente = 0;

        // Valida si es los datos ingresados en el login, son de un Admin
        if (this.admin.validarUsuario() == true) {

            mostrarMensaje("Bienvenido " + admin.getUsuario());

            // Bucle de las opciones del programa
            do {

                // Varaibles del programa cuando lo ejecuta un admin
                String listaProductos;
                String listaProveedores = proveedor.getProveedores();

                // Se pide la opción al usuario y luego se la pasa al método de obtener productos
                opcionUsuario = pedirInformacion("Seleccione una opción:\n\n    1. Ver Proveedores\n    2. Ver Inventario\n    3. Comprar a un proveedor\n    4. Salir", 4);
                listaProductos = inventario.getProductos(opcionUsuario);

                switch (opcionUsuario) {

                    case 1: // Ver proveedores
                        mostrarMensaje(listaProveedores);
                        System.out.println(inventario.getProductosFarmacia());
                        break;

                    case 2: // Ver productos
                        mostrarMensaje(listaProductos);
                        break;

                    case 3: // Realizar compras a proveedores
                        proveedor.proovedores();
                        break;
                }
            } while (opcionUsuario != 4);
        }

        // Valida si es los datos ingresados en el login, son de un Cliente
        else if (this.cliente.validarUsuario() == true) {

            mostrarMensaje("Bienvenido " + cliente.getUsuario());

            // Bucle de las opciones del programa
            do {

                // Variables para el programa cuando se ejecuta la parte de cliente
                int cantidadProductos = inventario.getTamanyoListaProductos();
                String listaProductos;
                String sugerenciaUsuario;

                // Se pide la opción al usuario y luego se la pasa al método de obtener
                // productos
                opcionUsuario = pedirInformacion("Seleccione una opción:\n\n    1. Comprar Productos\n    2. Ver productos\n    3. Hacer una sugerencia\n    4. Salir", 4);
                listaProductos = inventario.getProductos(opcionUsuario);

                switch (opcionUsuario) {

                    case 1: // Realizar compras
                        opcionCliente = pedirInformacion(listaProductos, cantidadProductos);
                        String realizarCompra = inventario.restarCantidadProductos(opcionCliente);
                        mostrarMensaje(realizarCompra);
                        break;

                    case 2: // Ver productos
                        mostrarMensaje(listaProductos);
                        break;

                    case 3: // Hacer sugerencias
                        sugerenciaUsuario = JOptionPane.showInputDialog(null, "Haz tu sugerencia:");
                        mostrarMensaje("Tu sugerencia:\n\n\"" + sugerenciaUsuario + "\"\n\nHa sido enviada correctamente");
                        break;
                }
                // Salir del programa
            } while (opcionUsuario != 4);
        }
        // Valida si es los datos ingresados en el login, no son de nadie
        else {
            mostrarMensaje("SOLO LIGA!!!!");
        }
    }
}
