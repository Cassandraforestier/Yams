package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Graphics;
 
public class Fenetre extends JFrame {
	
	JButton b1;
	private int largeur = 800;
	private int hauteur = 600;
	
	public Fenetre(){
		
		
	    this.setTitle("Yams");
	    this.setSize(largeur, hauteur);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    

	    JButton btnLancePartie = new JButton("Lancer une partie");

	    JLabel labelTitre = new JLabel("BIENVENUE SUR LE YAMS");
	    labelTitre.setFont(new Font("Arial", Font.BOLD, 32));
	    labelTitre.setForeground(Color.WHITE);
	    
	    //Le conteneur principal
	    JPanel content = new ImagePanel();
	    content.setPreferredSize(new Dimension(300, 120));
	    content.setBackground(Color.WHITE);
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());
			
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
			
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.weighty = 1.0;
	    gbc.gridy = 0;
	    content.add(labelTitre, gbc);
	    
	    gbc.gridy = 1;
	    gbc.weighty = 0.1;
	    gbc.anchor = GridBagConstraints.PAGE_END;

	    content.add(btnLancePartie, gbc);
	    
	    //---------------------------------------------
	    //On ajoute le conteneur
	    this.setContentPane(content);
	    this.setVisible(true);		
	  }
	
	  public void actionPerformed(ActionEvent arg0) {      

	  } 
	}