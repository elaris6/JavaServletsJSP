package datos;
import dominio.ClienteDTO;
import java.util.List;

/* Como buena práctica, se crea una interfaz previa a la clase que hará
realmente las gestiones de los datos, para independizarlas de si es contra BBDD,
contra un servicio, fichero... */
public interface ClienteDAO {
    
    public List<ClienteDTO> listar();
    
    public ClienteDTO encontrar(int id);
    
    public int insertar(ClienteDTO cliente);
    
    public int actualizar(ClienteDTO cliente);
    
    public int eliminar(ClienteDTO cliente);
    
}
