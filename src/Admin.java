import java.util.ArrayList;
import java.util.List;

public class Admin {

    // Propiedades
    private ArrayList<String> listaNombresAdmin = new ArrayList<>(List.of("Victor", "Josue"));
    private ArrayList<String> listaContrasenyasAdmin = new ArrayList<>(List.of("abc", "abc"));
    private String nombreAdmin;
    private String contrasenyaAdmin;
    private boolean esAdmin;

    // Métodos

    //Método para obtener el nombre del admin
    public String getUsuario() {
        return this.nombreAdmin;
    }

    // Método para insertar un nombre a la clase Admin
    public void setUsuario(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    // Método para insertar una contrasñea a la clase Admin
    public void setContrasenya(String contrasenyaAdmin) {
        this.contrasenyaAdmin = contrasenyaAdmin;
    }

    // Método para validar si el usuario es Administrador
    public boolean validarUsuario() {

        for (int i = 0; i < listaNombresAdmin.size(); i++) {
            if (this.listaNombresAdmin.get(i).equals(this.nombreAdmin)
                    && this.listaContrasenyasAdmin.get(i).equals(this.contrasenyaAdmin)) {
                this.esAdmin = true;
                return this.esAdmin;
            }
        }

        this.esAdmin = false;
        return this.esAdmin;
    }
}