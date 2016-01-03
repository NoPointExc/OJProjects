/*
abc____
a,l2
ab,l1
abc,l0
 */
import java.util.*;
public class Solution {
    public HashMap<String,Integer> map=new HashMap<String,Integer>();
    public List<String> restoreIpAddresses(String s) {
        
        int len=s.length();

        //len>=4
     	List<String>  l0=new LinkedList<String>();
     	List<String>  l1=new LinkedList<String>();
     	List<String>  l2=new LinkedList<String>();
     	if(len==0) return l0;
     	l0.add(s.substring(len));//d
     	if(len==1) return l0;
     	addStrToList(s.substring(len-2,len-1),l0,l1); //c.l0     	
     	l1.add(s.substring(len-2,len));//cd
     	if(len==2) return l1;
     	addStrToList(s.substring(len-3,len-2),l1,l2);//b.l1
     	addStrToList(s.substring(len-3,len-1),l1,l2);//bc.l0
     	int subIP=toIntIP(s.substring(len-3)); 
     	if(subIP<256) l2.add(s.substring(len-3)); //bcd

        //List<String> rst=new LinkedList<String>();
     	for(int i=len-4;i>=0;i--){
     		List<String> l2_Next=new LinkedList<String>();
     		addStrToList(s.substring(i,i+1),l2,l2_Next);
     		addStrToList(s.substring(i,i+2),l1,l2_Next);
     		int tmpIP=toIntIP(s.substring(i,i+3));
     		if(tmpIP<256) addStrToList(s.substring(i,i+3),l0,l2_Next);
     		l0=l1;
     		l1=l2;
     		l2=l2_Next;

     	}
        
        
     	return l2;
    }
    //1.1.1.1
    private void addStrToList(String c,List<String> from,List<String> to){
        for(String str:from){
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            sb.append('.');
            sb.append(str);
            to.add(sb.toString());     
    	}
 
    }
    private int toIntIP(String str){
    	int ip=0;
    	for(char c:str.toCharArray()){
    		ip=ip*10+c-'a';
    	}
    	return ip;
    }
}