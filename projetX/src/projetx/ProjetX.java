package projetx;

import java.util.Scanner;

/**
 *
 * @author QUENTIN
 * & HUGO LE BG
 */
public class ProjetX 
{
    static Scanner input = new Scanner (System.in);
    static String [] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-.",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    static String [] normal = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    static  void presentation()
    {
       for (int loopp = 0; loopp < morse.length; loopp++) 
        {
            System.out.println("la lettre "+normal[loopp]+" s'écrit "+morse[loopp]+" en morse");
        } 
    }
    /////////////////////////////////////////////////////////////////////////
    static void tradnormalmorselettre()
    {
        System.out.println("entrer la lettre à traduire");
        String lettre = input.nextLine();
        for (int loop=0; loop < morse.length; loop++)
         {
            if (normal[loop].equalsIgnoreCase(lettre))
            {
                System.out.println("En morse, la lettre "+normal[loop]+" s'écrit : "+morse[loop]);
            }
         }
    }
    static void tradnormalmorsemot()
    {
        
        System.out.println("entrez le mot à traduire");
        String mot = input.nextLine();
        int lettre = 0;
        String stringvalueof; 
        System.out.print("En morse, le mot "+ mot +" s'écrit : ");
        for (int i = 0; i < mot.length(); i++) 
        {
            stringvalueof = String.valueOf(mot.charAt(lettre));
            for (int loop=0; loop < morse.length; loop++)
            {  
                if (normal[loop].equalsIgnoreCase(stringvalueof))
                {
                    System.out.print(morse[loop]);
                } 
            }
            lettre = lettre + 1;
        }
    }
    public static void main(String[] args) 
    {
        accueilFen fen = new accueilFen();
        /*tradFenetre fen = new fenetre();*/
    }
    
}
