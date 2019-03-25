package projetx;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
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
        
        JLabel nomSite = new JLabel();
        nomSite.setFont(new Font("Algerian", Font.PLAIN, 28));
        nomSite.setBounds((int)(width/2-width*0.17/2),(int)(height*0.13), (int)(width*0.15),(int)(height*0.06));
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

          
    }     
}
