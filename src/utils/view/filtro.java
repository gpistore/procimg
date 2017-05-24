package utils.view;

import java.awt.Image;
import java.util.Arrays;

public class filtro {
	
	private int tratasoma(double soma){
		if (soma > 255){
			soma =  255;
		}else{
			if (soma < 0){
				soma = 0;
			}	 
		}

			return (int)soma;
		
	}
	
	public int[][] media3(int[][]img){
		int img2[][] = new int[img.length][img[0].length];
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				img2[i][j]= tratasoma(( img[i-1][j-1]	+
									  	img[i-1][j]		+
									  	img[i-1][j+1]	+
									  	img[i][j-1]		+
									  	img[i][j]		+
									  	img[i][j+1]		+
									  	img[i+1][j-1]	+
									  	img[i+1][j]		+
									  	img[i+1][j+1])/9
									  );
			}
		}
		return img2;
	}
	
	public int[][] media3p(int[][]img){
		int lin = img.length;
		int col = img[0].length;
		int img2[][] = new int[lin][col];
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				double soma = (	(img[i-1][j-1]*1.5)	+	
								(img[i-1][j]*2.0)		+	
								(img[i-1][j+1]*1.5)	+	
								(img[i][j-1]*2.0)	+	
								(img[i][j]*4.0)	+	
								(img[i][j+1]*2.0)	+	
								(img[i+1][j-1]*1.5)	+	
								(img[i+1][j]*2.0)	+	
								(img[i+1][j+1]*1.5)
								)/18;
				img2[i][j]= tratasoma(soma);
			}
		}
		return img2;
	}
	
	public int[][] media5(int[][]img){
		int lin = img.length;
		int col = img[0].length;
		int img2[][] = new int[lin][col];
		for (int i=2;i<img.length-2;i++){
			for (int j=2;j<img[i].length-2;j++){
				int soma = (img[i-2][j-2]	+
							img[i-2][j-1]	+
							img[i-2][j]	+
							img[i-2][j+1]	+
							img[i-2][j+2]	+
							img[i-1][j-2]	+
							img[i-1][j-1]	+
							img[i-1][j]		+
							img[i-1][j+1]	+
							img[i-1][j+2]	+
							img[i][j-2]		+
							img[i][j-1]		+
							img[i][j]		+
							img[i][j+1]		+
							img[i][j+2]		+
							img[i+1][j-2]	+
							img[i+1][j-1]	+
							img[i+1][j]		+
							img[i+1][j+1]	+
							img[i+1][j+2]	+
							img[i+2][j-2]	+
							img[i+2][j-1]	+
							img[i+2][j]		+
							img[i+2][j+1]	+
							img[i+2][j+2]
									)/25;
				img2[i][j]= tratasoma(soma);
			}
		}
		return img2;
	}
	
	public int[][] media5p(int[][]img){
		int lin = img.length;
		int col = img[0].length;
		int img2[][] = new int[lin][col]; 
		for (int i=2;i<img.length-2;i++){
			for (int j=2;j<img[i].length-2;j++){
				double soma = (		(img[i-2][j-2]*.5)		+
									(img[i-2][j-1]*1.25)	+
									(img[i-2][j])			+
									(img[i-2][j+1]*1.25)	+
									(img[i-2][j+2]*.5)		+
									(img[i-1][j-2]*1.25)		+
									(img[i-1][j-1]*1.5)		+
									(img[i-1][j]*2)			+
									(img[i-1][j+1]*1.5)		+
									(img[i-1][j+2]*1.25)		+
									(img[i][j-2])			+
									(img[i][j-1]*2)			+
									(img[i][j]*4)			+
									(img[i][j+1]*2)			+
									(img[i][j+2])			+
									(img[i+1][j-2]*1.25)		+
									(img[i+1][j-1]*1.5)		+
									(img[i+1][j]*2)			+
									(img[i+1][j+1]*1.5)		+
									(img[i+1][j+2]*1.25)		+
									(img[i+2][j-2]*.5)		+
									(img[i+2][j-1]*1.25)	+
									(img[i+2][j])			+
									(img[i+2][j+1]*1.25)	+
									(img[i+2][j+2]*.5)
									)/34;
				img2[i][j]= tratasoma(soma);
				}
		}
		return img2;
	}
	
	public int[][] passaAlta(int[][]img){
		int lin = img.length;
		int col = img[0].length;
		int img2[][] = new int[lin][col]; 
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				double soma = (	(img[i-1][j-1]*0)	+	
								(img[i-1][j]*-1.0)	+	
								(img[i-1][j+1]*0)	+	
								(img[i][j-1]*-1.0)	+	
								(img[i][j]*4.0)		+	
								(img[i][j+1]*-1.0)	+	
								(img[i+1][j-1]*0)	+	
								(img[i+1][j]*-1.0)	+	
								(img[i+1][j+1]*0)
								);
				img2[i][j]= tratasoma(soma);
			}
		}
			for (int j=1;j<img2[0].length-1;j++){
				for (int i=1;i<img2.length-1;i++){
					double soma = (	(img2[i-1][j-1]*0)	+	
									(img2[i-1][j]*-1.0)	+	
									(img2[i-1][j+1]*0)	+	
									(img2[i][j-1]*-1.0)	+	
									(img2[i][j]*4.0)		+	
									(img2[i][j+1]*-1.0)	+	
									(img2[i+1][j-1]*0)	+	
									(img2[i+1][j]*-1.0)	+	
									(img2[i+1][j+1]*0)
									);
					img[i][j]= tratasoma(soma);
				}
	
			}
		return img;
		}
	

	   
	   
	  public int[][] convolucao(int[][]img){ 
	    
    	int lin = img.length;
		int col = img[0].length;
		int img2[][] = new int[lin][col];
			for (int i=1;i<img.length-1;i++){ 
		      for (int j=1;j<img[i].length-1;j++){ 
		    	  double soma = ( 	(img[i-1][j-1]*-1)  + 
		    			  			(img[i-1][j]*0.0)  	+ 
		    			  			(img[i-1][j+1])    	+   
		    			  			(img[i][j-1]*-2.0)  + 
		    			  			(img[i][j]*1.0)  	+ 
		    			  			(img[i][j+1]*2.0)  	+   
		    			  			(img[i+1][j-1]*-1)  + 
		    			  			(img[i+1][j]*0.0)  	+ 
		    			  			(img[i+1][j+1]) 
			                	); 
		        	img2[i][j]= tratasoma(soma); 
		        }
			}
			for (int i=1;i<img2.length-1;i++){ 
		      for (int j=1;j<img2[i].length-1;j++){ 
		    	  double soma = (	(img2[i-1][j-1]*-1) + 
		    			  			(img2[i-1][j]*0.0)  + 
		    			  			(img2[i-1][j+1]-1)  +   
		    			  			(img2[i][j-1]*2.0)  + 
		    			  			(img2[i][j])  		+ 
		    			  			(img2[i][j+1]*-2.0) +   
		    			  			(img2[i+1][j-1]*1)  + 
		    			  			(img2[i+1][j]*0.0)  + 
		    			  			(img2[i+1][j+1]*-1) 
		    			  		); 
		    	  img[i][j]= tratasoma(soma); 
		       } 
		    }
		  	return img; 
	  } 
	  
		public int[][] mediana5(int[][]img){
			int lin = img.length;
			int col = img[0].length;
			int img2[][] = new int[lin][col];
			for (int i=2;i<img.length-2;i++){
				for (int j=2;j<img[i].length-2;j++){
					double[] valores = {img[i-2][j-2],
										img[i-2][j-1],
										img[i-2][j],
										img[i-2][j+1],
										img[i-2][j+2],
										img[i-1][j-2],
										img[i-1][j-1],
										img[i-1][j],
										img[i-1][j+1],
										img[i-1][j+2],
										img[i][j-2],
										img[i][j-1],
										img[i][j],
										img[i][j+1],
										img[i][j+2],
										img[i+1][j-2],
										img[i+1][j-1],
										img[i+1][j],
										img[i+1][j+1],
										img[i+1][j+2],
										img[i+2][j-2],
										img[i+2][j-1],
										img[i+2][j],
										img[i+2][j+1],
										img[i+2][j+2]};
					Arrays.sort(valores);
					img2[i][j]= tratasoma(valores[12]);
				}
			}
			return img2;
		}
		public int[][] mediana7(int[][]img){
			int lin = img.length;
			int col = img[0].length;
			int img2[][] = new int[lin][col];
			for (int i=3;i<img.length-3;i++){
				for (int j=3;j<img[i].length-3;j++){
					double[] valores = {img[i-3][j-3],
										img[i-3][j-2],
										img[i-3][j-1],
										img[i-3][j],
										img[i-3][j+1],
										img[i-3][j+2],
										img[i-3][j+3],
										img[i-2][j-3],
										img[i-2][j-2],
										img[i-2][j-1],
										img[i-2][j],
										img[i-2][j+1],
										img[i-2][j+2],
										img[i-2][j+3],
										img[i-1][j-3],
										img[i-1][j-2],
										img[i-1][j-1],
										img[i-1][j],
										img[i-1][j+1],
										img[i-1][j+2],
										img[i-1][j+3],
										img[i][j-3],
										img[i][j-2],
										img[i][j-1],
										img[i][j],
										img[i][j+1],
										img[i][j+2],
										img[i][j+3],
										img[i+1][j-3],
										img[i+1][j-2],
										img[i+1][j-1],
										img[i+1][j],
										img[i+1][j+1],
										img[i+1][j+2],
										img[i+1][j+3],
										img[i+2][j-3],
										img[i+2][j-2],
										img[i+2][j-1],
										img[i+2][j],
										img[i+2][j+1],
										img[i+2][j+2],
										img[i+2][j+3],
										img[i+3][j-3],
										img[i+3][j-2],
										img[i+3][j-1],
										img[i+3][j],
										img[i+3][j+1],
										img[i+3][j+2],
										img[i+3][j+3]};
					Arrays.sort(valores);
					img2[i][j]= tratasoma(valores[24]);
				}
			}
			return img2;
		}
		
}
