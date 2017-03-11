package utils.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class imagem {
	Image imagem;
	public Image leImagem(String caminho) throws IOException{
		File sourceimage = new File(caminho);
		return imagem = ImageIO.read(sourceimage);
	}
	
	public Image abrir(){
		String caminho = null;
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg", "jpeg"));
		abrir.setAcceptAllFileFilterUsed(false);
		int retorno = abrir.showOpenDialog(null);  
			if (retorno==JFileChooser.APPROVE_OPTION){  
				caminho = abrir.getSelectedFile().getAbsolutePath();
				utils.view.imagem imagem = new utils.view.imagem();
				try {
					return imagem.leImagem(caminho);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				return null;
	}
	
	public void salvar(Component component){
		String NomeArq = null;
    	JFileChooser salvar = new JFileChooser();
    	int resultado = salvar.showSaveDialog(null);
    	if (resultado == JFileChooser.APPROVE_OPTION) {
    		NomeArq = salvar.getSelectedFile().getAbsolutePath();
    		if (!NomeArq.endsWith(".jpg")){       
    	        NomeArq += ".jpg"; 
    	  }
		}
    	OutputStream output = null;
		try {
			output = new FileOutputStream(NomeArq);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
		    int width = component.getWidth();  
	        int height = component.getHeight();  
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics graphics = image.getGraphics();
	        component.paintAll(graphics);
	        graphics.dispose();
	        ImageIO.write(image, "jpg", output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image grayscale(Component component){
		 int width = component.getWidth();  
         int height = component.getHeight();  
         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         Graphics graphics = image.getGraphics();
         component.paintAll(graphics);
         graphics.dispose();
         width = image.getWidth();
         height =image.getHeight();
         for(int i=0; i<height; i++){
        	 for(int j=0; j<width; j++){
        		Color cor = new Color(image.getRGB(j, i));
        	      int red = (int)(cor.getRed() * 0.3);
        	      int green = (int)(cor.getGreen() * 0.59);
        	      int blue = (int)(cor.getBlue() * 0.11);
        	      int soma = red + green + blue;
       	        Color novaCor = new Color(soma,soma,soma);
        	        image.setRGB(j,i,novaCor.getRGB());
        	        
        	      }
        	    }
		return image;
	}
	
	public Image histograma (Component component){
		
//		BufferedImage image = new BufferedImage(this.grayscale(component);
//		int width = image.getWidth();
//        int height =image.getHeight();
//        for(int i=0; i<height; i++){
//       	 for(int j=0; j<width; j++){
		
		
		return imagem;
//	}}
}
	
	
	
	 
}
