package datos;

import dominio.ClienteDTO;
import datos.Conexion;
import java.sql.*;
;
import java.util.*;

/* La buena práctica es crear una interfaz para la gestión del modelo de datos y
luego crear una clase que ejecute realmente las gestiones. */


public class ClienteDAOJDBC implements ClienteDAO {

    private static final String SQL_SELECT_ALL = "SELECT ID_CLIENTE,NOMBRE,APELLIDO,EMAIL,TELEFONO,SALDO FROM CONTROL_CLIENTES.CLIENTE";
    private static final String SQL_SELECT_BY_ID = "SELECT ID_CLIENTE,NOMBRE,APELLIDO,EMAIL,TELEFONO,SALDO FROM CONTROL_CLIENTES.CLIENTE WHERE ID_CLIENTE = ?";
    private static final String SQL_INSERT = "INSERT INTO CONTROL_CLIENTES.CLIENTE (NOMBRE, APELLIDO, EMAIL, TELEFONO, SALDO) VALUES(?, ? , ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE CONTROL_CLIENTES.CLIENTE SET NOMBRE = ?, APELLIDO = ?, EMAIL = ?, TELEFONO = ?, SALDO = ? WHERE ID_CLIENTE = ?";
    private static final String SQL_DELETE = "DELETE FROM CONTROL_CLIENTES.CLIENTE WHERE ID_CLIENTE = ?";

    @Override
    public List<ClienteDTO> listar() {

        /* Es buena práctica crear todas las variables que serán requeridas durante
        * la instrucción. */
        List<ClienteDTO> clientes = new ArrayList<>();
        ClienteDTO cliente = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT_ALL);
            rs = pstm.executeQuery();
            /* En este caso al ser un SELECT, iteramos los resultados y los incluimos en un
            * ArrayList del tipo de la clase DAO. */
            while (rs.next()) {
                cliente = new ClienteDTO(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"), rs.getDouble("saldo"));
                clientes.add(cliente);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return clientes;
    }

    @Override
    public ClienteDTO encontrar(int id) {

        ClienteDTO cliente = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            /* En este caso no es necesario iterar el array porque sabemos que solo devolverá un registro o ninguno.
            Con el método "absolute(indice)" se posiciona el cursor en un registro recuperado. En el caso de usar
            el método "next()" para recorrer un "ResultSet", internamente se va posicionando cada vez en el siguiente
            registro, pero si no iteramos, es necesario hacerlo de forma manual. */
            rs.next();
            cliente = new ClienteDTO(id, rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"), rs.getDouble("saldo"));

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return cliente;
    }

    @Override
    public int insertar(ClienteDTO cliente) {

        Connection conn = null;
        PreparedStatement pstm = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);
            /* Se setea cada uno de los parámetros del objeto PreparedStatement. */
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefono());
            pstm.setDouble(5, cliente.getSaldo());

            registros = pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return registros;
    }

    @Override
    public int actualizar(ClienteDTO cliente) {

        Connection conn = null;
        PreparedStatement pstm = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);
            /* Se setea cada uno de los parámetros del objeto PreparedStatement,
            en el orden adecuado según lo definido en la sentencia SQL. */
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefono());
            pstm.setDouble(5, cliente.getSaldo());
            pstm.setInt(6, cliente.getIdCliente());

            registros = pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return registros;
    }

    @Override
    public int eliminar(ClienteDTO cliente) {

        Connection conn = null;
        PreparedStatement pstm = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);
            /* En una instrucción SQL a la que sea necesario informar parámetros,
             * debemos usar los métodos "set" según el tipo de dato */
            pstm.setInt(1, cliente.getIdCliente());

            registros = pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }

        return registros;
    }

}
