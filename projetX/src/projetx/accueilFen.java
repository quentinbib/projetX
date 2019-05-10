package projetx;
// a chaque fois que l'on utilise un "outil" de netbeans, on doit l'importer 
import sun.applet.Main;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import javax.swing.JLabel;


public class accueilFen extends JFrame implements ActionListener
{
    // On crée les boutons en variable globale 
    private JButton boutonTrad;
    private JButton boutonEntrainement;
    

   //cette partie permet d'affecter une action à un bouton
    public void actionPerformed(ActionEvent ev)
    {
        // si on appuie sur le bouton Trad, on ouvre une nouvelle fentêtre
       if(ev.getSource() == boutonTrad)
        {
            // les try/catch permettent de prévenir des erreurs liées aux lectures de fichiers ou autre
           try {
               // la ligne suivane permet d'ouvrir une nouvelle fenêtre
               tradFenetre fenetre = new tradFenetre();
           } catch (UnsupportedAudioFileException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           }
           //cette ligne permet de rentre invisible la fenetre sur laquelle on était précédemment
           //de cette manière, il n'y a qu'une seulle fenêtre ouverte à la fois
            setVisible(false);
        }
       
       if(ev.getSource() == boutonEntrainement)
        {
            entrainementFenetre fenetre = new entrainementFenetre();
            setVisible(false);
        }                
    }
    // Dans la partie suivante, on configure le coté visuel du programme soit tout ce qui se situe sur la fenetre(boutons,zones de textes...)
    public accueilFen()
    {
        // On prend les mesures de l'écran...
        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        //... et on les insère dans un int
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        //on définit le nom de la fenetre
        setTitle ("fenetrePrinc");
        //on définit les dimensions de la fentêtre
        setSize (width,height);
        //la fenêtre devient visible
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Un Jlabel permet d'afficher un texte
        JLabel nomSite = new JLabel();
        // on détermine la police "algerian"
        nomSite.setFont(new Font("Algerian", Font.PLAIN, 28));
        // on définit les dimensions de la zone de texte (position largeur/hauteur et taille largeur/hauteur)
        nomSite.setBounds((int)(width*0.39),(int)(height*0.13), (int)(width*0.15),(int)(height*0.06));
        //on ajoute le jlabel sur la page
        contenant.add(nomSite);
        //on insère le texte dans le JLabel
        nomSite.setText("El Traductor");
        
        // Un JButton permet, si l'on clique dessus, d'effectuer une action. Ici on configure d'abord le texte sur le bouton,
        boutonTrad = new JButton ("traducteur");
        // ensuite sa position et ses dimensions (de même que le JTextField),
        boutonTrad.setBounds((int)(width*1/3-width*0.11),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        // on l'ajoute sur la page,
        contenant.add(boutonTrad);
        // puis on le rend actif (s'actionne quand on clique dessus)
        boutonTrad.addActionListener(this);

        boutonEntrainement = new JButton ("entrainement");
        boutonEntrainement.setBounds((int)(width*2/3-width*0.11/2),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonEntrainement);
        boutonEntrainement.addActionListener(this);

        // Ici, on a également un bouton mais avec une image dessus
        JButton operator = new JButton();
        // On cherche alors la source du fichier pour l'afficher sur le bonton
        File imageCheck = new File("src\\images\\telegraphOperator.jpg");
        try
        {
          Image img = ImageIO.read(imageCheck);
          Image newImg = img.getScaledInstance((int)(width*0.4), (int)(height*0.35), img.SCALE_DEFAULT);
          operator.setIcon(new ImageIcon(newImg));
        } 
        catch (Exception ex) 
        {
          System.out.println(ex);
        }
        // les autres démarches sont ensuite les mêmes
        setResizable(true);
        operator.setBounds((int)(width*0.6),(int)(height*0.03), (int)(width*0.4), (int)(height*0.35));
        contenant.add(operator);
          
    }     
}
