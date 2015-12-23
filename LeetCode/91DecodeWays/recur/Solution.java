
import java.util.*;

public class Solution {
	HashMap<String,Integer> rst;
	public int numDecodings(String s) {
    	rst=new HashMap<String,Integer>();
    	if(s.length()==0 || s.equals("0")) return 0;
    	else return decode(s);
   	}    

    public int decode(String s) {
        int result=0;
        if(s.length()==0) return 1;
        else if(s.equals("0")) return 0;
        else if(s.length()==1) return 1;
        else if(rst.containsKey(s)){
        	return rst.get(s);
        }else{
        	int t=s.charAt(s.length()-1)-48;
        	int l=s.charAt(s.length()-2)-48;
        	if(l*10+t>26 || l*10+t<10){
        		if(t!=0) result= decode(s.substring(0,s.length()-1));
				else result=0;
        	}else {
        		if(t!=0){
        			result=decode(s.substring(0,s.length()-1))+decode(s.substring(0,s.length()-2));
        		}else{
        			result=decode(s.substring(0,s.length()-2));
        		}        		
        	}
        	rst.put(s,result);	
        	return result;
        } 
    }
}