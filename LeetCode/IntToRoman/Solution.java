public class Solution {
    private static final int I=1,V=5,X=10,L=50, C=100,D=500,M=1000;
    private static final String[] cha={"I","V","X","L","C","D","M"};
    private static final int[] map={I,V,X,L,C,D,M};
    public String intToRoman(int num) {
      StringBuilder sb=new StringBuilder();
      while(num>0){    
        //search
          int prm=0, cmp=0;
          for(int i=0;i<cha.length;i++){
            //System.out.println(prm);
            if(num<(map[prm]-map[cmp])||prm>=map.length) break;
            
            if(prm<map.length) prm++;
            if((cmp+2)<map.length-1&&prm<map.length&&(map[cmp+2])<map[prm]) cmp+=2;
            //System.out.println("prm="+prm+" cmp="+cmp); 
          }         
          //back track      
          prm--;
          if(cmp!=0&&map[cmp]>=map[prm]) cmp-=2;
          //System.out.println("prm="+prm+" cmp="+cmp);
        //formate
        if(num<map[prm]){
          sb.append(cha[cmp]);
          sb.append(cha[prm]);
          num-=(map[prm]-map[cmp]);               
        }else{
          sb.append(cha[prm]);
          num-=map[prm];
        }
        //System.out.println("num="+num);      
      }
      return sb.toString();
  }


}