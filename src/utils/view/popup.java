package utils.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

public class popup extends JDialog {
	/**
	 * 
	 */
	JDialog Janela;
	
	public popup(){
	}
	
	public Image abrir(){
		String caminho = null;
		int retorno;
		ImagePreviewPanel preview = new ImagePreviewPanel();
        JFileChooser Chooser = new JFileChooser("c:/OneDrive/imagens/");
        Chooser.setDialogTitle("Selecione o arquivo que deseja operar com a imagem atual");
        Chooser.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg", "jpeg"));
        Chooser.setAcceptAllFileFilterUsed(false);
        Chooser.setPreferredSize(new Dimension(550,300));
        Chooser.setAccessory(preview);
        Chooser.addPropertyChangeListener(preview);
        retorno = Chooser.showOpenDialog(null);  
		if (retorno==JFileChooser.APPROVE_OPTION){  
			caminho = Chooser.getSelectedFile().getAbsolutePath();
			utils.view.imagem imagem = new utils.view.imagem();
			try {
				dispose();
				return imagem.leImagem(caminho);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			dispose();
			return null;
        
        
        
        
	}
}
