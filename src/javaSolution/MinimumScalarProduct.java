package javaSolution;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct {
	static Scanner sc=new Scanner(System.in);
    
    static long somme2(int []v1,int []v2) {
        long somme=0L;
        for(int i=0;i<v1.length;i++)    somme+=v1[v1.length-i-1]*v2[i];
        return somme;
    }
    
    public static void main(String[] args){
        // TODO Auto-generated method stub
        //sc=new Scanner(new File("src/TESTER.txt"));
        
        int T=sc.nextInt();
        //System.out.println("T = "+T);
        for(int t=0;t<T;t++) {
            
            int N=sc.nextInt();
            
            int []vect=new int[N];
            int []vect2=new int[N];
    //-------------------------------------------------------//     
            
            for(int i=0;i<N;i++) {
                //System.out.println("Tapper en vect1");
                vect[i]=sc.nextInt();
            }
    //------------------------------------------------------//      
            for(int i=0;i<N;i++) {
                vect2[i]=sc.nextInt();
            }
            Arrays.sort(vect);
            Arrays.sort(vect2);
            //System.out.println("finish = "+vect2Min1);
            long somme=0L;
            for(int i=0;i<N;i++)    somme+=(long)vect[N-i-1]*(long)vect2[i];
            
                    
            System.out.println("Case #"+(t+1)+": "+somme);
        }
        
    }
}
