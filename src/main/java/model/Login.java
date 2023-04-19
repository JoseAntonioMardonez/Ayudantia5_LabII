package model;

import java.util.ArrayList;

public class Login {
    //Atributos
    private ArrayList<Usuario> usuarios;

    //Constructor
    public Login() {
        this.usuarios = new ArrayList<Usuario>();
    }

    //Métodos
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    //Métodos para Ventanas
    public boolean comprobarUsuario(String nombreUsuario, char[] contrasena){
        String contrasena2 = new String(contrasena);
        for(Usuario usuario : this.usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena2)){
                return true;
            }
        }
        return false;
    }
    public Usuario getUsuario(String nombreUsuario, char[] contrasena){
        String contrasena2 = new String(contrasena);
        for(Usuario usuario : this.usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena2)){
                return usuario;
            }
        }
        return null;
    }

}
