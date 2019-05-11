package projetx;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class tradFenInverse extends JFrame implements ActionListener
{
    private JButton boutonValider;
    private JButton fleche;
    private JButton menu;
    private JTextField morse2;
    private JTextField francais;

    static String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----.",""};
    static String [] normal = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"," "};
    
    public void actionPerformed(ActionEvent ev)
    {
        // on remet la fleche sur cette page, de façon à ce qu'on puisse changer de mode de traduction autant qu'on veut
       if(ev.getSource() == fleche)
        {
           try 
           {
               tradFenetre fenetre = new tradFenetre();
           } catch (UnsupportedAudioFileException ex) 
           {
               Logger.getLogger(tradFenInverse.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) 
           {
               Logger.getLogger(tradFenInverse.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) 
           
           {
               Logger.getLogger(tradFenInverse.class.getName()).log(Level.SEVERE, null, ex);
           }
            setVisible(false);
        }
       if(ev.getSource() == menu)
        {
            accueilFen fenetre = new accueilFen();
            setVisible(false);
        }
       if(ev.getSource() == boutonValider)
        {
            //ici, la traduction est la même, on inverse juste les noms des tableaux car on traduit dans le sens inverse
            String nouvotexte = morse2.getText();
            String motEnMorse = "";
            int lettre = 0; 
            int compteur = 0;
            String[] morsec = nouvotexte.split(" ");
            for (int i = 0; i < morsec.length; i++) 
            {
                for (int loop=0; loop < morse.length; loop++)
                {  
                    if (morse[loop].equalsIgnoreCase(morsec[i]))
                    {
                        motEnMorse = (motEnMorse + ((normal[loop])));
                        compteur = compteur+1;
                    }
                }
                lettre = lettre + 1;
            }
            francais.setText(motEnMorse);
            francais.setForeground(Color.black);
            if (compteur == lettre)
            {
                
            }
            else
            {
                Font font1 = new Font("", Font.PLAIN, 14);
                francais.setText("Entrez soit: un trait, un point, un espace");
                francais.setForeground(Color.red);
                francais.setFont(font1);
            }
        }
    }
    
    public tradFenInverse()
    {
        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("tradFenetre1");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel traduire = new JLabel();
        traduire.setBounds((int)(width/2-width*0.055/2),(int)(height*0.10), (int)(width*0.055), (int)(height*0.06));
        contenant.add(traduire);
        traduire.setText("traducteur");
        
        JLabel insertTexte = new JLabel();
        insertTexte.setBounds((int)(width*0.365),(int)(height*0.19), (int)(width*0.35), (int)(height*0.06));
        contenant.add(insertTexte);
        insertTexte.setText("↓ Entrez le texte en morse à traduire dans la case ci-dessous ↓");
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("", Font.PLAIN, 25);
        morse2.setFont(font1);
        add(morse2);
        
        
        fleche = new JButton();
        File imageCheck = new File("src\\images\\arrowgood.jpg");
        try
        {
          Image img = ImageIO.read(imageCheck);
          Image newImg = img.getScaledInstance((int)(width*0.03), (int)(height*0.09), img.SCALE_DEFAULT);
          fleche.setIcon(new ImageIcon(newImg));
        } 
        catch (Exception ex) 
        {
          System.out.println(ex);
        }
        setResizable(true);
        fleche.setBounds((int)(width/2-width*0.03/2),(int)(height*0.40), (int)(width*0.03), (int)(height*0.09));
        contenant.add(fleche);
        fleche.addActionListener(this);
                
        francais = new JTextField();
        francais.setBounds((int)(width/2-width*0.40/2),(int)(height*0.55), (int)(width*0.40), (int)(height*0.06));
        francais.setHorizontalAlignment(JTextField.CENTER);
        francais.setText("français");
        add(francais);
        
        boutonValider = new JButton ("traduire");
        boutonValider.setBounds((int)(width/2-width*0.11/2),(int)(height*0.70),(int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonValider);
        boutonValider.addActionListener(this);

        menu = new JButton ("Menu principal");
        menu.setBounds((int)(width*0.85),(int)(height*0.80),(int)(width*0.09),(int)(height*0.04));
        contenant.add(menu);
        menu.addActionListener(this);

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
}

    
}

