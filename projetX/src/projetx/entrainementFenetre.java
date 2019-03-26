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
/**
 *
 * @author BERNARD
 */
public class entrainementFenetre extends JFrame implements ActionListener
{
    private JButton noob;
    private JButton standard;
    private JButton bilingue;
    public void actionPerformed(ActionEvent ev)
    {
    if(ev.getSource() == noob)
    {
        
    }
    if(ev.getSource() == standard)
    {
        
    }
    if(ev.getSource() == bilingue)
    {
        
    }
    }
    public entrainementFenetre()
    {
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
        nomSite.setBounds((int)(width/2-width*0.11/2),(int)(height*0.13), (int)(width*0.5),(int)(height*0.06));
        contenant.add(nomSite);
        nomSite.setText("Choisissez une difficulté");
        
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
    }
}


