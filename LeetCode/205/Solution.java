import java.util.*;
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] str=s.toCharArray();
        char[] tar=t.toCharArray();
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        
        for(int i=0;i<str.length;i++){
            if(!map.containsKey(tar[i])){
                //if(map.containsKey(tar[i])) return false;
                //map.put(str[i],tar[i]);
                map.put(tar[i],str[i]);
            }else{
                if(map.get(tar[i])!=str[i]) return false;
            }    
        }

        return true;
    }
}
