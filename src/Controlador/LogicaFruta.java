
package Controlador;

import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LogicaFruta {
    public DefaultCategoryDataset getDatos() throws Exception{
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        int i=1, total=0;
        String cate;
        
        String Query = "select categoria,count(*) as tot from fruta group by categoria";
        cone.comando = cone.conexion.createStatement();
        ResultSet rs = cone.comando.executeQuery(Query);
        
        while(rs.next()){
            cate = rs.getString("categoria");
            total = rs.getInt("tot");
            
            datos.setValue(total, "Categoria "+i, cate);
            i++;
        }
        
        return datos;
    }
}
