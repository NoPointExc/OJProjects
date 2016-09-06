import java.util.*;

class Solution {
	//private static final int I=1,V=5,X=10,L=50, C=100,D=500,M=1000;		
	
	private static final HashMap<Character,Integer> MAP;
	static{
		char[] ch = {'I','V','X','L','C','D','M'};
		int[] num = {1,5,10,50,100,500,1000};
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<ch.length;i++){
			map.put(ch[i],num[i]);
		}
		MAP = map;
	}
	
	public int romanToInt(String s) {
		if(s.length()==0)
			return 0;
		int val = 0;
		char[] str = s.toCharArray();	
		int r=str.length-1;
		while(r>=0){
			if(r==0){
				val += MAP.get(str[r]);
				break;
			}else{
				int l = r-1;
				if(MAP.get(str[l])<MAP.get(str[r])){
					val += MAP.get(str[r])-MAP.get(str[l]);
					r-=2;
				}else{
					val += MAP.get(str[r]);
					r-=1;
				}
			}
		}

		return val;
	}
}

