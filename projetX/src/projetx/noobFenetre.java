/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Hugo
 */
public class noobFenetre extends JFrame implements ActionListener
{
     public void actionPerformed(ActionEvent ev)
     {
         
     }
public noobFenetre()
{
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) ecran.getWidth();
        int height = (int) ecran.getHeight();
        
        setTitle ("noobFenetre");
        setSize (width,height);
        setVisible (true);
        Container contenant = getContentPane();
        getContentPane().setLayout(new FlowLayout());
        contenant.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel nomPage = new JLabel();
        nomPage.setFont(new Font("Algerian", Font.PLAIN, 28));
        nomPage.setBounds((int)(width*0.25),(int)(height*0.13), (int)(width*0.50),(int)(height*0.06));
        contenant.add(nomPage);
        nomPage.setText("Traduisez les lettres et chiffres suivants en morse grâce aux touches '.' et '-'");
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("", Font.PLAIN, 25);
        morse2.setFont(font1);
        add(morse2);
}

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}