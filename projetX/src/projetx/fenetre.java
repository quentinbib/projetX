package projetx;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class fenetre extends JFrame implements ActionListener
{
     
    private JButton boutonTrad;
    private JButton boutonEntrainement;

   
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == boutonTrad)
        {
            System.out.println("c'est le bouton boutonTrad");
            tradFenetre fenetre = new tradFenetre();
            setVisible(false);
        }
       
       if(ev.getSource() == boutonEntrainement)
        {
            System.out.println("c'est le bouton boutonEntrainement");
        }                
        
    }
    public fenetre()
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
        
        
        boutonTrad = new JButton ("traducteur");
        boutonTrad.setBounds(340, 400, 150, 50);
        contenant.add(boutonTrad);
        boutonTrad.addActionListener(this);
        
        boutonEntrainement = new JButton ("entrainement");
        boutonEntrainement.setBounds(740, 400, 150, 50);
        contenant.add(boutonEntrainement);
        boutonEntrainement.addActionListener(this);
        
        JLabel texte1 = new JLabel();
        texte1.setBounds(940, 400, 150, 50);
        contenant.add(texte1);
        texte1.setText("Ta mere");
        
        
          
    }     
}
