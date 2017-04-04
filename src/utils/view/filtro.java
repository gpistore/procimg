package utils.view;

import java.awt.Image;

public class filtro {
	
	private int tratasoma(double soma){
		while (soma > 255){
			soma = 255 - soma;
		}
		while (soma < 0){
			soma = 255 + soma; 
		}
			return (int)soma;
		
	}
	
	public int[][] media3(int[][]img){
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				int soma = (img[i-1][j-1]	+
							img[i-1][j]		+
							img[i-1][j+1]	+
							img[i][j-1]		+
							img[i][j]		+
							img[i][j+1]		+
							img[i+1][j-1]	+
							img[i+1][j]		+
							img[i+1][j+1]
									)/9;
					img[i][j]= tratasoma(soma);
				 
			}
		}
		return img;
	}
	public int[][] media3p(int[][]img){
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
				img[i][j]= tratasoma(soma);
			}
		}
		return img;
	}
	
	public int[][] media5(int[][]img){
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
				img[i][j]= tratasoma(soma);
			}
		}
		return img;
	}
	
	public int[][] media5p(int[][]img){
		int [][] b = img.clone();
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
				img[i][j]= tratasoma(soma);
				}
		}
		return img;
	}
	
	public int[][] correlacao(int[][]img){
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				double soma = (	(img[i-1][j-1]*-1)	+
								(img[i-1][j]*0.0)	+
								(img[i-1][j+1])		+	
								(img[i][j-1]*-2.0)	+
								(img[i][j]*0.0)	+
								(img[i][j+1]*2.0)	+	
								(img[i+1][j-1]*-1)	+
								(img[i+1][j]*0.0)	+
								(img[i+1][j+1])
								)/16;
				img[i][j]= tratasoma(soma);
				}
		}
		for (int j=1;j<img.length-1;j++){
			for (int i=1;i<img[j].length-1;i++){
				double soma = (	(img[i-1][j-1]*-1)	+
								(img[i-1][j]*0.0)	+
								(img[i-1][j+1])		+	
								(img[i][j-1]*-2.0)	+
								(img[i][j]*0.0)	+
								(img[i][j+1]*2.0)	+	
								(img[i+1][j-1]*-1)	+
								(img[i+1][j]*0.0)	+
								(img[i+1][j+1])
								)/16;
				img[j][i]= tratasoma(soma);
				System.out.println(i+"-"+j);
				}
		}
		
	
		return img;
	}
	
	public int[][] convolucao(int[][]img){
		for (int i=1;i<img.length-1;i++){
			for (int j=1;j<img[i].length-1;j++){
				double soma = (	(img[i-1][j-1])		+	
								(img[i-1][j+1]*-1)	+	
								(img[i][j-1]*2)		+	
								(img[i][j])			+	
								(img[i][j+1]*-2)	+	
								(img[i+1][j-1])		+	
								(img[i+1][j+1]*-1)
								)/16;
				img[i][j]= tratasoma(soma);
			}
		}
		return img;
	}
	

}
