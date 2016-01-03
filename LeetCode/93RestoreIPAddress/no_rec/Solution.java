import java.util.*;
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        //int h,m,t;
        int len=s.length();
        List<String> ipLst=new LinkedList<String>();
        for(int h=0;h<3 && h<len-3;h++){
        	for(int t=len-2;t>len-5 && t>h+1;t--){
        		for(int m=(h+1)>(t-3)?(h+1):(t-3); m<t  && m-h<4;m++){
        			if(isValid(s,h,m,t)){
        				String ip=addDot(s,h,m,t);
        				ipLst.add(ip);	
        			}        			
        		}
        	}
        }
        return ipLst;
    }


    private boolean isValid(String subIP){
    	int len=subIP.length();
    	if(len==1) return true;
    	if(subIP.charAt(0)=='0') return false;
    	if(Integer.valueOf(subIP)>255) return false;
    	return true;
    }
    //sub0,sub1,sub2,sub3;
    private boolean isValid(String s,int h,int m,int t){
    	String[] subIP=new String[4];
    	subIP[0]=s.substring(0,h+1);
    	subIP[1]=s.substring(h+1,m+1);
    	subIP[2]=s.substring(m+1,t+1);
    	subIP[3]=s.substring(t+1,s.length());
    	for(int i=0;i<4;i++){
    		if(!isValid(subIP[i])) return false;
    	}
    	return true;
    }
    private String addDot(String s,int h,int m,int t){
    	StringBuffer sb=new StringBuffer(s);
    	sb.insert(h+1,'.');
    	sb.insert(m+2,'.');
    	sb.insert(t+3,'.');
    	return sb.toString();
    }


}