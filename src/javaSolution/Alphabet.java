package javaSolution;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alphabet {
static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        //sc=new Scanner(new File("src/TESTER.txt"));
        
        while(sc.hasNext()) {
            
            char []seq=sc.nextLine().toCharArray();
            boolean[] v= new boolean[seq.length];
            int[] valIndice= new int[seq.length];
            
            //System.out.println(Arrays.toString(seq));
            System.out.println(calc(seq, 30,valIndice,v));
        }
        
        
    }
    
    static int calc(char[] seq,int min,int []valIndice,boolean[] v) {
        boolean continuer =true;
        for(int i=0;i<seq.length && continuer;i++) {
            int x = choseDist(seq[i], i, v, valIndice, seq.length, seq);
            //System.out.println("min detecte = "+(26-x));
            //System.out.println(Arrays.toString(valIndice));
            if(26-x<min)    min=26-x;
            if(min==0) continuer=false;
        }
        return min;
        
    }
    
    static int choseDist(char src,int indiceSrc,boolean[] v,int[] valIndice,int limit,char[] seq) {
        if(v[indiceSrc]==true)  return valIndice[indiceSrc];
        v[indiceSrc]=true;
        valIndice[indiceSrc]=1;
        if(src=='z' || indiceSrc==limit-1)  {valIndice[indiceSrc]=1;return 1;}
        else {
            for(int i=indiceSrc+1;i<limit;i++) {
                if(seq[i]>src)
                    {//System.out.println("Detecte pour src=> "+src);
                    valIndice[indiceSrc]=Math.max(valIndice[indiceSrc], 1+choseDist(seq[i],i,v,valIndice,limit,seq));
                    }
            }
            return valIndice[indiceSrc];
        }
    }
}
