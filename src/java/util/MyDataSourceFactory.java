/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;


public class MyDataSourceFactory {

	public static DataSource getMySQLDataSource() {
		//Properties props = new Properties();
		//FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			/*fis = new FileInputStream("db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
*/
                        mysqlDS = new MysqlDataSource();
			mysqlDS.setURL("jdbc:mysql://localhost:3306/prueba1");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}	
		
}