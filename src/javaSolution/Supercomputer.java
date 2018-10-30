package javaSolution;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Supercomputer {
static Scanner sc=new Scanner(System.in);
    
    static long somme(int []bit,int l,int r) {
        long s=0;
        for(int i=l;i<=r;i++)   s+=(long)bit[i];
        return s;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        //sc=new Scanner(new File("src/TESTER.txt"));
        
        int N=sc.nextInt(),K=sc.nextInt(),ele1,ele2;
        //List<Integer> bit = new ArrayList<Integer>(N);
        int []bit = new int[N];
        int []interv = new int[N];
        
        for(int j=0;j<K;j++) {
            char lettre=sc.next().charAt(0);
            ele1=sc.nextInt();
       
            if(lettre=='F') {
                if(bit[ele1-1]==0) {
                    bit[ele1-1]=1;
                    for(int i=ele1-1;i<N;i++)   interv[i]++;
                }
                else {
                    bit[ele1-1]=0;
                    for(int i=ele1-1;i<N;i++)   interv[i]--;
                }
            }
            else {
                ele2=sc.nextInt();
                int val2=0;
                if(ele1-2>=0)   val2=interv[ele1-2];
                
                System.out.println(interv[ele2-1]-val2);
            }
            
        }
        
        
        
    }
}
