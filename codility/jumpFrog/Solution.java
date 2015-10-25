class Solution { 
	public int solution(int[] s, int d, int q){
		int[] stps=new int[d+1];
		for(int i=0;i<stps.length;i++) stps[i]=0;
			stps[0]=1;
		if(d==0) return 1;

		for(int i=1;i<(d+1);i++){
			for(int j=0;j<s.length;j++){
				if(s[j]<=i) {
					stps[i]=(stps[i]+stps[i-s[j]])%q;
				}
			}
		}
		return stps[d];
	}

}