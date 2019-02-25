package projetx;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        boutonValider.setBounds(340, 400, 150, 50);
        contenant.add(boutonValider);
       
        
       
    
}

    
}
