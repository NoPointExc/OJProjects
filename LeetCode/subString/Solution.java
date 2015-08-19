public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length()>p.length()) return false;
        if(s.length()==0) return true;
        for(int i=0;i<s.length();i++){
          	for(int j=0;j<p.length();j++){
          		int k=0;	
          		while(check(s,i,p,j)){
          			k++;
          			if(k==s.length()-1) return true;
          		}
        	}
        }
        return false;
    }

    private boolean check(String s, int i,  String p,int j){
    	if( j<0) return false;
    	else if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') return true;
    	else if(p.charAt(j)=='*') return check(s,i,p,j-1);
    	else return false;
    }
}