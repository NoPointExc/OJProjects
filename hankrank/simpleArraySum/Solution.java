import java.io.*;
import java.util.*;
public class Solution {
    private static HashSet<Integer> set=new HashSet<Integer>();
    private static HashSet<Integer> record=new HashSet<Integer>();
    static int n=0;
    static int k=0;
    static int count=0;
    public static void main(String args[] ) throws Exception {
        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
          
        for(int i=0;i<n;i++) set.add(scanner.nextInt());    
        for(int i:set){
            System.out.println("@"+i);
            searchPair(i);
        }    
        System.out.println(count);
    }
    
    private static void searchPair(int i){
        if(i>Integer.MAX_VALUE-k){
             if(set.contains(i-k) && !record.contains(i-k)){
                count++;
                record.add(i-k);
            }           
        }else if(i<Integer.MIN_VALUE+k){
            if(set.contains(i+k)&& !record.contains(i)){
                count++;
                record.add(i);
            }
        }else{
            if(set.contains(i+k)&& !record.contains(i)){
                count++;
                record.add(i);
            }
            if(set.contains(i-k) && !record.contains(i-k)){
                count++;
                record.add(i-k);
            }
        }
    }
}