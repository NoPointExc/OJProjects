import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>n)
            return new LinkedList<List<Integer>>();
        List<List<Integer>>[][] dp = new List[k+1][n+1];
        //init 0 line and 0 col
        for(int i=0;i<=n;i++)
            dp[0][i] = new LinkedList<List<Integer>>();
        for(int i=1;i<=k;i++)
            dp[i][0] = new LinkedList<List<Integer>>();

        //fill up do table
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                for(int head=i;head>n-head && head<=9;head++){
                    List<List<Integer>> lastRst = dp[i-1][n-head];
                    List<List<Integer>> tmp = addHead(head,lastRst);
                    dp[i][j].addAll(tmp);
                }
            }
        }

        return dp[k][n]; 
    }

    private List<List<Integer>> addHead(int head,List<List<Integer>> lastRst){
        List<List<Integer>> rst = new LinkedList<List<Integer>>();

        for(List<Integer> l:lastRst){
            if(l.get(0)<head){
                ArrayList<Integer> tmp = new ArrayList<Integer>(l);
                tmp.add(head);
                rst.add(tmp); 
            }
        }

        return rst;
    }
}
