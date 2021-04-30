package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/* Clase para la creación del origen de datos de la conexión con la BBDD. */
public class Conexion {

    // Se declara la constante con la cadena de conexión a la BBDD
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // Usuario y password
    private static final String JDBC_USER = "dbuser";
    private static final String JDBC_PASSWORD = "AliNata0";
    
    // Método para crear la conexión
    public static DataSource getDataSource(){
        //Se crea la conexión
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        /* Conexiones concurrentes del pool de conexiones. Este es el pool 
        gestionado por la aplicación. La buena práctica sería que el pool
        sea controlado por el servidor, para aplicaciones más complejas.
        Esta parte corresponde al curso de JavaEE. */
        ds.setInitialSize(50);
        
        return ds;
    }
    
    /* Clase para la creación de la conexión con la BBDD. */
    public static Connection getConnection() throws SQLException {
        
        // Se crea y devuelve la conexión desde la invocación al método de creación del data source
        return getDataSource().getConnection();
    }
    
    /* En los métodos siguientes se gestiona el posible error en el método, en
    * lugar de indicar un "throws" en la firma del método, para que no deba
    * controlarse al llamar desde la clase DAO. Pero esto es opcional. */

    /* Método para cerrar un objeto "ResultSet". */
    public static void close(ResultSet rs)  {
        try{
            rs.close();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    /* Método para cerrar un objeto "Statement". */
    public static void close(Statement stm) {
        try{
            stm.close();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    /* Método para cerrar un objeto "PreparedStatement". */
    public static void close(PreparedStatement pstm) {
        try{
            pstm.close();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    /* Método para cerrar un objeto "Connection". */
    public static void close(Connection conn) {
        try{
            conn.close();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }
    
}
