public class Solution {
    public boolean isMatch(String s, String p) {
    	int i=s.length()-1,j=p.length()-1;

    	System.out.println("s="+s+"  ;p="+p+"  ;i="+i+"  ;j="+j);
    	// no * or .
    	if(!p.contains("*")&& !p.contains(".")) return s.equals(p);
    	
    	if(i==-1 ){
    		if(j>0&& p.charAt(j)=='*') return isMatch(s,p.substring(0, j-1));
    		else return false;
    	}
    	//contain . or *
    	// . 
    	if(p.charAt(j)=='.'|| p.charAt(j)==s.charAt(i) ) return isMatch(s.substring(0,i), p.substring(0,j));
    	//*
    	if(p.charAt(j)=='*'){
    		//*==preceding
    		if(j>0 && (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i)) && isMatch(s.substring(0, i),p.substring(0, j)  )  )
    			return true;
    		//*==zero
    		if(j>0 &&  isMatch(s, p.substring(0, j-1) ) ) return true;
    	}


    	return false;
    }
}