package utils.view;

import java.lang.String;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class tela extends JFrame {
		JFrame Janela = new JFrame();
		JPanel main = new JPanel();
	
		public tela() {
		super("Processamento Digital de Imagens");
			Janela.setPreferredSize(new Dimension(800, 600));
			Janela.setResizable(false);
			adicionamenu();
			adicionatela();
			Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			Janela.pack();
			Janela.setSize(850, 700);
			Janela.setVisible(true);
	}
		
		public void adicionamenu(){
			
			JMenuBar menuBar;
			JMenu marquivo,mnAjuda;
			JMenuItem preferenciasAction, sairAction,abrirAction,salvarAction,mntmSobre;
			
			mntmSobre = new JMenuItem("Sobre");
			mnAjuda = new JMenu("Ajuda");
			mnAjuda.add(mntmSobre);			
			
			marquivo = new JMenu("Arquivos");
			preferenciasAction = new JMenuItem("Preferencias");
			abrirAction = new JMenuItem("Abrir");
			salvarAction = new JMenuItem("Salvar");
			sairAction = new JMenuItem("Sair");
			marquivo.add(preferenciasAction);
			marquivo.add(abrirAction);
			marquivo.add(salvarAction);
			marquivo.add(sairAction);
			
			sairAction.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	System.exit(0);
	            }
	        });
			
			salvarAction.addActionListener(new ActionListener() {
				String NomeArq;
	            public void actionPerformed(ActionEvent arg0) {
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
	            	utils.view.imagem imagem = new utils.view.imagem();
	            	try {
						imagem.salvaImagem(main,"jpg",output);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            }
	        });
			
			abrirAction.addActionListener(new ActionListener(){
				private String caminho;
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser abrir = new JFileChooser();
					abrir.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg", "jpeg"));
					abrir.setAcceptAllFileFilterUsed(false);
					int retorno = abrir.showOpenDialog(null);  
						if (retorno==JFileChooser.APPROVE_OPTION)  
							caminho = abrir.getSelectedFile().getAbsolutePath();
							utils.view.imagem imagem = new utils.view.imagem();
							try {
								Image image = imagem.leImagem(caminho);
								alteramain(image);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
				});
			
			menuBar = new JMenuBar();
			menuBar.add(marquivo);
			menuBar.add(mnAjuda);
			
			Janela.setJMenuBar(menuBar);
		}
		
		public void alteramain(Image imagem){
					imagem = imagem.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
					main.removeAll();
					JLabel label = new JLabel(new ImageIcon(imagem));
					main.add(label, BorderLayout.CENTER);
					main.updateUI();
					
			}
		public void adicionatela(){
				Janela.add(main);
				main.setVisible(true);
				main.setSize(800, 600);
			}
		
}