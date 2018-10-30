package javaSolution;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodicStrings {
	
	static Scanner sc=new Scanner(System.in);
    
    static boolean period(String mot,char[] seq,List<String> sauvg,int posi,int taille) {
        boolean continuer = true;
        //System.out.println("posiRe ="+(taille*posi));System.out.println("posiFin ="+(taille*(posi+1)-1));
        if(posi>=taille) {
            //System.out.println("Depass");
            //System.out.println("mot Depass= "+mot.substring(taille*posi, taille*(posi+1)));
            //System.out.println("mot2= "+sauvg.get(posi%taille));
            if(mot.substring(taille*posi, taille*(posi+1)).equals(sauvg.get(posi%taille))) continuer =true;
            else    continuer =false;
        }
        else {
            //System.out.println("HH");
            for(int k=taille*posi;k<taille*(posi+1) && continuer;k++) {
                if(seq[k]!=seq[(k-1)%(taille)+taille*(posi-1)]) continuer = false;
            }
            if(continuer==true) sauvg.add(mot.substring(taille*posi, taille*(posi+1)));
        }
        
        return continuer;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        // TODO Auto-generated method stub
        //sc=new Scanner(new File("src/TESTER.txt"));
        
        String mot = sc.next();
        List<String> sauvg=new ArrayList<String>();
        char[] seq = mot.toCharArray();
        boolean continuer = false,continuer2=true;
        int i,choix=-1;
        for(i=1;i<=seq.length/2 && continuer==false;i++) {
            if(seq.length%i==0) {
                sauvg.add(mot.substring(0, i));
                //System.out.println("taille = "+i);
                //System.out.println("mot = "+mot.substring(0, i));
                continuer2=true;
                for(int j=1;j<seq.length/i && continuer2;j++) {
                    continuer2 = period(mot,seq,sauvg,j,i);
                }
                continuer=continuer2;
                choix=i;
            }
            sauvg.clear();
        }
        if(continuer==false)    System.out.println(seq.length);
        else                    System.out.println(choix);
    }
}
