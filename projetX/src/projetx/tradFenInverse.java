package projetx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton menu;
    private JButton volume;
    private JTextField morse2;
    private JTextField francais;

    static String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-.",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----."," "};
    static String [] normal = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"," "};
    
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == fleche)
        {
            tradFenetre fenetre = new tradFenetre();
            setVisible(false);
            //tradFenetre.setVisible(true);
        }
       if(ev.getSource() == menu)
        {
            accueilFen fenetre = new accueilFen();
            setVisible(false);
        }
       if(ev.getSource() == boutonValider)
        {
            String nouvotexte = morse2.getText();
            String motEnMorse = "";
            int lettre = 0;
            String stringvalueof; 
            String[] morsec = nouvotexte.split(" ");
            for (int i = 0; i < morsec.length; i++) 
            {
                //  stringvalueof = String.valueOf(nouvotexte.charAt(lettre));
                
                for (int loop=0; loop < morse.length; loop++)
                {  
                    if (morse[loop].equalsIgnoreCase(morsec[i]))
                    {
                        motEnMorse = (motEnMorse + ((normal[loop])));
                    } 
                    if (morse[loop] == " ")
                    {
                        motEnMorse = (motEnMorse + " ");
                    }
                }
                lettre = lettre + 1;
            }
            francais.setText(motEnMorse);
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
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        morse2.setText("morse");
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

