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
		JLabel Lblanterior = new JLabel();
	
		public tela() {
		super("Processamento Digital de Imagens");
			
			Janela.setResizable(false);
			Janela.setTitle("PEINTE");
			adicionamenu();
			adicionatela();
			Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			Janela.pack();
			Janela.setSize(1300, 1024);
			Janela.setVisible(true);
	}
		
		public void adicionamenu(){
			
			JMenuBar menuBar;
			JMenu mnArquivo,mnAjuda,mnFerramentas,mnFiltro,mnpassabaixa,mnmediana;
			JMenuItem preferenciasAction, sairAction,abrirAction,salvarAction,mntmSobre,histogramaAction,grayscaleAction,corrigeAction,media3Action,media3PAction,media5Action,media5PAction,
			passaAltaAction,convolucaoAction,mediana5Action,mediana7Action,desfazerAction;
			
			//Sobre
			mntmSobre = new JMenuItem("Sobre");
			mnAjuda = new JMenu("Ajuda");
			mnAjuda.add(mntmSobre);			
			
			//Arquivo
			mnArquivo = new JMenu("Arquivos");
			preferenciasAction = new JMenuItem("Preferencias");
			abrirAction = new JMenuItem("Abrir");
			salvarAction = new JMenuItem("Salvar");
			sairAction = new JMenuItem("Sair");
			mnArquivo.add(preferenciasAction);
			mnArquivo.add(abrirAction);
			mnArquivo.add(salvarAction);
			mnArquivo.add(sairAction);
			
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
			mnFerramentas = new JMenu("Ferramentas");
			grayscaleAction = new JMenuItem("Escala de Cinza");
			corrigeAction = new JMenuItem("Corrige");
			histogramaAction = new JMenuItem("Histograma");
			desfazerAction = new JMenuItem("Desfazer");
			
		
			
			mnFerramentas.add(histogramaAction);
			mnFerramentas.add(grayscaleAction);
			mnFerramentas.add(corrigeAction);
			mnFerramentas.add(desfazerAction);
			
			
			
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
			
			corrigeAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.corrige(LblImg));
					}
				});
			
			desfazerAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					desfazer();
					}
				});

			
			
			mnmediana = new JMenu("Mediana");
			mediana5Action = new JMenuItem("5X5");
			mediana7Action = new JMenuItem("7X7");
			mnmediana.add(mediana5Action);
			mnmediana.add(mediana7Action);
			
			
			mnpassabaixa = new JMenu("Passa-Baixa");
			media3Action = new JMenuItem("Passa-Baixa 3X3");
			media3PAction = new JMenuItem("Passa-Baixa 3X3 Ponderada");
			media5Action = new JMenuItem("Passa-Baixa 5X5");
			media5PAction = new JMenuItem("Passa-Baixa 5X5 Ponderada");
			mnpassabaixa.add(media3Action);
			mnpassabaixa.add(media3PAction);
			mnpassabaixa.add(media5Action);
			mnpassabaixa.add(media5PAction);
			
			passaAltaAction = new JMenuItem("Passa-Alta ");
			convolucaoAction = new JMenuItem("Convolução");
			
			mnFiltro =  new JMenu("Filtros");
			mnFiltro.add(mnpassabaixa);
			mnFiltro.add(passaAltaAction);
			mnFiltro.add(convolucaoAction);
			mnFiltro.add(mnmediana);
			
			media3Action.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,0));
					}
				});
			
			
			media3PAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,1));
					}
				});
			
			
			media5Action.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,2));
					}
				});
			
			
			media5PAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,3));
					}
				});
			
			passaAltaAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,4));
					}
				});
			
			convolucaoAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,5));
					}
				});
			mediana5Action.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,6));
					}
				});
			mediana7Action.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,7));
					}
				});
			
			
			
			menuBar = new JMenuBar();
			menuBar.add(mnArquivo);
			menuBar.add(mnAjuda);
			menuBar.add(mnFerramentas);
			menuBar.add(mnFiltro);
			
			Janela.setJMenuBar(menuBar);
		}
		
		public void alteramain(Image imagem){
					if (imagem != null){
					Lblanterior = LblImg;
					main.removeAll();
					int width = imagem.getWidth(Janela);
					int heigth = imagem.getHeight(Janela);
					if (width > 1024 || heigth > 768){
						imagem = imagem.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
					}
					LblImg = new JLabel(new ImageIcon(imagem));
					main.add(LblImg, BorderLayout.CENTER);
					}
					main.updateUI();
					
			}
		
		public void desfazer(){
			LblImg= Lblanterior ;
			main.removeAll();
			main.add(LblImg, BorderLayout.CENTER);
			main.updateUI();
		}
		
		public void adicionatela(){
				Janela.add(main);
				main.setVisible(true);
				main.setSize(800, 600);
			}
		
}