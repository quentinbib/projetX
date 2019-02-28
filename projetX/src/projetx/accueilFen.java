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


public class accueilFen extends JFrame implements ActionListener
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
        
        
        boutonTrad = new JButton ("traducteur");
        boutonTrad.setBounds((int)(width*0.27),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonTrad);
        boutonTrad.addActionListener(this);
        
        boutonEntrainement = new JButton ("entrainement");
        boutonEntrainement.setBounds((int)(width*0.57),(int)(height*0.52), (int)(width*0.11),(int)(height*0.06));
        contenant.add(boutonEntrainement);
        boutonEntrainement.addActionListener(this);
        
        JLabel nomSite = new JLabel();
        nomSite.setBounds((int)(width*0.46),(int)(height*0.13), (int)(width*0.11),(int)(height*0.06));
        contenant.add(nomSite);
        nomSite.setText("Ta mere");
        
        
          
    }     
}
