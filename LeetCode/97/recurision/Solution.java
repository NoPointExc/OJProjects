import java.util.*;
public class Solution {
	HashMap<String[],Boolean> cacheMap = new HashMap<String[],Boolean>();

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean rst=false;
        String[] key0={s1,s2,s3};
        //String[] key1={s1,s2,s3};
        if(cacheMap.containsKey(key0)) return cacheMap.get(key0);
        //if(cacheMap.containsKey(key1)) return cacheMap.get(key1);
        if(s1.length()+s2.length()!=s3.length()) rst= false;
        else if(s3.length()==0) rst= true;        	
        else if(s1.length()==0) rst= s2.equals(s3);
        else if(s2.length()==0) rst= s1.equals(s3);
        else if(s1.charAt(0)==s2.charAt(0)){
        	if(s3.charAt(0)!=s1.charAt(0)) rst=false;
        	else rst= isInterleave(s1.substring(1),s2,s3.substring(1)) || isInterleave(s1,s2.substring(1),s3.substring(1));  
        }else{
        	if(s1.charAt(0)==s3.charAt(0)) rst= isInterleave(s1.substring(1),s2,s3.substring(1));
        	else if(s2.charAt(0)==s3.charAt(0)) rst= isInterleave(s1,s2.substring(1),s3.substring(1));
        }
        cacheUp(key0,rst);
        return rst;
    }

    private void cacheUp(String[] key0,boolean isInterleave){	
        cacheMap.put(key0,isInterleave);
        //cacheMap.put(key1,isInterleave);
    }

}