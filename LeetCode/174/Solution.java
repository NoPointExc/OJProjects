public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int w=dungeon.length;
        int l=dungeon[0].length;

        int[][] rst=new int[w][l];
        for(int i=1;i<=w || i<=l;i++){
            if(i<=w){

                for(int j=l-i;j>=0;j--){
                    int gain=dungeon[w-i][j];
                    if(w-i==w-1 && j==l-1){
                        rst[w-i][j] = getMin(1,gain);
                    }else if(w-i==w-1){
                        rst[w-i][j]=getMin(rst[w-i][j+1],gain);
                    }else{
                        int minHp=Math.min(rst[w-i+1][j],rst[w-i][j+1]);
                        rst[w-i][j]=getMin(minHp,gain);
                    }
                }
            }
            
            if(i<=l){
                for(int j=w-i;j>=0;j--){
                    int gain=dungeon[j][l-i];
                    if(j==w-1 && l-i==l-1){
                        continue;
                    }else if(l-i==l-1){
                        rst[j][l-i]=getMin(rst[j+1][l-i],gain);
                    }else{
                        int minHp=Math.min(rst[j][l-i+1],rst[j+1][l-i]);
                        rst[j][l-i]=getMin(minHp,gain);
                    }
                }
            }
        }
        
        return rst[0][0];
    }
    
    private int getMin(int hp,int gain){
        int min=0;
        if(hp<=gain){
            min=1;
        }else{
            min=hp-gain;
        }
        return min;
    }
    
}