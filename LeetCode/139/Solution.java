import java.util.*;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0) return true;
        int len=s.length();
        int min=len, max=0;
        for(String p:wordDict){
            if(p.length()>max) max=p.length();
            if(p.length()<min) min=p.length();
        }
        
        boolean[] match=new boolean[len];
        for(int i=0;i<len;i++){
            if(i==0||match[i]){
                for(int j=min;j<=max && i+j<=len;j++){
                    if( wordDict.contains(s.substring(i,i+j)) ){
                        if(i+j==len) return true;
                        else match[i+j]=true;
                    }
                }
            }
        }
        return false;
    }

}