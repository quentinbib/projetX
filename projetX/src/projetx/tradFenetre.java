package projetx;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

public class tradFenetre extends JFrame
{
    private JButton boutonValider;
    
    public tradFenetre()
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
        
        
        boutonValider = new JButton ("traduire");
        boutonValider.setBounds((int)(width*0.443),(int)(height*0.45),(int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonValider);
        
        JLabel traduire = new JLabel();
        traduire.setBounds((int)(width*0.47),(int)(height*0.10), (int)(width*0.11), (int)(height*0.06));
        contenant.add(traduire);
        traduire.setText("traducteur");

        JTextField français = new JTextField();
        français.setBounds((int)(width*0.29),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        français.setHorizontalAlignment(JTextField.CENTER);
        français.setText("français");
        add(français);
        
        JLabel insertTexte = new JLabel();
        insertTexte.setBounds((int)(width*0.39),(int)(height*0.19), (int)(width*0.37), (int)(height*0.06));
        contenant.add(insertTexte);
        insertTexte.setText("↓ Entrez le texte à traduire dans la case ci-dessous ↓");
        
        JButton button = new JButton();
        File imageCheck = new File("C:\\Users\\BERNARD\\Documents\\NetBeansProjects\\projetX\\projetX\\src\\imageFleche\\arrowgood.jpg");
        try{
          Image img = ImageIO.read(imageCheck);
          Image newImg = img.getScaledInstance((int)(width*0.03), (int)(height*0.09), img.SCALE_DEFAULT);
          button.setIcon(new ImageIcon(newImg));
        } catch (Exception ex) {
          System.out.println(ex);
        }
        setResizable(true);
        button.setBounds((int)(width*0.47),(int)(height*0.53), (int)(width*0.03), (int)(height*0.09));
        contenant.add(button);
        
        
        
        

  

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
