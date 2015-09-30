import java.util.*;

public class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        System.out.println("["+n+","+k+"]");
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(k==1){
            for(int i=1;i<=n;i++) {
              List<Integer> tmp=new ArrayList<Integer>();
              tmp.add(i);
              ans.add(tmp);
            }
            return ans;
        }
        if(n>k){
            ans=combine(n-1,k);
        }
        if(k>1){     
           List<List<Integer>> tmp=combine(n-1,k-1);
           Iterator<List<Integer>> it=tmp.iterator();
           while(it.hasNext()){
                   List<Integer> ls=it.next();
                   ls.add(n);
                   ans.add(ls);
           }
       }

        return ans;
    }


}