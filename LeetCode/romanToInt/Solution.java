import java.util.*;

public class Solution {
    private static final int I=1,V=5,X=10,L=50, C=100,D=500,M=1000;
	private static final int[] num={I,V,X,L,C,D,M};	
    private char[] cha={'I','V','X','L','C','D','M'}; 
    private Map<Character,Integer> map=new HashMap<Character,Integer>();
    public int romanToInt(String s) {
        for(int i=0;i<7;i++) map.put(cha[i],num[i]);      
        char[] in =s.toCharArray();
        int h=0, t=in.length-1;
        int ans=0;
        for(;t>=0;t--){
        	
        	h=t-1;
			int head=0;
			int tail=map.get(in[t]);
			if(t>0) head=map.get(in[h]); 
			if(head!=0&&head<tail) {
				ans+=(tail-head);
				t=h;
			}else ans+=tail;  
			//System.out.println("t:"+t+"ans="+ans);      	
        }

        //if(t!=0) ans+=map.get(in[0]);
        return ans;
    }
}