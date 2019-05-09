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
    public static int count = 0;
    Font font1 = new Font("", Font.PLAIN, 25);
    private JButton retour;
    private JButton next;
    private JButton valider;
    private JTextField morse2;
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
            count = count + 1;
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
            morse2.setText("reesayer");
            morse2.setForeground(Color.black);
            morse2.setFont(font1);
        }
        }
        if(ev.getSource() == retour)
        {
            count = 0;
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
        morse2.setForeground(Color.black);
        morse2.setFont(font1);
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
        
        Font font2 = new Font("", Font.PLAIN, 18);
        JLabel AToM = new JLabel();
        AToM.setBounds((int)(width*0.06),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        AToM.setText("<html>A<br/><br/>B<br/><br/>C<br/><br/>D<br/><br/>E<br/><br/>F<br/><br/>G<br/><br/>H<br/><br/>I<br/><br/>J<br/><br/>K<br/><br/>L<br/><br/>M</html>");
        AToM.setFont(font2); 
        contenant.add(AToM);
        
        JLabel MorseAToM = new JLabel();
        MorseAToM.setBounds((int)(width*0.09),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        MorseAToM.setText("<html>.-<br/><br/>-...<br/><br/>-.-.<br/><br/>-..<br/><br/>.<br/><br/>..-.<br/><br/>--.<br/><br/>....<br/><br/>..<br/><br/>.---<br/><br/>-.-<br/><br/>.-..<br/><br/>--</html>");
        MorseAToM.setFont(font2);
        contenant.add(MorseAToM);
        
        JLabel NToZ = new JLabel();
        NToZ.setBounds((int)(width*0.15),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        NToZ.setText("<html>N<br/><br/>O<br/><br/>P<br/><br/>Q<br/><br/>R<br/><br/>S<br/><br/>T<br/><br/>U<br/><br/>V<br/><br/>W<br/><br/>X<br/><br/>Y<br/><br/>Z</html>");
        NToZ.setFont(font2);
        contenant.add(NToZ);
        
        JLabel MorseNToZ = new JLabel();
        MorseNToZ.setBounds((int)(width*0.18),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        MorseNToZ.setText("<html>-.<br/><br/>---<br/><br/>.--.<br/><br/>--.-<br/><br/>.-.<br/><br/>...<br/><br/>-<br/><br/>..-<br/><br/>...-<br/><br/>.--<br/><br/>-..-<br/><br/>-.--<br/><br/><--..</html>");
        MorseNToZ.setFont(font2); 
        contenant.add(MorseNToZ);
        
        JLabel chiffre = new JLabel();
        chiffre.setBounds((int)(width*0.83),(int)(height*0.02), (int)(width*0.055), (int)(height*0.8));
        chiffre.setText("<html>0<br/><br/>1<br/><br/>2<br/><br/>3<br/><br/>4<br/><br/>5<br/><br/>6<br/><br/>7<br/><br/>8<br/><br/>9</html>");
        chiffre.setFont(font2);
        contenant.add(chiffre);
        
        JLabel MorseChiffre = new JLabel();
        MorseChiffre.setBounds((int)(width*0.86),(int)(height*0.02), (int)(width*0.055), (int)(height*0.8));
        MorseChiffre.setText("<html>-----<br/><br/>.----<br/><br/>..---<br/><br/>...--<br/><br/>....-<br/><br/>.....<br/><br/>-....<br/><br/>--...<br/><br/>---..<br/><br/>----.</html>");
        MorseChiffre.setFont(font2); 
        contenant.add(MorseChiffre);
        
        System.out.println(count);
        JLabel vousAvez = new JLabel();
        vousAvez.setBounds((int)(width*0.42),(int)(height*0.72),(int)(width*0.6),(int)(height*0.06));
        vousAvez.setText("Vous avez réussi " + (count) +  " niveaux.");
        vousAvez.setForeground(Color.blue);
        vousAvez.setFont(font1); 
        contenant.add(vousAvez);
}
}

