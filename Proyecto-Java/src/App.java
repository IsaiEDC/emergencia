import java.sql.Date;
import java.util.List;

import db.repositorys.EmpleadosRepository;
import db.repositorys.GenerosRepository;
import db.repositorys.LoginRepository;
import models.Empleado;
import models.Genero;
import models.Login;
import screens.EmpleadosVentana;
import screens.LoginVentana;

public class App {
    public static void main(String[] args) throws Exception {
        //LoginRepository loginRepository = new LoginRepository();
        //Login l = new Login(null, "A6z", "a6z@test.com", "adminbluedeep", "batman");
        //loginRepository.agregar(l);
        //System.out.println("");
        //LoginVentana loginVentana = new LoginVentana("Iniciar sesión");
        //loginVentana.setVisible(true);
        EmpleadosVentana empleadosVentana = new EmpleadosVentana();
        empleadosVentana.setVisible(true);
    }
}