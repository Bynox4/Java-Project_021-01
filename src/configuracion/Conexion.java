package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Propiedades;

public abstract class Conexion {
    
    private String usuario;
    private String clave;
    private String url;
    private String driver;
    protected Connection objConexion;

    public Conexion() {
        String nombreArchivoBD = "variablesBD";
        
        usuario = Propiedades.leer(nombreArchivoBD, "nombre_usuario".replace("\"", ""));
        clave = Propiedades.leer(nombreArchivoBD, "clave_usuario".replace("\"", ""));
        url = Propiedades.leer(nombreArchivoBD, "url_usuario".replace("\"", ""));
        driver = Propiedades.leer(nombreArchivoBD, "driver".replace("\"", ""));
        
        activar();
    }
    
    private void activar(){
        try{
            Class.forName(driver);
            objConexion = DriverManager.getConnection(url, usuario, clave);
            
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }
}
