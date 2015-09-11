 public class Solution {
    public int mySqrt(int x) {
    	if(x<0) return -1;
    	if(x==1) return 1;
        long h=0, t=x, m=x/2;
        while(true){
        	if(m*m<x){
        		h=m;
        		m=(t+h)/2;
        	}else if(m*m>x){
        		t=m;
        		m=(t+h)/2;
        	}
        	if(x>=m*m && x<(m+1)*(m+1)) break;
        }        
        return (int)m;
    }
}