public class Solution {
    public int uniquePaths(int m, int n) {
    	int sum=m+n-2;
    	int b=(m>n?m:n)-1;	
    	int s=sum-b;
    	long ans=1;
    	for(int i=sum;i>b;i--) ans*=i;
    	for(int i=s;i>1;i--) ans/=i;
    	return (int)ans;
    }
}