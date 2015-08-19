public class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        StringBuilder sb1=new StringBuilder("0");
        StringBuilder sb2;               
        if(len1==0||len2==0) return "";
        for(int i=len1-1;i>=0;i--){    	
        	int op1=num1.charAt(i)-48;
        	sb2=new StringBuilder("0");
        	int p=0;
        	for(int j=len2-1;j>=0;j--){
        		int op2=num2.charAt(j)-48;
        		int result=op1*op2+sb2.charAt(p)-48;
        		sb2.replace(p,p+1,String.valueOf(result%10));
        		sb2.append(result/10);
        		p++;
        	}
        	sb1=shiftAdd(sb1,sb2,len1-1-i);
        }
        return sb1.reverse().toString();
    }
    //shift and add reversed number num1 and num2, and return reversed answer 
    private StringBuilder shiftAdd(StringBuilder num1, StringBuilder num2,int offset){
    	int len1=num1.length();
    	int len2=num2.length();
    	int len=Math.max(len1,len2+offset)+1; 
    	StringBuilder sb=new StringBuilder("0");
    	int p=0;   	
    	for(int i=0;i<len;i++){	
    		int d1=0,d2=0;
    		if(i<len1) d1=num1.charAt(i)-48;
    		if(i-offset>=0 && i-offset<len2) d2=num2.charAt(i-offset)-48;
    		int dsum=d1+d2+sb.charAt(p)-48;
    		sb.replace(p,p+1,String.valueOf(dsum%10));
    		sb.append(dsum/10);
    		p++;
    	}
    	return trim(sb);
    }

    private StringBuilder trim(StringBuilder sb){
    	if(sb.length()<2) return sb;
    	while(sb.length()>1&&sb.charAt(sb.length()-1)=='0') sb=new StringBuilder(sb.substring(0,sb.length()-1));
    	return sb;
    }
}