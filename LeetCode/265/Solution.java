public class Solution {
   
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }else{
            for(int i=0; i < costs.length; i++){
                if(costs[i] == null){
                    return 0;
                }
            }
        }
        
        int lastMinColor1 = 0, lastMinColor2 = 0;

        int[][] costMap = new int[costs.length + 1][costs[0].length];
        
        for(int i = 1; i <= costs.length; i++){
            int currentMin1 = -1, currentMin2 = -1;
            for(int j =0; j < costs[0].length; j++){
                if(j == lastMinColor1){
                    costMap[i][j] = costs[i - 1][j] + costMap[i - 1][lastMinColor2];
                }else{
                    costMap[i][j] = costs[i - 1][j] + costMap[i - 1][lastMinColor1];
                }
                
                if(currentMin1 == -1 || costMap[i][j] <= costMap[i][currentMin1]){
                    currentMin2 = currentMin1;
                    currentMin1 = j;
                }else if(currentMin2 == -1 || costMap[i][j] <= costMap[i][currentMin2]){
                    currentMin2 = j;
                }
            }
            lastMinColor1 = currentMin1;
            lastMinColor2 = currentMin2;
        }
        
        return costMap[costs.length][lastMinColor1];
    }
}