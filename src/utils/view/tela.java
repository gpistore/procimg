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
		JLabel LblImg = new JLabel();
	
		public tela() {
		super("Processamento Digital de Imagens");
			
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
			JMenu marquivo,mnAjuda,mnferramentas;
			JMenuItem preferenciasAction, sairAction,abrirAction,salvarAction,mntmSobre,histogramaAction,grayscaleAction;
			
			//Sobre
			mntmSobre = new JMenuItem("Sobre");
			mnAjuda = new JMenu("Ajuda");
			mnAjuda.add(mntmSobre);			
			
			//Arquivo
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
	            public void actionPerformed(ActionEvent arg0) {
	            	utils.view.imagem imagem = new utils.view.imagem();
	            	imagem.salvar(LblImg);	            	
	            }
	        });
			
			abrirAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
				   	utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.abrir());
				}
			});

			
			//Ferramentas
			mnferramentas = new JMenu("Ferramentas");
			grayscaleAction = new JMenuItem("Escala de Cinza");
			histogramaAction = new JMenuItem("Histograma");
			mnferramentas.add(histogramaAction);
			mnferramentas.add(grayscaleAction);
			
			histogramaAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					imagem.histograma(LblImg);
						}
				});
			grayscaleAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.grayscale(LblImg));
					}
				});
			

			
			
			menuBar = new JMenuBar();
			menuBar.add(marquivo);
			menuBar.add(mnAjuda);
			menuBar.add(mnferramentas);
			
			Janela.setJMenuBar(menuBar);
		}
		
		public void alteramain(Image imagem){
					if (imagem != null){
					main.removeAll();
					imagem = imagem.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
					LblImg = new JLabel(new ImageIcon(imagem));
					main.add(LblImg, BorderLayout.CENTER);
					}
					main.updateUI();
					
			}
		public void adicionatela(){
				Janela.add(main);
				main.setVisible(true);
				main.setSize(800, 600);
			}
		
}