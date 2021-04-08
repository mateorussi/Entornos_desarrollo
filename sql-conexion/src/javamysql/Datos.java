package javamysql;
import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 * @author bm10DAM1
 *
 */
public class Datos {
   //variables
    private static Connection conexion;
    private static String bd="datos";
    private static String user="flotante";
    private static String password="flotante";
    private static String host="localhost";
    private static String server="jdbc:mysql://"+host+"/"+bd;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //conectar
    try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection(server,user,password);
		System.out.println("Conexion a base de datos "+server+" ... OK");
    } catch (ClassNotFoundException ex) {
      System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");
      //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
    System.out.println("Imposible realizar conexion con "+server+" ... FAIL");
    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    //realizar consulta
       try {
         // Preparamos la consulta
	            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from persona");

            // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            while (rs.next())
	            {
	                System.out.println(
	                        "ID: " +rs.getInt (1) +
	                        "  Nombre: " + rs.getString ("nombre")+
	                        "  Sexo: " + rs.getString("sexo")
	                        );
	            }
	        } catch (SQLException ex) {
	            System.out.println("Imposible realizar consulta ... FAIL");
	            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
	 
	        //desconectar
	        try {
	            conexion.close();
	            System.out.println("Cerrar conexion con "+server+" ... OK");
	        } catch (SQLException ex) {
	            System.out.println("Imposible cerrar conexion ... FAIL");
	            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	}
