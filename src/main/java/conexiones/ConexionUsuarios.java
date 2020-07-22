package conexiones;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.edutecno.Foto;
import cl.edutecno.Usuario;

public class ConexionUsuarios {

	public static List<Usuario> conexionUsuarios() { // método que se conecta a la ruta y devuelve array con todos los usuarios
	
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		Client client = ClientBuilder.newClient(); // instancia de cliente 
        WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("users"); // ruta que consultaremos 
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); //petición HTTP: generador de invocador de instancias
        
        Response respuestaUsuarios = invocationBuilder.get();// consumir la api con método get
        
        //Leer la respuesta y asignarla a una propiedad con método readEntity
        try {
        	listaUsuarios = respuestaUsuarios.readEntity(new GenericType<List<Usuario>>(){});
            //System.out.println(listaUsuarios.toString());
        }// fin try
        catch (Exception e) { //muestra un posible error de captura de datos desde la api
        	System.out.println("Excepcion leyendo: "+ respuestaUsuarios + ": " + e +
        						"\nStatus: "+respuestaUsuarios.getStatus() +//status 200: OK, 401: Unauthorized, 403: Forbidden, 404: Not Found, 500: Server error
        						"\nRespuesta: " +respuestaUsuarios.toString());// imprime la respuesta desde la api
        } // fin catch
        return listaUsuarios;
	}// cierre conexionUsuarios 
	
}//cierre class ConexionUsuarios
