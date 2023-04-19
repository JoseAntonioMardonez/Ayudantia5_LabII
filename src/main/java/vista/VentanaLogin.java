package vista;

import data.GestorArchivos;
import model.Login;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaLogin extends Ventana{
    private JLabel textoMenu;
    private JLabel textoUsuario;
    private JLabel textoContrasena;
    private JTextField entradaTextoUsuario;
    private JPasswordField entradaTextoContrasena;
    private JButton botonIngresar;
    private JButton botonSalida;
    private Login login;

    public VentanaLogin(Login login) {
        super("Login",500,500);
        this.login = login;
        generarElementosVentana();
    }

    private void generarElementosVentana(){
        generarMensajeMenu();
        generarTextoUsuario();
        generarEntradaDeTextoNombre();
        generarTextoContrasena();
        generarEntradaDeTextoContrasena();
        generarBotonIngresar();
        generarBotonSalir();
    }
    private void generarMensajeMenu() {
        String textoBienvenida = "Login";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 150, 30, 500, 30);
    }
    private void generarTextoUsuario() {
        String textoUsuario = "Usuario:";
        super.generarJLabel(this.textoUsuario, textoUsuario, 150, 90, 500, 30);
    }
    private void generarEntradaDeTextoNombre() {

        this.entradaTextoUsuario = super.generarJTextField(150,120,200,20);
        this.add(this.entradaTextoUsuario);
        this.entradaTextoUsuario.addActionListener(this);

    }
    private void generarTextoContrasena() {
        String textoContrasena = "Contraseña:";
        super.generarJLabel(this.textoContrasena, textoContrasena, 150, 160, 500, 30);
    }
    private void generarEntradaDeTextoContrasena() {

        this.entradaTextoContrasena = super.generarJPaswordField(150,190,200,20);
        this.add(this.entradaTextoContrasena);
        this.entradaTextoContrasena.addActionListener(this);

    }

    private void generarBotonIngresar() {
        String textoBoton = "Ingresar";
        this.botonIngresar = super.generarBoton(textoBoton, 175, 240, 150, 40);
        this.add(this.botonIngresar);
        this.botonIngresar.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 380, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonIngresar) {
            String nombreUsuario = entradaTextoUsuario.getText();
            char[] contrasena = entradaTextoContrasena.getPassword();
            boolean comprobarUsuario = login.comprobarUsuario(nombreUsuario,contrasena);
            if(comprobarUsuario == true){
                Usuario usuario = login.getUsuario(nombreUsuario,contrasena);
                JOptionPane.showMessageDialog(this,"Bienvenido "+nombreUsuario,"Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Usuario o Contraseña Incorrecta","Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
            }
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonSalida){
            GestorArchivos.registrarDatos(login.getUsuarios(),"C:\\Users\\josem\\IdeaProjects\\Ayudantia5_LabII\\src\\main\\java\\data\\Usuarios");
            this.dispose();
            System.exit(0);
        }
    }


}
