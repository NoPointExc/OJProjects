/*
TODO:
1) remove all zero
2) initial f0 f1
3) count to the end
 */
public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 ) return 0;

        //remove all the 0.
        StringBuilder sb=new StringBuilder();
        int i;
        for(i=0;i<s.length()-1;i++){
        	if(s.charAt(i)=='0') return 0;
        	if(s.charAt(i+1)=='0'){
        		if(s.charAt(i)!='1' && s.charAt(i)!='2') return 0;  
        		sb.append('*'); //*==42
        		i++;     		
        	}else sb.append(s.charAt(i));
        }
        
        if(i<s.length()){
        	if(s.charAt(i)=='0') return 0;
        	else sb.append(s.charAt(i));
        } 
        
        int f1=1;
        int f2=1;
        int f3;

        for(i=1;i<sb.length();i++){
			int num=(sb.charAt(i-1)-'0')*10+(sb.charAt(i)-'0');
        	f3=f2;
        	if(num>9 && num<27) f3+=f1;
        	//f3-->f2, f2-->f1
        	f1=f2;
        	f2=f3;
        }
        return f2;
    }
}