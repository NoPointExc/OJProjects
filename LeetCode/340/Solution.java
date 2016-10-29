import java.util.*;
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
	if(s == null || k == 0){
	    return 0;
	}

	HashMap<Character, Integer> map = new HashMap<>();
	int max = 0, dist = 0;
	for(int l = 0, r = 0; r < s.length();){
	    System.out.println("dist= "+ dist + " l="+l + " r=" + r);
	    if(dist <= k){
		int tmpCount = 0;
		if(!map.containsKey(s.charAt(r))){
		    dist++;
		}else{
		    tmpCount = map.get(s.charAt(r));
		}

		map.put(s.charAt(r), tmpCount + 1);
		if(dist <= k)
		    max = Math.max(max, r - l + 1);
		r++;
	    }else{
		int tmpCount = map.get(s.charAt(l));
		if(tmpCount == 1){
		    dist--;
		    map.remove(s.charAt(l));
		}else{
		    map.put(s.charAt(l), tmpCount - 1);    
		}
		l++;
	    }
	}

	return max;
    }
    
    public static void main(String[] args){
	Solution s= new Solution();
	int rst = s.lengthOfLongestSubstringKDistinct("eceba", 2);
	System.out.println(rst);
    }
}
