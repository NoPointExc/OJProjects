import java.util.*;
public class Solution {
    public String minWindow(String s, String t) {
    	int head=0, tail=-1;
    	int count=t.length();
    	int minLen=Integer.MAX_VALUE;
    	int index=0;
    	Map<Character, Integer> tMap=new HashMap<Character,Integer>();

    	for(int i=0;i<t.length();i++){
    		if(tMap.get(t.charAt(i))==null) tMap.put(t.charAt(i),0);
    		tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
    	}
    	
    	while(head<s.length() && tail<s.length()){
    		
    		if(count>0){
    		//push tail 
    			if(tail>=s.length()-1) break;  
    			tail++;
    			if(tMap.get(s.charAt(tail))!=null){
    				if(tMap.get(s.charAt(tail))>0) count--;
    				tMap.put(s.charAt(tail),tMap.get(s.charAt(tail))-1);
    			}
    			
    		}else{	
    			//push head
    			if(minLen>(tail-head)){
    				minLen=tail-head;
    				index=head;
    			}
    			if(tMap.get(s.charAt(head))!=null){
    				tMap.put(s.charAt(head), tMap.get(s.charAt(head))+1); //1?
    				if(tMap.get(s.charAt(head))>0)count++;
    			}
    			head++;
    		}

    		//System.out.println("head="+head+"  tail="+tail+" count"+count+" minLen="+minLen);
    	}

    	//System.out.println("index="+index+" minLen="+minLen);
    	if(minLen>s.length()) return "";
    	return s.substring(index,index+minLen+1);
    }
}