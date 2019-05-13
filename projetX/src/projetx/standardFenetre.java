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
public class standardFenetre extends JFrame implements ActionListener
{
    public static BufferedReader fR;
    // on l'utilise ici pour lire la liste de mots du fichier texte
    //la fonction suivante permet de lire ligne par ligne le fichier texte grace au BufferedReader
    public static String lecture() throws IOException
    {
        String ligneFichier = fR.readLine();
        return ligneFichier;
    }
    Font font2 = new Font("", Font.PLAIN, 18);
    Font font1 = new Font("", Font.PLAIN, 25);
    private JButton retour;
    private JButton next;
    private final JButton valider;
    private JTextField morse2;
    public static int count = 0;
    static String ligne ;
    static String morse[] ={ ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",""};
    static String normal[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"," "};
public void actionPerformed(ActionEvent ev)
     {
        if(ev.getSource() == valider)
        {
            String morse3 = ((" ") + morse2.getText());
            String nouvtexte = ligne;
            String motEn = "" ;
            int letter = 0; 
            String stringvalueof;
            for (int i = 0; i < nouvtexte.length(); i++) 
            {
                stringvalueof = String.valueOf(nouvtexte.charAt(letter));
                for (int loop=0; loop < normal.length; loop++)
                {  
                    if (normal[loop].equalsIgnoreCase(stringvalueof))
                    {
                        motEn = (motEn + ((" ") + (morse[loop]))); 
                    }
                }
                letter = letter + 1;  
            }
        if (morse3.equalsIgnoreCase(motEn))
            {
                count = count + 1;
                try 
            {
                standardFenetre fenetre = new standardFenetre();
            } catch (IOException ex) 
            {
                Logger.getLogger(standardFenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            }
        else
            {
            morse2.setText("rééssayer");
            }
        }
        if(ev.getSource() == next)
        {
            count = count;
            try 
            {
                standardFenetre fenetre = new standardFenetre();
            } catch (IOException ex) 
            {
                Logger.getLogger(standardFenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        }
        if(ev.getSource() == retour)
        {
            count = 0;
            entrainementFenetre fenetre = new entrainementFenetre();
            setVisible(false);
        }
     }
public standardFenetre() throws FileNotFoundException, IOException
{
    //On selectionne le fichier qu'on va utiliser
    fR = new BufferedReader(new FileReader(new File("src/levels/niveaustandard.txt")));
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
    //La ligne suivante permet de choisir une ligne au hasard dans le fichier
    int random = (int)( Math.random()*56 + 1);
    for (int i = 0; i < random; i++)
     {
         ligne = lecture();
     }
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("standardFenetre");
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
        mottrad.setText("Traduire le mot : " + ligne );
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.40), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("morse 2", Font.PLAIN, 25);
        morse2.setFont(font1);
        add(morse2);
        
        next = new JButton ("Suivant");
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
        
        JLabel vousAvez = new JLabel();
        vousAvez.setBounds((int)(width*0.42),(int)(height*0.72),(int)(width*0.6),(int)(height*0.06));
        vousAvez.setText("Vous avez réussi " + (count) +  " niveaux.");
        vousAvez.setForeground(Color.blue);
        vousAvez.setFont(font2); 
        contenant.add(vousAvez);
    }
}

