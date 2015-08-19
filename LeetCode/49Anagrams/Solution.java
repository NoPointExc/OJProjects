import java.util.*;
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res=new ArrayList<String> ();
        if(strs.length==0) return res;
        Map<String,Integer> dict=new HashMap<String,Integer>();
        for(int i=0;i<strs.length;i++){        	
        	char[] sortedArr=strs[i].toCharArray();
        	Arrays.sort(sortedArr);
        	String sortedStr=new String(sortedArr);
        	if(dict.containsKey(sortedStr)){
        		int sIndex=dict.get(sortedStr);
        		if(sIndex!=-1){
        			res.add(strs[sIndex]);
        			dict.put(sortedStr,-1);
        		}
        		res.add(strs[i]);        		
        	}else{
        		dict.put(sortedStr,i);
        	}
        }
        return res;
    }
}