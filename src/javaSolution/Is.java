package javaSolution;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Is {
	
	static Scanner sc=new Scanner(System.in);
    static boolean[][]v;
    static boolean[][]resp;
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
       // sc=new Scanner(new File("src/TESTER.txt"));
        char []pattern=sc.nextLine().toCharArray();
        int N=sc.nextInt();
        for(int i=0;i<N;i++) {
            String mot=sc.next();
            char [] vectMot = mot.toCharArray();
            v =new boolean[vectMot.length+1][pattern.length+1];
            resp =new boolean[vectMot.length+1][pattern.length+1];
            //System.out.println("mot choisie = "+Arrays.toString(mot.toCharArray()));
            //System.out.println("pattern choisie = "+Arrays.toString(pattern));
            if(ListT(vectMot, pattern, 0, 0))   System.out.println(mot);
            //System.out.println("-----------------------------");
        }
        
        
    }
    
    
    static boolean ListT(char []mot,char []pattern,int posLettre,int posPattern) {
        //System.out.println("posActLIST (mot="+mot[posLettre]+",pattern="+pattern[posPattern]+")"+"= ("+posLettre+","+posPattern+")");
        if(v[posLettre][posPattern]==true)                      return resp[posLettre][posPattern];
        //System.out.println("posActLIST (mot="+mot[posLettre]+",pattern="+pattern[posPattern]+")"+"= ("+posLettre+","+posPattern+")");
        v[posLettre][posPattern]=true;
        if(Lettre(mot, pattern, posLettre, posPattern)) {
            if(ListT_AUX(mot,pattern,posLettre+1,posPattern+1)) {resp[posLettre][posPattern]=true;return true;}
            else            {resp[posLettre][posPattern]=false;return false;}
        }
        else if(Boucle(mot, pattern, posLettre, posPattern))    {resp[posLettre][posPattern]=true;return true;}
        else {resp[posLettre][posPattern]=false;return false;}
    }
    static boolean ListT_AUX(char []mot,char []pattern,int posLettre,int posPattern) {
        //System.out.println("posActLISTAUX (mot="+mot[posLettre-1]+",pattern="+pattern[posPattern]+")"+"= "+posLettre);
        if(posLettre==mot.length) {
            if(posPattern==pattern.length)  {/*System.out.println("SuccesL");*/return true;}
            else                            return false;
        }
        else {
            if(posPattern==pattern.length) {
                if(posLettre==mot.length)   return true;
                else                        return false;
            }
            else if(ListT(mot, pattern, posLettre, posPattern)) return true;
            else    return false;
        }
        
    }
    static boolean Lettre(char []mot,char []pattern,int posLettre,int posPattern) {
        if(pattern[posPattern]!='*') {
            //System.out.println("posActLettre (mot="+mot[posLettre]+",pattern="+pattern[posPattern]+")"+"= ("+posLettre+","+posPattern+")");
            if(mot[posLettre]==pattern[posPattern]) return true;
            else        {/*System.out.println("FauxLettre");*/return false;}
        }
        else    {/*System.out.println("FauxLettre");*/return false;}
    }
    static boolean Boucle(char []mot,char []pattern,int posLettre,int posPattern) {
        if(pattern[posPattern]=='*') {
            //System.out.println("posActBoucle (mot="+mot[posLettre]+",pattern="+pattern[posPattern]+")"+"= ("+posLettre+","+posPattern+")");
            return Boucle_AUX(mot,pattern,posLettre,posPattern);
        }
        else    {//System.out.println("FauxBoucle");
        return false;}
    }
    static boolean Boucle_AUX(char []mot,char []pattern,int posLettre,int posPattern) {
        if(posLettre==mot.length) {
            //System.out.println("posActBoucleAUX1 (mot="+mot[posLettre-1]+",pattern="+pattern[posPattern]+")"+"= "+posLettre);
            //System.out.println("FIN1");
            if(posPattern==pattern.length)  {/*System.out.println("SuccesB");*/return true;}
            else                            return false;
        }
        else {//System.out.println("posActBoucleAUX1 (mot="+mot[posLettre]+",pattern="+pattern[posPattern]+")"+"= ("+posLettre+","+posPattern+")");
            if(posPattern==pattern.length) {
                if(posLettre==mot.length)   return true;
                else                        return false;
            }
            else if(ListT_AUX(mot, pattern, posLettre+1, posPattern))   return true;
            else if(ListT_AUX(mot, pattern, posLettre, posPattern+1))   return true;
            else if(ListT_AUX(mot, pattern, posLettre+1, posPattern+1)) return true;
            else    return false;
        }
        
    }
}
