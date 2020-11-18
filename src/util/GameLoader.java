package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameLoader {

	
	public static HashMap<String, Image> images = new HashMap<>();
	public static HashMap<String, BufferedImage> sprites = new HashMap<>();
	public static HashMap<String, BufferedImage> maps = new HashMap<>();

	public static void loadResources() {
		
		// Se agregan los sprites
		sprites.put("SANS", ImageLoader.cargarSprites("images/sans_caminando_abajo.png"));
		sprites.put("SANS ARRIBA", ImageLoader.cargarSprites("images/sans_arriba.png"));
		sprites.put("SANS DERECHA", ImageLoader.cargarSprites("images/sans_derecha.png"));
		sprites.put("SANS IZQUIERDA", ImageLoader.cargarSprites("images/sans_izquierda.png"));
		sprites.put("SANS BROMA", ImageLoader.cargarSprites("images/sans_broma.png"));
		sprites.put("SANS PEINE", ImageLoader.cargarSprites("images/sans-peinandose.png"));
		
		
		//Se agregan las imagenes
		images.put("BACKGROUND", ImageLoader.cargarImagen("images/background.jpg"));
		
		//icono
		images.put("ICON", ImageLoader.cargarImagen("images/icono.jpg"));
		images.put("CURSOR", ImageLoader.cargarImagen("images/cursor.png"));
		// Se agregan los mapas
		//maps.put("MAP1", ImageLoader.cargarSprites("images/map.png"));
		
	}

	
}
