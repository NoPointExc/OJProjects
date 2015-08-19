import java.util.*;
public class Solution {
    public String countAndSay(int n) {
    	String ans="1";
    	for(int i=1;i<n;i++){
    		ans=covert(ans);
    	}
    	return ans;
    }
    
    public String covert(String n){
    	Stack<Character> rmStack=new Stack<Character>();
        Stack<Integer> ctStack=new Stack<Integer>();
        StringBuilder sb=new StringBuilder();
        char rm='.';
        int cout=0;
        while(!n.equals("")){
        	if(n.charAt(n.length()-1)==rm){
        		cout++;
        	}else{
        		rmStack.push(rm);
        		ctStack.push(cout);
        		rm='.';
        		cout=1;
        	}
        	rm=n.charAt(n.length()-1);
        	n=n.substring(0,n.length()-1);
        }
        rmStack.push(rm);
        ctStack.push(cout);
        while(rmStack.peek()!='.'){
        	char rmTmp=rmStack.pop();
        	int ctTmp=ctStack.pop();
        	sb.append(ctTmp);
        	sb.append(rmTmp);
        }
    	return sb.toString();
    }

}