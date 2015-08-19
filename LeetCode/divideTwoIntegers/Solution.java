public class Solution {
    public int divide(int dividend, int divisor) {	
        int dnd,dor;
        boolean dndN=false, dorN=false;
        //special case
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend>0) {
        	//consider case dividend=-2147483648, so can not use Math.abs
        	dnd=-dividend; 
        	dndN=false;
        }else {
        	dnd=dividend;
        	dndN=true;
        }
        if(divisor>0) {
        	dor=-divisor;
        	dorN=false;
        }else {
        	dor=divisor;
        	dorN=true;
        }
        int ans=NegativeDiv(dnd,dor);
        if(dndN!=dorN) ans=-ans;
        return ans;
    }
    //consider case dividend=-2147483648, can't use "PostiveDiv"
    public int NegativeDiv(int dnd,int dor){
    	if(dnd==0||dnd>dor) return 0;
    	int cof=1;
		int prd=dor; //product=cof*dor;
		while((prd<<1)>dnd&&prd>-1071741824){			
			cof=cof<<1;
			prd=prd<<1;		
		}	
		return cof+NegativeDiv(dnd-prd, dor);
	}
}