package principal;

import model.*;
import vista.*;

public class Launcher {
    public static void  main(String Args[]){
        inicializar();

    }
    public static void inicializar(){
        Login login = new Login();
        new VentanaLogin(login);


    }
}
