package animation;

import java.awt.image.BufferedImage;

/*
 * Code based from Juan Camilo Velez Olaya
 * github: https://github.com/juanchovelezpro
 */
public class SpriteSheet {
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int row, int col, int width, int height) {
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		return img;
	}
}
