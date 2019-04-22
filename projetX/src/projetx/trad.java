package projetx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class trad extends JFrame implements ActionListener
{
    private JButton ¤;
    public void actionPerformed(ActionEvent ev)
    {
        
        if(ev.getSource() == ¤)
           {
                try 
                {
                    tradFenetre fenetre = new tradFenetre();
                } catch (UnsupportedAudioFileException ex) 
                {
                    Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex)
                {
                    Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) 
                {
                     Logger.getLogger(accueilFen.class.getName()).log(Level.SEVERE, null, ex);
                }
            setVisible(false);
           }
    }
    public trad() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("trad");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font1 = new Font("", Font.PLAIN, 40);
        ¤ = new JButton ("BRAVO !");
        ¤.setBounds(0, 0 , (int)(width),(int)(height));
        ¤.setFont(font1);
        contenant.add(¤);
        ¤.addActionListener(this);
    }
    
}
