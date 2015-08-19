public class Solution {
    public boolean isMatch(String s, String p) {
    if(s.length()>p.length()) return false;
        return isMatch(s, 0, p,0);
    }

    // aab,.***ab
    public boolean isMatch(String s, int i, String p, int j){
    	//if(i==s.length()&&j==p.length()) return true;
    	System.out.println("i="+i+"  j="+j);

    	if(i==s.length()){
    		if(j==p.length()) return true;
    		if(p.charAt(j)=='*') return isMatch(s,i,p,j+1); 
    		return false;
    	}

    	if(j==p.length()) return false;
    	//not equal
    	if(s.charAt(i)!=p.charAt(j)&& p.charAt(j)!='.'){

    		if(p.charAt(j)=='*'&&j>0&&( p.charAt(j-1)==s.charAt(i) || p.charAt(j-1)=='.') ){ //else if && if
    			if(isMatch(s,i+1,p,j+1)) return true;
    		}


    		if(j+1<p.length()&&   (p.charAt(j+1)=='*' || p.charAt(j)=='*') ){
    			return isMatch(s,i,p,j+1);
    		}


    		
    		return false;
    	}
    	return isMatch(s,i+1,p,j+1);
    }
}