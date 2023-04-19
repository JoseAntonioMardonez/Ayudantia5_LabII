package model;

public class Usuario {
    //Atributos
    private String nombreUsuario;
    private String contrasena;

    //Constructor
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    //Métodos
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String toString(){
        return nombreUsuario+", "+contrasena;
    }
}
