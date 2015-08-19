
import java.lang.Math.*;
public class Solution {

    public int reverse(int x) {
        int ans=0;
        //// 1534236469
        if(x>999999999||x<-999999999){
        	int[] max={2,1,4,7,4,8,3,6,4,7};
        	int tmp=x;
        	for(int k=0;Math.abs(tmp%10)>=max[k];k++){
        		if(Math.abs(tmp%10)>max[k]) return 0;
        		tmp/=10;
        	}
        }
        while(10*x/10!=0){
        	ans=ans*10+x%10;
        	x=x/10;
        }
        return ans;
    }
}
