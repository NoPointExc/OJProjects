import java.util.*;
public class Solution {
    public int[] plusOne(int[] digits) {
       	int len=digits.length;
       	int[] ans=new int[len+1];
       	ans[len]=digits[len-1]+1;
       	for(int i=len-1;i>=0;i--){
       		if(i==0) ans[0]=ans[1]/10;
       		else ans[i]=digits[i-1]+ans[i+1]/10;
       		ans[i+1]=ans[i+1]%10;
       	}
       	//trim
       	if(ans[0]==0) ans=Arrays.copyOfRange(ans,1,len+1);
       	return ans;
    }
}