package projetx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class tradFenInverse extends JFrame implements ActionListener
{
    private JButton boutonValider;
    private JButton fleche;
    
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == fleche)
        {
            tradFenetre fenetre = new tradFenetre();
            setVisible(false);
            //tradFenetre.setVisible(true);
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
        insertTexte.setBounds((int)(width/2-width*0.225/2),(int)(height*0.19), (int)(width*0.225), (int)(height*0.06));
        contenant.add(insertTexte);
        insertTexte.setText("↓ Entrez le texte à traduire dans la case ci-dessous ↓");
        
        JTextField français = new JTextField();
        français.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        français.setHorizontalAlignment(JTextField.CENTER);
        français.setText("morse");
        add(français);
        
        fleche = new JButton();
        File imageCheck = new File("src\\imageFleche\\arrowgood.jpg");
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
        
        JTextField morse = new JTextField();
        morse.setBounds((int)(width/2-width*0.40/2),(int)(height*0.55), (int)(width*0.40), (int)(height*0.06));
        morse.setHorizontalAlignment(JTextField.CENTER);
        morse.setText("français");
        add(morse);
        
        boutonValider = new JButton ("traduire");
        boutonValider.setBounds((int)(width/2-width*0.11/2),(int)(height*0.70),(int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonValider);

        /*
         /\
        /  \
         ||
         ||
         ||
        \  /
         \/*/
}

    
}

