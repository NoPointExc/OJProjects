import java.util.*;

class Test{
    public static void main(String[] args){
        Solution s=new Solution();
        int k=3;
        int n=7;
        List<List<Integer>> rst=s.combinationSum3(k,n);
        if(rst==null){
            System.out.println("null");
            return;
        }
        for(List<Integer> lst:rst){
            for(int i:lst){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
