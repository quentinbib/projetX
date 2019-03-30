package projetx;
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
     
    private JButton boutonTrad;
    private JButton boutonEntrainement;

   
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == boutonTrad)
        {
           try {
               tradFenetre fenetre = new tradFenetre();
           } catch (UnsupportedAudioFileException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) {
               Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
           }
            setVisible(false);
        }
       
       if(ev.getSource() == boutonEntrainement)
        {
            entrainementFenetre fenetre = new entrainementFenetre();
            setVisible(false);
        }                
        
    }
    public accueilFen()
    {
        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("fenetrePrinc");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel nomSite = new JLabel();
        nomSite.setFont(new Font("Algerian", Font.PLAIN, 28));
        nomSite.setBounds((int)(width*0.39),(int)(height*0.13), (int)(width*0.15),(int)(height*0.06));
        contenant.add(nomSite);
        nomSite.setText("El Traductor");
        
        boutonTrad = new JButton ("traducteur");
        boutonTrad.setBounds((int)(width*1/3-width*0.11),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonTrad);
        boutonTrad.addActionListener(this);

        boutonEntrainement = new JButton ("entrainement");
        boutonEntrainement.setBounds((int)(width*2/3-width*0.11/2),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonEntrainement);
        boutonEntrainement.addActionListener(this);

        JButton operator = new JButton();
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
        setResizable(true);
        operator.setBounds((int)(width*0.6),(int)(height*0.03), (int)(width*0.4), (int)(height*0.35));
        contenant.add(operator);
          
    }     
}
