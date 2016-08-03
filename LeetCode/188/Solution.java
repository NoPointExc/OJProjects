import java.util.*;

public class Solution {
    private int[] prices;
    int len;
    
    public int maxProfit(int k, int[] prices) {
        this.prices=prices;
        len=prices.length;
        return maxProfit(k,-1,0);
    }

    private int maxProfit(int k,int min,int from){
    	//System.out.println("k="+k+" min="+min+" from="+from);
    	if(from>=len || k==0 ) return 0;

    	if(min==-1) min=prices[from];
    	int max=0;
    	int i=from;    	
    	
    	if(i+1<len && prices[i]<prices[i+1]){
	    	//while rising
	    	if(prices[i]<min) min=prices[i];
	    	while(i+1<len && prices[i]<prices[i+1]){
	    		i++;
	    	}

	    	if(prices[i]>min){
	    		//sell out
	    		int sell=prices[i]-min+maxProfit(k-1,-1,i);
	    		int keep=maxProfit(k,min,i);
	    		max=Math.max(sell,keep);
	    	}else{
	    		max=maxProfit(k,min,i+1);
	    	}
    	}else if(i+1<len){
    		//while descending
    		while(i+1<len && prices[i]>=prices[i+1]){
    			i++;
    		}
    		if(prices[i]<min) min=prices[i];
    		max=maxProfit(k,min,i);
    	}else{
    		max=maxProfit(k,min,i+1);
    	}

    	return max;
    }
}