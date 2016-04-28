public class Solution {
    public int maxProfit(int[] prices) {
        int prof=0;
        if(prices==null||prices.length<2) return 0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                    min=prices[i];
            }else{
                if(i<prices.length-1&&prices[i]<prices[i+1]){
                    continue;
                }else{
                    prof+=prices[i]-min;
                    if(i<prices.length-1) min=prices[i+1];
                }
            }
        }
        return prof;
    }
}