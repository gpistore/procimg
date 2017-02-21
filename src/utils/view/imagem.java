package utils.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class imagem {
	Image imagem;
	public Image leImagem(String caminho) throws IOException{
		
		File sourceimage = new File(caminho);
		return imagem = ImageIO.read(sourceimage);
	}
	public void salvaImagem(Component component, String format, OutputStream output) throws IOException {  
        // criar imagem em memória  
        int width = component.getWidth();  
        int height = component.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
  
        // obter contexto gráfico da imagem  
        Graphics graphics = image.getGraphics();  
  
        // desenhar o componente no contexto grafico  
        component.paintAll(graphics);  
        graphics.dispose();  
  
        // salvar imagem  
        ImageIO.write(image, format, output);  
    } 
}
