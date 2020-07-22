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

import cl.edutecno.Album;
import cl.edutecno.Foto;


public class ConexionFotos {
	
	public static List<Foto> conexionFotos() {// método que se conecta a la ruta y devuelve array con todas las fotos
				
		List<Foto> listaFotos = new ArrayList<Foto>();
		Client client = ClientBuilder.newClient(); // instancia de cliente 
	    WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("photos"); // ruta que consultaremos 
	    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); //petición HTTP: generador de invocador de instancias
	    
	    Response respuestaFotos = invocationBuilder.get(); // consumir la api con método get
	   
	    try {
	    	listaFotos = respuestaFotos.readEntity(new GenericType<List<Foto>>(){}); //Leer la respuesta y asignarla a una propiedad con método readEntity
	        //System.out.println(listaFotos.toString());
	    }// fin try
	    catch (Exception e) { //muestra un posible error de captura de datos desde la api
	    	System.out.println("Excepcion leyendo: "+ respuestaFotos + ": " + e +
	    						"\nStatus: "+respuestaFotos.getStatus() +//status 200: OK, 401: Unauthorized, 403: Forbidden, 404: Not Found, 500: Server error
	    						"\nRespuesta: " +respuestaFotos.toString());// imprime la respuesta desde la api
	    } // fin catch
	    return listaFotos;
	}//fin metodo

}// cierre class ConexionFotos
