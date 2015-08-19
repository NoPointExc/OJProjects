public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        String ans="" ;
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String revStr=sb.toString();//i>12345, j>54321

        for(int i=0;i<s.length();i++){
        	StringBuilder tmp=new StringBuilder();
        	for(int j=0;j<revStr.length();j++){
        		//if @i=@j, add to tmp
        		int itmp=i, jtmp=j;
        		while( itmp<s.length()&&jtmp<revStr.length()&&s.charAt(itmp)==revStr.charAt(jtmp)) {
        			tmp.append(s.charAt(itmp)); 
        			if(tmp.length()>ans.length()) ans=tmp.toString();
        			itmp++; jtmp++;
        		}
        		//if @i!=@j, clear tmp		
        		tmp.delete(0, tmp.length());       		
        	}
        }
        return ans.toString();
    }
}