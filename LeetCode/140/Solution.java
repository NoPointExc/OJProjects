import java.util.*;

public class Solution {
	private Set<String> wordDict;
    private int max,min;
    private HashMap<String,List<String>> cache=new HashMap();

    public List<String> wordBreak(String s, Set<String> wordDict) {
    	if(s==null) return null;
    	
    	this.wordDict=wordDict;
    	min=s.length();
    	max=0;
    	for(String str:wordDict){
    		if(str.length()<min) min=str.length();
    		if(str.length()>max) max=str.length();
    	}

    	//System.out.println("max="+max+"min="+min);
    	return wordBreak(s);
    }

    private List<String> wordBreak(String s){
    	//System.out.println("wordBreak s="+s);
    	if(cache.containsKey(s)){
    		return cache.get(s);
    	}

    	List<String> rst=new ArrayList<String>();
    	if(s.length()==0) return rst;

    	for(int i=min;i<=max && i<=s.length();i++){
    		String sub=s.substring(0,i);
    		if( wordDict.contains(sub) ){
    			if(i==s.length() ){
    				rst.add(sub);
    			}else{	    			
					List<String> tmp=wordBreak(s.substring(i,s.length()));
	    			for(String str:tmp){
	    				rst.add(sub+" "+str);
	    			}   	
    			} 			
    		}
    	}

    	cache.put(s,rst);
    	return rst;
    }


}