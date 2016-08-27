import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        //bucket sort
        ArrayList<Integer>[] bucket=new ArrayList[nums.length+1];
        for(int i=0;i<bucket.length;i++)
            bucket[i]=new ArrayList<Integer>();
        
        for(int key:map.keySet()){
            int f=map.get(key);
            bucket[f].add(key);    
        }

        //get output 
        List<Integer> rst=new ArrayList<Integer>();
        for(int i=bucket.length-1;i>=0;i--){
            for(int num:bucket[i]){
                rst.add(num);
                if(rst.size()==k)
                    return rst;
            }
        }

        return rst;
    }
}
