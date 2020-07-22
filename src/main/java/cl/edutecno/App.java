package cl.edutecno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import conexiones.ConexionAlbumes;
import conexiones.ConexionFotos;
import conexiones.ConexionUsuarios;

//CLASE MAIN:
public class App {
    
	public static void main( String[] args )    {
		//System.out.println( "Hello World!" );
		System.out.println("----------------------" );
		getUserEmail();
		System.out.println("----------------------" );
		getAlbumByUserId();
		System.out.println("----------------------" );
		getTitByStr();
		System.out.println("----------------------" );
   
    }//cierre método main
	
	public static void getUserEmail() {
		 List<Usuario> users= new ArrayList<Usuario>();
			users=ConexionUsuarios.conexionUsuarios();
			users.forEach(user->System.out.println(user.getName()+" - "+user.getEmail()) );
	}// cierre getUsuEmail
	
	public static void getAlbumByUserId() {
		List<Album> albumes= new ArrayList<Album>();
		albumes= ConexionAlbumes.conexionAlbumes();
		int idSolicitado = 5;
		albumes.stream().filter(al->al.getUserId()==idSolicitado)
		                 .forEach(alb->System.out.println(alb.getId()+" - "+ alb.getUserId() +" - "+ alb.getTitle()));
	}// cierre getAlbumByUserId
	
	public static void getAlbumById() {
		 List<Album> albumPorId= new ArrayList<Album>();
	        String extiendePath="77";
	        albumPorId.add(ConexionAlbumes.conexionAlbumes(extiendePath));
	        albumPorId.forEach(al->System.out.println(al.getUserId()+"\n"+al.getId()+"\n"+al.getTitle())); // albumes de la ruta que termina en 77  
	} // cierre getAlbumById
    
	public static void getTitByStr() {
		List<Foto> fotos= new ArrayList<Foto>();
		fotos= ConexionFotos.conexionFotos();
		String cadenaBuscada = "ipsam do";
		System.out.println("Títulos: ");
		fotos.stream().filter(fto->fto.getTitle().contains(cadenaBuscada))
						.map(x->x.getTitle()).sorted().forEach(System.out::println);
		
	}// cierre getTitByStr
	
	public static void getUserAlbum(List<Usuario> users, List<Album> albums) {
		Map<Integer, String> userMap = new HashMap<>();
		Map<Integer, String> albumMap = new HashMap<>();
		Map<Map<Integer, String>,Map<Integer, String>> userConcatAlbum = new HashMap<>();
		
		for()
		
	}// cierre getUserAlbum
	
	
}// Cierre clase MAIN APP
