/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAOs;

/**
 *
 * @author sala8
 */
public abstract class DAOFactory {
    
    public static final int MySQL = 1;
    
    public abstract PersonaDAO getPersonaDAO();
    public abstract VehiculoDAO getVehiculoDAO();
    
public static DAOFactory getDAOFactory(int whichFactory) 
{
    switch (whichFactory) {
      case MySQL: 
          return new MySQLDbDAOFactory(); 
      default           : 
          return null;
    }
  }    

    public Object getVehiculoDAO(int whichFactory) {
       
      switch(whichFactory){
          case MySQL:
                  return new MySQLDbDAOFactory();
          default:
                  return null;
      }  
    }
}
