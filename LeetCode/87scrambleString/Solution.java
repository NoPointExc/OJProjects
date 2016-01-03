
import java.util.*;
public class Solution {

    Map<String,Boolean> recrResults=new HashMap<String,Boolean>();
    
    public boolean isScramble(String s1, String s2) {
    	
    Map<Character,Integer> c1Map=new HashMap<Character,Integer>();
    Map<Character,Integer> c2LMap=new HashMap<Character,Integer>();
    Map<Character,Integer> c2RMap=new HashMap<Character,Integer>();

    	String key=new StringBuilder(s1).append(s2).toString();
    	boolean rst=false;
    	if(recrResults.containsKey(key)) return recrResults.get(key);
    	int len=s1.length();
    	if(!isSameContent(s1,s2)) {recrResults.put(key,false);return false;}
    	if(len<4) return true;

    	for(int i=0;i<len;i++){
    		char c1=s1.charAt(i);
    		char c2L=s2.charAt(i);
    		char c2R=s2.charAt(len-i-1);

    		//map
    		mapToHash(c1,c1Map);
    		mapToHash(c2L,c2LMap);
    		mapToHash(c2R,c2RMap);
		
    		//compare
    		if(c1Map.equals(c2LMap)){
    			boolean isLScramble = i!=len-1 && isScramble(s1.substring(0,i+1),s2.substring(0,i+1));
    			boolean isRScramble = i!=len-1 && isScramble(s1.substring(i+1,len),s2.substring(i+1,len));			
    			if(isLScramble && isRScramble) {recrResults.put(key,true);return true;}    			
    		}

    		if(c1Map.equals(c2RMap)){
    			boolean isLScramble = i!=len-1 && isScramble(s1.substring(0,i+1),s2.substring(len-i-1,len));
    			boolean isRScramble = i!=len-1 && isScramble(s1.substring(i+1,len),s2.substring(0,len-i-1));
    			if(isLScramble && isRScramble) {recrResults.put(key,true);return true;}
    		}

    	}

    	recrResults.put(key,false);
    	return false;

    }

    

    private boolean isSameContent(String s1, String s2){
		Map<Character,Integer> charMap=new HashMap<Character,Integer>();
		for(char c:s1.toCharArray())	mapToHash(c,charMap);
		for(char c:s2.toCharArray()){
			if(charMap.containsKey(c)){
				int num=charMap.get(c)-1;
				if(num==0) charMap.remove(c);
				else charMap.put(c,num);
			}else return false;
		}
		return true;
    }

    private void mapToHash(char c, Map<Character,Integer> charMap){	
		if(charMap.containsKey(c)){
			int num = charMap.get(c)+1;
			charMap.put(c,num);
		}else{
			charMap.put(c,1);    			
		}
    }

}