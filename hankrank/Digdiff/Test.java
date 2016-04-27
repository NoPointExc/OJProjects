import java.io.*;
import java.util.*;

public class Test {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */       
       getDiff(); 
    }
    
    static void getDiff(){
        Scanner in=new Scanner(System.in);
        int len=in.nextInt();
        int ll=0,lr=0;
        int [] left=new int[len];
        int [] right=new int[len];
        int k=0,p=0;
        for(int i=0;i<len;i++){            
            for(int j=0;j<len;j++){
                int cur=in.nextInt();
                
                if(i==j) {
                    ll+=cur;
                    left[k++]=cur;
                }
                if(i==len-j-1){
                 lr+=cur;
                 right[p++]=cur;
             }
            }
        }
        in.close();

       int diff=lr>ll?(lr-ll):(ll-lr);
       System.out.println(diff);
    }
}