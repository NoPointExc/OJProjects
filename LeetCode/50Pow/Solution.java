import java.util.*;
public class Solution {
    public double myPow(double x, int n) {
    	if(x==1) return 1.0;
    	boolean negtive=n<0;   
    	if(negtive) n=-n;
    	char bin[]=Integer.toBinaryString(n).toCharArray();
    	double ans=1;  //x is postive or negative  	
    	for(int i=0;i<bin.length;i++){
    		ans*=ans;
    		if(bin[i]=='1') ans*=x;
    		if(ans==0) break;
    	}
  		if(negtive)	ans=1/ans;
    	return ans;
    }
}