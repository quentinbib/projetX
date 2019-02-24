package projetx;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class fenetre extends JFrame implements ActionListener
{
    private JLabel texte1, texte2;
    private JButton boutonTrad;
    private JButton boutonEntrainement;

   
    public void actionPerformed(ActionEvent ev)
    {
       if(ev.getSource() == boutonTrad)
        {
            System.out.println("c'est le bouton boutonTrad");
        }
       
       if(ev.getSource() == boutonEntrainement)
        {
            System.out.println("c'est le bouton boutonEntrainement");
        }                
        
    }
    public fenetre()
    {
        setTitle ("fenetrePrinc");
        setSize (1280,980);
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
        
        /*texte1 = new JLabel();
        getContentPane().add(texte1);
        texte1.setText("test");*/
        
        
          
    }     
}
