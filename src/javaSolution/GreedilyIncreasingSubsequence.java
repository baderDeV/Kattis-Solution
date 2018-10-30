package javaSolution;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GreedilyIncreasingSubsequence {
	static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
       // sc=new Scanner(new File("src/TESTER.txt"));
        
        int N=sc.nextInt();
        
        int a=sc.nextInt();
        int temp=a,index=0;
        int [] v = new int[N];
        v[index++]=temp;
        boolean continuer =true;
        
        for(int i=1;i<N && continuer;i++) {
            if(a==N)    continuer =false;
            else {
                a=sc.nextInt();
                if(a>temp) {
                    temp=a;
                    v[index++]=temp;
                }
            }
            
        }
        System.out.println(index);
        for(int i=0;i<index;i++)        System.out.println(v[i]+" ");
    }
}
