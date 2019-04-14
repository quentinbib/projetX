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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Hugo
 */

public class noobFenetre extends JFrame implements ActionListener
{
    public static BufferedReader fR;
    public static String lecture() throws IOException
    {
        String ligneFichier = fR.readLine();
        return ligneFichier;
    }
    private JButton next;
    private JButton valider;
    private JTextField morse2;
    private JTextField morse3;
    static String ligne ="";
    static String alphabetmorse[] ={ ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","..."," -","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",""};
    static String normal[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"," "};
     public void actionPerformed(ActionEvent ev)
     {
        if(ev.getSource() == valider)
        {
            for (int loop = 0; loop < 36; loop++) 
        {
            if (normal[loop].equalsIgnoreCase(ligne))
            {
              
            }
        }
        } 
     }
public noobFenetre() throws FileNotFoundException, IOException
{
    fR = new BufferedReader(new FileReader(new File("src/levels/niveau noob.txt")));
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
    int random = (int)( Math.random()*36 + 1);
    for (int i = 0; i < random; i++)
     {
         ligne = lecture();
         
     }
        
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
        nomPage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
        nomPage.setBounds((int)(width*0.20),(int)(height*0.13), (int)(width*0.95),(int)(height*0.06));
        contenant.add(nomPage);
        nomPage.setText("Traduisez les lettres et chiffres suivants en morse grâce aux touches '.' et '-'");
        
        JLabel mottrad = new JLabel();
        mottrad.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
        mottrad.setBounds((int)(width*0.50),(int)(height*0.25), (int)(width*0.58),(int)(height*0.06));
        contenant.add(mottrad);
        mottrad.setText("Le caractère " + ligne);
        
        morse2 = new JTextField();
        morse2.setBounds((int)(width/2-width*0.40/2),(int)(height*0.40), (int)(width*0.40), (int)(height*0.06));
        morse2.setHorizontalAlignment(JTextField.CENTER);
        Font font1 = new Font("", Font.PLAIN, 25);
        morse2.setFont(font1);
        add(morse2);
        
        morse3 = new JTextField();
        morse3.setBounds((int)(width/2-width*0.40/2),(int)(height*0.28), (int)(width*0.40), (int)(height*0.06));
        morse3.setHorizontalAlignment(JTextField.CENTER);
        Font font2 = new Font("", Font.PLAIN, 25);
        morse3.setFont(font1);
        add(morse3);
        
        next = new JButton ("Suivant");
        next.setBounds((int)(width/2-width*0.11/2),(int)(height*0.62), (int)(width*0.11),(int)(height*0.06));
        contenant.add(next);
        next.addActionListener(this);
}
}