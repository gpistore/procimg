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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;

public class imagem {
	Image imagem;
	public Image leImagem(String caminho) throws IOException{
		File sourceimage = new File(caminho);
		return imagem = ImageIO.read(sourceimage);
	}
	
	public Image abrir(){
		String caminho = null;
		JFileChooser abrir = new JFileChooser("C:/OneDrive/Imagens");
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
	
	public void histograma (Component component){
		int[] histograma = new int[256];
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
        	      histograma[soma]++;
        	  }
         }
         
 		XYSeries series = new XYSeries("Random Data");
 		for(int i=0;i<255;i++){
 			series.add(i,histograma[i]);	 
         }
         utils.view.graphs grafico = new utils.view.graphs("Histograma",series);
	}
	
	public Image corrige (Component component){
		float[] histograma = new float[256];
		int[] ajustado = new int[256];
		int width = component.getWidth();  
        int height = component.getHeight();
        int total = 0;
        float somahist = 0;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        component.paintAll(graphics);
        graphics.dispose();
        for(int i=0; i<height; i++){
        	
         for(int j=0; j<width; j++){
        	 total ++;
        	Color cor = new Color(image.getRGB(j, i));
              int red = (int)(cor.getRed() * 0.3);
              int green = (int)(cor.getGreen() * 0.59);
              int blue = (int)(cor.getBlue() * 0.11);
              int soma = red + green + blue;
              histograma[soma]++;
        	  }
         }
        for(int i=0;i<255;i++){
        	somahist += (histograma[i]/total);
        	ajustado[i] = (int)Math.round(somahist*255);
        }
    	System.out.println(total);
        for(int i=0; i<height; i++){
       	 for(int j=0; j<width; j++){
       		Color cor = new Color(image.getRGB(j, i));
       	      int red = (int)(cor.getRed() * 0.3);
       	      int green = (int)(cor.getGreen() * 0.59);
       	      int blue = (int)(cor.getBlue() * 0.11);
       	      int soma = red + green + blue;
      	        Color novaCor = new Color(ajustado[soma],ajustado[soma],ajustado[soma]);
       	        image.setRGB(j,i,novaCor.getRGB());
       	        
       	      }
       	    }
        return image;
	}
	
	public Image filtrar (Component component,int cdfiltro){
		filtro filtro = new filtro();
		int width = component.getWidth();  
        int height = component.getHeight();
		int[][] arrayred = new int[height][width];
		int[][] arraygreen = new int[height][width];
		int[][] arrayblue = new int[height][width];
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        component.paintAll(graphics);
        graphics.dispose();
        for(int i=0; i<height; i++){
        	for(int j=0; j<width; j++){
        		Color cor = new Color(image.getRGB(j, i));
   	      		arrayred[i][j] = cor.getRed();
   	      		arraygreen[i][j] = cor.getGreen(); 
   	      		arrayblue[i][j] = cor.getBlue(); 
       	 	}
    	}
        
        switch(cdfiltro){
        	case 0:{
        		arrayred = filtro.media3(arrayred);
        		arraygreen = filtro.media3(arraygreen);
        		arrayblue = filtro.media3(arrayblue);
        		break;
        	}
        	case 1:{
        		arrayred = filtro.media3p(arrayred);
        		arraygreen = filtro.media3p(arraygreen);
        		arrayblue = filtro.media3p(arrayblue);
        		break;
        	}
        	case 2:{
        		arrayred = filtro.media5(arrayred);
        		arraygreen = filtro.media5(arraygreen);
        		arrayblue = filtro.media5(arrayblue);
        		break;
        	}
        	case 3:{
        		arrayred = filtro.media5p(arrayred);
        		arraygreen = filtro.media5p(arraygreen);
        		arrayblue = filtro.media5p(arrayblue);
        		break;
        	}
        	case 4:{
        		arrayred = filtro.passaAlta(arrayred);
        		arraygreen = filtro.passaAlta(arraygreen);
        		arrayblue = filtro.passaAlta(arrayblue);
        		break;
        	}
        	case 5:{
        		arrayred = filtro.convolucao(arrayred);
        		arraygreen = filtro.convolucao(arraygreen);
        		arrayblue = filtro.convolucao(arrayblue);
        		break;
        	}
        	case 6:{
        		arrayred = filtro.mediana5(arrayred);
        		arraygreen = filtro.mediana5(arraygreen);
        		arrayblue = filtro.mediana5(arrayblue);
        		break;
        	}
        	case 7:{
        		arrayred = filtro.mediana7(arrayred);
        		arraygreen = filtro.mediana7(arraygreen);
        		arrayblue = filtro.mediana7(arrayblue);        		
        		break;
        	}
        	default:{
        		break;
        	}
        }
        for(int i=0; i<height; i++){
        	for(int j=0; j<width; j++){
        		Color novaCor = new Color(arrayred [i][j],arraygreen [i][j],arrayblue [i][j]);
    	        image.setRGB(j,i,novaCor.getRGB());
       	 	}
    	}
		return  image;
	}
}

