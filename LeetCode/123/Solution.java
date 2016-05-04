public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<=1) return 0;
        int curMax=0;
        int[] maxL=new int[len];
        int min=prices[0];
        for(int i=0;i<len;i++){
            min=min<prices[i]?min:prices[i];
            int tmp=prices[i]-min;
            curMax=tmp>curMax?tmp:curMax;
            maxL[i]=curMax;
        }
        
        int[] maxR=new int[len];
        int max=prices[len-1];
        curMax=0;
        for(int i=len-1;i>=0;i--){
                max=max>prices[i]?max:prices[i];
                int tmp=max-prices[i];
                curMax=tmp>curMax?tmp:curMax;
                maxR[i]=curMax;
        }
        
        int sumMax=0;
        for(int i=0;i<len;i++){
            int tmp=maxL[i]+maxR[i];
            sumMax=sumMax>tmp?sumMax:tmp;
        }
        return sumMax;
    }
}