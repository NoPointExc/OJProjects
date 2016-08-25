public class Solution {
	public int[] countBits(int num) {
		int[] rst=new int[num+1];
		
		for(int base=1,i=0;base+i<=num;){
			if(i==base){
				i=0;
				base=base*2;
			}else{
				rst[base+i]=rst[i]+1;
				i++;
			}
		}

		return rst;
	}
}
