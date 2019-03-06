/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAOs;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelo.DTOs.VehiculoDTO;
/**
 *
 * @author sala1
 */
public class VehiculoMySQLDbDAO implements VehiculoDAO{
    
  
    public boolean insert(DataSource ds, VehiculoDTO v)
    {
        boolean rta = false;
        Connection con = null;
        Statement stmt = null;        
        try {
                con = ds.getConnection();
                stmt = con.createStatement();
                rta = stmt.execute("insert into vehiculo (placa,"
                        + "tipo,color,precio"
                        + " values ("+v.getPlaca()+", '"+v.getTipo()+"', '"+v.getColor()+"', '"+v.getPrecio()+"', ");
                
        } catch (SQLException e) {
                e.printStackTrace();
        }finally{
            try {
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        return rta;
    }

    public ArrayList consulta(DataSource ds, String placaV, String tipoV, String precioV)
    {
        ArrayList rta = new ArrayList();
        
        Statement s;
        try {
            
            s = ds.getConnection().createStatement();
            ResultSet rs = s.executeQuery ("select placa,tipo, "
                    + "color,precio," 
                    + " where placa = " + placaV);
            while (rs.next())
            {
                String aux = rs.getString("placa");
                aux += rs.getString("tipo");
                aux += rs.getString("color");
                aux += rs.getString("precio");
                
                rta.add(aux);
            }
            
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rta;
    }
    
}
