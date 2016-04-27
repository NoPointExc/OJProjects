public class Solution {
    public int maxProfit(int[] prices) {
            if(prices.length<=1) return 0;
	            int min=prices[0];
		            int prf=0;
			            for(int i=1;i<prices.length;i++){
				                prf=(prices[i]-min)>prf?(prices[i]-min):prf;
						            min=min<prices[i]?min:prices[i];
							            }
								            return prf;
									        }
										}
