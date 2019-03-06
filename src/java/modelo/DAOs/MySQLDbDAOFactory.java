/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAOs;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sala8
 */
public class MySQLDbDAOFactory extends DAOFactory{
    public static final String DRIVER=
    "oracle.jdbc.OracleDriver";
  public static final String DBURL=
    "jdbc:oracle:thin:@[host]:[port]:[sid]";
 
  // method to create Cloudscape connections
  public static Connection createConnection() throws SQLException {
    MysqlDataSource mysqlDS = null;
    try {			
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL("jdbc:mysql://localhost:3306/prueba1");
            mysqlDS.setUser("root");
            mysqlDS.setPassword("root");
    } catch (Exception e) {
            e.printStackTrace();
    }
    return mysqlDS.getConnection();
  }
  public PersonaDAO getPersonaDAO() {
    // OracleDbCustomerDAO implements CustomerDAO
    return new PersonaMySQLDbDAO();
    
  } 
  public VehiculoDAO getVehiculoDAO(){
      return new VehiculoMySQLDbDAO();
  }
}
