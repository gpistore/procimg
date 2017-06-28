package utils.view;	

import java.lang.String;
import java.awt.BorderLayout;
import java.awt.Component;
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
		JScrollPane scroll = new JScrollPane();
		JPanel main = new JPanel();
		JLabel LblImg = new JLabel();
		JLabel Lblanterior = new JLabel();
		JMenuBar menuBar = new JMenuBar();
		JMenu mnArquivo = new JMenu("Arquivo"),
			  mnAjuda = new JMenu("Ajuda"),
			  mnFerramentas = new JMenu("Ferramentas"),
			  mnFiltro = new JMenu("Filtros"),
			  mnPassaBaixa = new JMenu("Passa-Baixa"),
			  mnMediana = new JMenu("Mediana"),
			  mnOperacoes = new JMenu("Operações");
		JMenuItem preferenciasAction = new JMenuItem("Preferencias"), 
				  sairAction = new JMenuItem("Sair"),
				  abrirAction = new JMenuItem("Abrir"),
				  salvarAction = new JMenuItem("Salvar"),
				  sobreAction = new JMenuItem("Sobre"),
				  limparAction = new JMenuItem("Limpar"),
				  desfazerAction = new JMenuItem("Desfazer"),
				  histogramaAction = new JMenuItem("Histograma"),
				  grayscaleAction = new JMenuItem("Escala de Cinza"),
				  corrigeAction = new JMenuItem("Realce"),
				  media3Action = new JMenuItem("Passa-Baixa 3X3"),
				  media3PAction = new JMenuItem("Passa-Baixa 3X3 Ponderada"),
				  media5Action = new JMenuItem("Passa-Baixa 5X5"),
				  media5PAction = new JMenuItem("Passa-Baixa 5X5 Ponderada"),
				  passaAltaAction = new JMenuItem("Média Harmônica"),
				  convolucaoAction = new JMenuItem("Sobel"),
				  mediana5Action = new JMenuItem("5X5"),
				  mediana7Action = new JMenuItem("7X7"),
				  modaAction = new JMenuItem("Moda"),
				  somaAction = new JMenuItem("Soma"),
				  subtracaoAction = new JMenuItem("Subtração"),
				  andAction = new JMenuItem("'E' lógico"),
				  orAction = new JMenuItem("'OU' lógico"),
				  xorAction = new JMenuItem("'OU' Exclusivo lógico");
				
		
	
		
		public tela() {
			super("Processamento Digital de Imagens");
			menuprincipal();
			adicionatela();
			main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
			Janela.setResizable(false);
			Janela.setTitle("PROCIMG");
			Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			Janela.pack();
			Janela.setSize(1300, 725);
			Janela.setVisible(true);
			Janela.setJMenuBar(menuBar);
			
		}
		
		private void addmenu(JMenuItem filho, JMenu pai){
			pai.add(filho);
		}
		
		private void menuArquivo(){
			menuBar.add(mnArquivo);
			addmenu(abrirAction,mnArquivo);
			addmenu(salvarAction,mnArquivo);
			addmenu(desfazerAction,mnArquivo);
			addmenu(limparAction,mnArquivo);
			addmenu(sairAction,mnArquivo);
			
			abrirAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
				   	utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.abrir());
				}
			});
			
			salvarAction.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	utils.view.imagem imagem = new utils.view.imagem();
	            	imagem.salvar(LblImg);	            	
	            }
	        });
			
			desfazerAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					desfazer();
				}
			});
			
			limparAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					main.removeAll();
					main.validate();
					main.repaint();
				}
			});
			
			sairAction.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	System.exit(0);
	            }
	        });
		}
		
		private void menuFerramentas(){
			menuBar.add(mnFerramentas);
			addmenu(histogramaAction,mnFerramentas);
			addmenu(grayscaleAction,mnFerramentas);
			addmenu(corrigeAction,mnFerramentas);	
			
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
		}
		
		private void menuFiltros(){
			menuBar.add(mnFiltro);
			addmenu(mediana5Action,mnMediana);
			addmenu(mediana7Action,mnMediana);
			addmenu(media3Action,mnPassaBaixa);
			addmenu(media3PAction,mnPassaBaixa);
			addmenu(media5Action,mnPassaBaixa);
			addmenu(media5PAction,mnPassaBaixa);
			addmenu(mnPassaBaixa,mnFiltro);
			addmenu(mnMediana,mnFiltro);
			addmenu(modaAction,mnFiltro);
			addmenu(passaAltaAction,mnFiltro);
			addmenu(convolucaoAction,mnFiltro);
			
			
			
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
			
			modaAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.filtrar(LblImg,8));
				}
			});
			
		}
		
		private void menuOperacoes(){
			menuBar.add(mnOperacoes);
			addmenu(somaAction,mnOperacoes);
			addmenu(subtracaoAction,mnOperacoes);
			addmenu(andAction,mnOperacoes);
			addmenu(orAction,mnOperacoes);
			addmenu(xorAction,mnOperacoes);
			
			somaAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.popup pops = new utils.view.popup();
					Image img = pops.abrir();
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.somar(LblImg,img));
				}
			});
			
			subtracaoAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.popup pops = new utils.view.popup();
					Image img = pops.abrir();
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.subtrair(LblImg,img));
				}
			});
			
			andAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.popup pops = new utils.view.popup();
					Image img = pops.abrir();
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.and(LblImg,img));
				}
			});
			
			orAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.popup pops = new utils.view.popup();
					Image img = pops.abrir();
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.subtrair(LblImg,img));
				}
			});
			
			xorAction.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					utils.view.popup pops = new utils.view.popup();
					Image img = pops.abrir();
					utils.view.imagem imagem = new utils.view.imagem();
					alteramain(imagem.subtrair(LblImg,img));
				}
			});
		}
		
		private void menuAjuda(){
			menuBar.add(mnAjuda);
			addmenu(sobreAction,mnAjuda);
		}
		
		public void menuprincipal(){
			menuArquivo();
			menuFerramentas();
			menuFiltros();
			menuOperacoes();
		}
		
		public void alteramain(Image imagem){
			if (imagem != null){
				Lblanterior = LblImg;
				main.removeAll();
				LblImg = new JLabel(new ImageIcon(imagem));
				scroll.setViewportView(LblImg);
				main.add(scroll, BorderLayout.CENTER);				
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