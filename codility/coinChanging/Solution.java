import java.util.*;

class Solution{
	public int solution(int[] c, int k){
		int[] sols =new int[k+1];
		Arrays.sort(c);
		for(int i=0;i<sols.length;i++) sols[i]=Integer.MAX_VALUE-1;
		sols[0]=0;
		for(int i=1;i<k+1;i++){
			for(int coin:c){
				if(i-coin>=0 && sols[i-coin]+1<sols[i]){
					sols[i]=sols[i-coin]+1;
				}
			}
		}
		return sols[k];
	}
}