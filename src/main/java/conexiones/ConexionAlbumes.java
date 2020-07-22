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

public class ConexionAlbumes {
	
	public static List<Album> conexionAlbumes() {// método que se conecta a la ruta y devuelve array con todos los albumes
		
		List<Album> listaAlbumes = new ArrayList<Album>();
		
		Client client = ClientBuilder.newClient(); // instancia de cliente 
	    WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums"); // ruta que consultaremos 
	    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); //petición HTTP: generador de invocador de instancias
	    
	    Response respuestaAlbumes = invocationBuilder.get(); // consumir la api con método get
	   
	    try {
	    	listaAlbumes = respuestaAlbumes.readEntity(new GenericType<List<Album>>(){}); //Leer la respuesta y asignarla a una propiedad con método readEntity
	      //  System.out.println(listaAlbumes.toString());
	    }// fin try
	    catch (Exception e) { //muestra un posible error de captura de datos desde la api
	    	System.out.println("Excepcion leyendo: "+ respuestaAlbumes + ": " + e +
	    						"\nStatus: "+respuestaAlbumes.getStatus() +//status 200: OK, 401: Unauthorized, 403: Forbidden, 404: Not Found, 500: Server error
	    						"\nRespuesta: " +respuestaAlbumes.toString());// imprime la respuesta desde la api
	    	
	    } // fin catch
	    return listaAlbumes;    
	}//fin metodo

	public static Album conexionAlbumes(String extPath) {// método que se conecta a la ruta y devuelve array con todos los albumes
			
			Album albumById = new Album();
			
			Client client = ClientBuilder.newClient(); // instancia de cliente 
		    WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums").path(extPath); // ruta que consultaremos 
		    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); //petición HTTP: generador de invocador de instancias
		    
		    Response respuestaAlbumes = invocationBuilder.get(); // consumir la api con método get
		   
		    try {
		    	albumById = respuestaAlbumes.readEntity(new GenericType<Album>(){}); //Leer la respuesta y asignarla a una propiedad con método readEntity
		      //  System.out.println(listaAlbumes.toString());
		    }// fin try
		    catch (Exception e) { //muestra un posible error de captura de datos desde la api
		    	System.out.println("Excepcion leyendo: "+ respuestaAlbumes + ": " + e +
		    						"\nStatus: "+respuestaAlbumes.getStatus() +//status 200: OK, 401: Unauthorized, 403: Forbidden, 404: Not Found, 500: Server error
		    						"\nRespuesta: " +respuestaAlbumes.toString());// imprime la respuesta desde la api
		    	
		    } // fin catch
		    return albumById;    
		}//fin metodo
	
}// cierre class ConexionAlbumes
