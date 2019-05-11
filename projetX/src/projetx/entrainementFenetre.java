/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author BERNARD
 */
public class entrainementFenetre extends JFrame implements ActionListener
{
    private JButton noob;
    private JButton standard;
    private JButton bilingue;
    private JButton menu;
    public void actionPerformed(ActionEvent ev)
    {
    if(ev.getSource() == noob)
    {
        try {
            noobFenetre fenetre = new noobFenetre();
        } catch (IOException ex) {
            Logger.getLogger(entrainementFenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }
    if(ev.getSource() == standard)
    {
        //ici, le try/catch  est utilisé car on a un bufferedreader dans la page suivante
        try {
            standardFenetre fenetre = new standardFenetre();
        } catch (IOException ex) {
            Logger.getLogger(entrainementFenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }
    if(ev.getSource() == bilingue)
    {
        try {
            bilingueFenetre fenetre = new bilingueFenetre();
        } catch (IOException ex) {
            Logger.getLogger(entrainementFenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }
    if(ev.getSource() == menu)   
    {
        accueilFen fenetre = new accueilFen();
        setVisible(false);
    }
    }
    public entrainementFenetre()
    {
    //Sur chaque page, on configure les boutons et les zones de texte
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("fenetreEntrainement");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel nomSite = new JLabel();
        nomSite.setFont(new Font("Algerian", Font.PLAIN, 28));
        // Pour que le texte sooit relativement centré sur n'importe quel écran on ne met pas 
        nomSite.setBounds((int)(width/2.4),(int)(height*0.13), (int)(width*0.5),(int)(height*0.06));
        contenant.add(nomSite);
        nomSite.setText("Choisissez une difficulté :");
        
        noob = new JButton ("noob");
        noob.setBounds((int)(width/2-width*0.11/2),(int)(height*0.22), (int)(width*0.11),(int)(height*0.06));
        contenant.add(noob);
        noob.addActionListener(this);
        
        standard = new JButton ("standard");
        standard.setBounds((int)(width/2-width*0.11/2),(int)(height*0.42), (int)(width*0.11),(int)(height*0.06));
        contenant.add(standard);
        standard.addActionListener(this);
        
        bilingue = new JButton ("bilingue");
        bilingue.setBounds((int)(width/2-width*0.11/2),(int)(height*0.62), (int)(width*0.11),(int)(height*0.06));
        contenant.add(bilingue);
        bilingue.addActionListener(this);
        
        menu = new JButton ("Menu principal");
        menu.setBounds((int)(width*0.85),(int)(height*0.80),(int)(width*0.09),(int)(height*0.04));
        contenant.add(menu);
        menu.addActionListener(this);
    }
}


