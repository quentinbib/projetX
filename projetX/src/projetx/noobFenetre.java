/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Hugo
 */

public class noobFenetre extends JFrame implements ActionListener
{
    public static BufferedReader fR;
    // on l'utilise ici pour lire la liste de mots du fichier texte
    //la fonction suivante permet de lire ligne par ligne le fichier texte grace au BufferedReader
    public static String lecture() throws IOException
    {
        String ligneFichier = fR.readLine();
        return ligneFichier;
    }
    
    private JButton retour;
    private JButton next;
    private JButton valider;
    private JTextField morse2;
    private JTextField morse3;
    static String ligne ="";
    static String morse[] ={ ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","..."," -","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",""};
    static String normal[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"," "};
     public void actionPerformed(ActionEvent ev)
     {
         
        if(ev.getSource() == valider)
        {
            String nouvotexte = ligne;
            String motEnMorse = "" ;
            int lettre = 0; 
            String stringvalueof;
            
            for (int i = 0; i < nouvotexte.length(); i++) 
            {
                stringvalueof = String.valueOf(nouvotexte.charAt(lettre));
                for (int loop=0; loop < normal.length; loop++)
                {  
                    if (normal[loop].equalsIgnoreCase(stringvalueof))
                    {
                        motEnMorse = (motEnMorse + (morse[loop])); 
                    }
                }
                lettre = lettre + 1;  
            }
        if (morse2.getText().equalsIgnoreCase(motEnMorse))
        {
            try 
            {
               noobFenetre fenetre = new noobFenetre();
            } catch (IOException ex) 
            {
               Logger.getLogger(noobFenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        }
        else
        {
            System.out.println(motEnMorse);
            Font font1 = new Font("", Font.PLAIN, 14);
            morse2.setText("reesayer");
            morse2.setForeground(Color.red);
            morse2.setFont(font1);
        }
        if(ev.getSource() == retour)
        {
            entrainementFenetre fenetre = new entrainementFenetre();
            setVisible(false);
        }
        // Si l'utilisateur n'arrive pas à traduire un mot, il peut passer à un autre mot
        if(ev.getSource() == next)
        {
            try 
            {
                noobFenetre fenetre = new noobFenetre();
            } catch (IOException ex) 
            {
                Logger.getLogger(noobFenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        }
        //On peut toujours retourner au menu des niveaux dans les exercices
        if(ev.getSource() == retour)
        {
            entrainementFenetre fenetre = new entrainementFenetre();
            setVisible(false);
        }
     }
     }
public noobFenetre() throws FileNotFoundException, IOException
{
    //On selectionne le fichier qu'on va utiliser
    fR = new BufferedReader(new FileReader(new File("src/levels/niveaunoob.txt")));
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
    //La ligne suivante permet de choisir une ligne au hasard dansle fichier
    int random = (int)( Math.random()*36 + 1);
    for (int i = 0; i < random; i++)
     {
         ligne = lecture();
     }
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("noobFenetre");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel nomPage = new JLabel();
        nomPage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
        nomPage.setBounds((int)(width*0.20),(int)(height*0.13), (int)(width*0.95),(int)(height*0.06));
        contenant.add(nomPage);
        nomPage.setText("Traduisez les lettres et chiffres suivants en morse grâce aux touches '.' et '-'");
        
        JLabel mottrad = new JLabel();
        mottrad.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
        mottrad.setBounds((int)(width*0.40),(int)(height*0.20), (int)(width*0.60),(int)(height*0.06));
        contenant.add(mottrad);
        mottrad.setText("Traduire le caractère " + ligne);
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.40), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("", Font.PLAIN, 25);
        morse2.setForeground(Color.black);
        add(morse2);
        
        next = new JButton ("Passer");
        next.setBounds((int)(width/2-width*0.11/2),(int)(height*0.62), (int)(width*0.11),(int)(height*0.06));
        contenant.add(next);
        next.addActionListener(this);
        
        retour = new JButton ("Retour");
        retour.setBounds((int)(width*0.81),(int)(height*0.82), (int)(width*0.09),(int)(height*0.04));
        contenant.add(retour);
        retour.addActionListener(this);
        
        valider = new JButton ("valider");
        valider.setBounds((int)(width/2-width*0.11/2),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(valider);
        valider.addActionListener(this);
}
}

