import java.util.ArrayList;
import java.util.List;

public class Cliente {

    // Propiedades
    private ArrayList<String> listaUsuarios = new ArrayList<>(List.of("Luis", "Ivan"));
    private ArrayList<String> listaContrasenyas = new ArrayList<>(List.of("1234", "1234"));
    private String nombreUsuario;
    private String contrasenyaUsuario;
    private boolean esUsuario;

    // Métodos

    //Método para obtener el nombre del usuario
    public String getUsuario() {
        return this.nombreUsuario;
    }

    // Método para insertar un nombre a la clase Usuario
    public void setUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Método para insertar una contrasñea a la clase Usuario
    public void setContrasenya(String contrasenyaUsuario) {
        this.contrasenyaUsuario = contrasenyaUsuario;
    }

    // Método para validar si el usuario es Usuario es cliente
    public boolean validarUsuario() {

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).equals(this.nombreUsuario)
                    && this.listaContrasenyas.get(i).equals(this.contrasenyaUsuario)) {
                this.esUsuario = true;
                return this.esUsuario;
            }
        }

        this.esUsuario = false;
        return this.esUsuario;
    }
}