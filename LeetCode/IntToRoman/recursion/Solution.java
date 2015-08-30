public class Solution {
    private static final int I=1,V=5,X=10,L=50, C=100,D=500,M=1000;
    private static final String[] cha={"I","V","X","L","C","D","M"};
    private static final int[] map={I,V,X,L,C,D,M};
    public String intToRoman(int num) {
    	//System.out.println(num);
    	if(num==0) return "";
    	int prm=0, sec=0;
   		for(int i=0;i<cha.length;i++){
   			//System.out.println(prm);
   			if((map[prm]-map[sec])>=num) break;
   			prm++;
   			if((map[sec+2])<map[prm]) sec+=2;		
   		}
   		//back track
   		if((map[prm]-map[sec])==num) return cha[sec]+cha[prm];   		
   		prm--;
	   	if(map[sec]>map[prm]) sec--;
   		
   		StringBuilder sb=new StringBuilder();
   		if(num<map[prm]){
   			sb.append(cha[sec]);
   			sb.append(cha[prm]);
   			int left=num-(map[prm]-map[sec]);
   			sb.append(intToRoman(left));
   		}else if(num<(map[prm]+map[sec])){
   			sb.append(cha[prm]);
   			int left=num-map[prm];
   			sb.append(intToRoman(left));
   		}else{
   			sb.append(cha[prm]);
   			sb.append(cha[sec]);
   			int left=num-(map[prm]+map[sec]);
   			sb.append(intToRoman(left));
   		}
   		return sb.toString();
    }

}