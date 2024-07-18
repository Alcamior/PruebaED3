
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
    public Connection conexion = null;
    public Statement comando = null;
    public ResultSet registro;
    
    public Connection JavaToMySQL() throws Exception{
        try {
            // Instanciar librería del conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Datos de la conexión
            String servidor = "jdbc:mysql://localhost:3306/fruteria6A";
            String usuario = "root";
            String password = "";
            
            // Establecer conexión
            conexion = DriverManager.getConnection(servidor, usuario, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No se puedo encontrar la clase Conexion");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se puedo conectar a la base de datos");
        }catch(Exception es){
           JOptionPane.showMessageDialog(null,"Error con la informacion"); 
        }finally{
            return conexion; 
        }
        
    }
}
