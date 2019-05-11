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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class tradFenetre extends JFrame implements ActionListener
{
    private JButton boutonValider;
    private JButton fleche;
    private JButton menu;
    private JButton volume;
    private JTextField francais;
    private JTextField morse2;
    private JButton ¤;
    // ces deux tableaux sont utiliséés plus bas pour la traduction : chaque ligne correspond à la traduction de l'autre tableau à la meme ligne
    static String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----.",""};
    static String [] normal = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"," "};
    // pour faire un sortie de son du mot taduit en morse, on crée un son court et un son long
    public static void sonCourt () throws UnsupportedAudioFileException, IOException, LineUnavailableException
       {
           //cette fonction permet de trouver, ouvrir et lancer le fichier audio
           String soundName = "src/sonVolume/sonCourt.wav";  
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
           Clip clip = AudioSystem.getClip();
           clip.open(audioInputStream);
           clip.start();
       }
    // on fait de même pour le son long
    public static void sonLong () throws UnsupportedAudioFileException, IOException, LineUnavailableException
       {
           String soundName = "src/sonVolume/sonLong.wav";    
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
           Clip clip = AudioSystem.getClip();
           clip.open(audioInputStream);
           clip.start();
       }
    // on a deux types de sons, il suffit de changer le nom de la fonction plus bas dans le programme
    public static void sonLongKim () throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        String soundName = "src/sonVolume/longKim.wav";    
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    
    public static void sonCourtKim () throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        String soundName = "src/sonVolume/courtKim.wav";    
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    // On a également un voix pour le message d'erreur, c'est le meme procédé que pour les autres sons
    public static void erreur () throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        String soundName = "src/sonVolume/entrer.wav";    
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == fleche)
        {
            tradFenInverse fenetre = new tradFenInverse();
            setVisible(false);
        }
       if(ev.getSource() == menu)   
        {
            accueilFen fenetre = new accueilFen();
            setVisible(false);
        }
       
       if(ev.getSource() == boutonValider)
        {
            // si on valide, le programme traduit le mot demandé, on prend alors le mot écrit dans la zone de texte...
            String nouvotexte = francais.getText();
            String motEnMorse = "";
            int lettre = 0; 
            int compteur = 0;
            String stringvalueof; 
            //... on traduit ensuite le mot lettre par lettre
            for (int i = 0; i < nouvotexte.length(); i++) 
            {
                // stringvalueof permet de prendre une lettre du mot
                stringvalueof = String.valueOf(nouvotexte.charAt(lettre));
                //on cherche ensuite en balayant le tableau la lettre en morse qui lui correspond
                for (int loop=0; loop < normal.length; loop++)
                {  
                    if (normal[loop].equalsIgnoreCase(stringvalueof))
                    {
                        // on ajoute ensuite la lettre en morse à la suite des précédentes
                        motEnMorse = (motEnMorse + ((" ") + (morse[loop])));
                        // le compteur est égal au nombre de caractères dans le mot si celuui-ci est constitué seulement de lettres et de chiffres
                        compteur = compteur+1;
                    }
                }
                // On passe ensuite à la lettre suivante
                lettre = lettre + 1;
            }
            //si toutes les lettres sont traduites, on affiche alors le mot en morse
            if (compteur == lettre)
            {
                // on configure : la police
                Font font2 = new Font("", Font.PLAIN, 25);
                // le mot
                morse2.setText(motEnMorse);
                // la couleur de la police
                morse2.setForeground(Color.black);
                // le fond de la zone de texte
                morse2.setFont(font2);
            }
            // si le compteur est différent du nombre de lettre, l'utilisateur a mis un caractère spécial qui ne peut être traduit en morse. On affiche alors un message d'erreur
            else
            {
                Font font1 = new Font("", Font.PLAIN, 14);
                morse2.setText("entrez_un_des_charactères_qui_figurent_sur_les_bords_de_l'écran");
                morse2.setForeground(Color.red);
                morse2.setFont(font1);
            } 
        } 
       //...
       if(ev.getSource() == ¤)
       {
           try {
               trad fenetre = new trad();
           } catch (UnsupportedAudioFileException ex) {
               Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) {
               Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
           }
           setVisible(false);
       }
       // cette partie est pour afficher le son 
       if(ev.getSource() == volume)
        {
            int count =0;
            String texteCase = morse2.getText();
            String trait = "-";
            String point = ".";
            String espace = " ";
            String erreur = "entrez_un_des_charactères_qui_figurent_sur_les_bords_de_l'écran";
            String[] arrayDeString = texteCase.split("");
            //pour chaque type de caractère, on associe un son
            for (int i = 0; i < arrayDeString.length; i++) 
            {
                // ici, si on a un trait, on émet donc un son long
                if (arrayDeString[i].equalsIgnoreCase(trait))
                {
                    try 
                    {
                        sonLong();
                    } catch (UnsupportedAudioFileException ex) 
                    {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try 
                    {
                        //cela permet de ralentir la virtual machine pour que les son ne se chevachent pas les uns sur les autres, c'est un temps de pause
			Thread.sleep(500);
		    } catch (InterruptedException e) 
                    {
			e.printStackTrace();
		    }
                }
                //si c'est un point, on émet un son court
                else if (arrayDeString[i].equalsIgnoreCase(point))
                {
                    try 
                    {
                        sonCourt();
                    } catch (UnsupportedAudioFileException ex) 
                    {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try 
                    {
                        // le son est plus court donc le temps de pause peut etre plus court
			Thread.sleep(250);
		    } catch (InterruptedException e) 
                    {
			e.printStackTrace();
		    }
                }
                //s'il n'y a rien c'est un espace, on met donc un temps de pause un peu plus long
                else if (arrayDeString[i].equalsIgnoreCase(espace))
                {
                   try 
                    {
			Thread.sleep(700);
		    } catch (InterruptedException e) 
                    {
			e.printStackTrace();
		    } 
                }
                // si il y a le message d'erreur, le count devient 1, ce qui nous redirige vers un autre if
                // on ne sait pas pourquoi, mais si l'on affiche le son directement, il ne sonne pas normalement et est incompréhensible
                else if (texteCase.equalsIgnoreCase(erreur))
                {
                    count = count+1;
                }              
            }
            // si le message d'erreur s'affiche, on l'émet en son
            if (count !=0)
            {
                try 
                {
                    erreur();
                } catch (UnsupportedAudioFileException ex) 
                {
                    Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(tradFenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      
    }
    }
    public tradFenetre() throws UnsupportedAudioFileException, IOException, LineUnavailableException
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
        insertTexte.setBounds((int)(width*0.36),(int)(height*0.19), (int)(width*0.35), (int)(height*0.06));
        contenant.add(insertTexte);
        insertTexte.setText("↓ Entrez le texte en français à traduire dans la case ci-dessous ↓");
        //...
        ¤ = new JButton ("¤");
        ¤.setBounds((int)(width*0.90),(int)(height*0.03), (int)(1),(int)(1));
        contenant.add(¤);
        ¤.addActionListener(this);
        
        // Dans un JTextField, l'utilisateur peut entrer du texte, ce texte peut ensuite etre réutilisé par le programme
        francais = new JTextField();
        francais.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        francais.setHorizontalAlignment(JTextField.CENTER);
        add(francais);
        
        // la flèche permet d'inverser le sens de traduction francais-morse, morse-francais
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
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.55), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        morse2.setText("morse");
        add(morse2);
        
        boutonValider = new JButton ("traduire");
        boutonValider.setBounds((int)(width/2-width*0.11/2),(int)(height*0.70),(int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonValider);
        boutonValider.addActionListener(this);
        
        menu = new JButton ("Menu principal");
        menu.setBounds((int)(width*0.85),(int)(height*0.80),(int)(width*0.09),(int)(height*0.04));
        contenant.add(menu);
        menu.addActionListener(this);
        
        // on appuie sur le bouton pour émettre la traduction avec des sons
        volume = new JButton();
        File imageCheck2 = new File("src\\images\\volume.jpg");
        try
        {
          Image img = ImageIO.read(imageCheck2);
          Image newImg = img.getScaledInstance((int)(width*0.04), (int)(height*0.047), img.SCALE_DEFAULT);
          volume.setIcon(new ImageIcon(newImg));
        } 
        catch (Exception ex) 
        {
          System.out.println(ex);
        }
        setResizable(true);
        volume.setBounds((int)(width/2-width*0.034/2),(int)(height*0.82), (int)(width*0.034), (int)(height*0.04));
        contenant.add(volume);
        volume.addActionListener(this);
        
        //sur les bords de l'écran, on affiche toutes les lattres et les chiffres avec leur traduction pour avoir une idée de ce que l'on veut écrire ou à quoi on peut s'attendre
        // le premier paragraphe est pour la premiere colonne de lettres
        Font font2 = new Font("", Font.PLAIN, 18);
        JLabel AToM = new JLabel();
        AToM.setBounds((int)(width*0.06),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        // cette ligne permet d'espacer les lettres et de les mettre en colonne
        AToM.setText("<html>A<br/><br/>B<br/><br/>C<br/><br/>D<br/><br/>E<br/><br/>F<br/><br/>G<br/><br/>H<br/><br/>I<br/><br/>J<br/><br/>K<br/><br/>L<br/><br/>M</html>");
        AToM.setFont(font2); 
        contenant.add(AToM);
        
        //celui ci est pour la traduction des lettre en morse
        JLabel MorseAToM = new JLabel();
        MorseAToM.setBounds((int)(width*0.09),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        MorseAToM.setText("<html>.-<br/><br/>-...<br/><br/>-.-.<br/><br/>-..<br/><br/>.<br/><br/>..-.<br/><br/>--.<br/><br/>....<br/><br/>..<br/><br/>.---<br/><br/>-.-<br/><br/>.-..<br/><br/>--</html>");
        MorseAToM.setFont(font2);
        contenant.add(MorseAToM);
        
        //deuxième colonne
        JLabel NToZ = new JLabel();
        NToZ.setBounds((int)(width*0.15),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        NToZ.setText("<html>N<br/><br/>O<br/><br/>P<br/><br/>Q<br/><br/>R<br/><br/>S<br/><br/>T<br/><br/>U<br/><br/>V<br/><br/>W<br/><br/>X<br/><br/>Y<br/><br/>Z</html>");
        NToZ.setFont(font2);
        contenant.add(NToZ);
        
        // tradution de la deuxième colonne
        JLabel MorseNToZ = new JLabel();
        MorseNToZ.setBounds((int)(width*0.18),(int)(height*0.02), (int)(width*0.055), (int)(height*0.9));
        MorseNToZ.setText("<html>-.<br/><br/>---<br/><br/>.--.<br/><br/>--.-<br/><br/>.-.<br/><br/>...<br/><br/>-<br/><br/>..-<br/><br/>...-<br/><br/>.--<br/><br/>-..-<br/><br/>-.--<br/><br/><--..</html>");
        MorseNToZ.setFont(font2); 
        contenant.add(MorseNToZ);
        
        // on fait de même pour les chiffres
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

    

