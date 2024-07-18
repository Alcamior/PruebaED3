
package Controlador;

import java.sql.ResultSet;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class LogicaTrabajador {
    public DefaultCategoryDataset getDatos() throws Exception{
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        int i=1, total=0;
        String gen;
        
        String Query = "select Genero,count(*) as tot from trabajador group by Genero";
        cone.comando = cone.conexion.createStatement();
        ResultSet rs = cone.comando.executeQuery(Query);
        
        while(rs.next()){
            gen = rs.getString("Genero");
            total = rs.getInt("tot");
            
            datos.setValue(total, "Categoria "+i, gen);
            i++;
        }
        
        return datos;
    }
}
