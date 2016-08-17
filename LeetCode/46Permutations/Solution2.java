import java.util.*;

public class Solution2 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list=new ArrayList<List<Integer>>(); 	
		permute(list,nums,0);
		return list;
	}

	private void permute(List<List<Integer>> list, int[] num, int k){
		if(k==num.length-1){
			List<Integer> l=new ArrayList<Integer>();
			for(int n:num)
				l.add(n);
			list.add(l);
		}else{
			for(int i=k;i<num.length;i++){
				swap(num,k,i);
				permute(list,num,k+1);
				swap(num,k,i);
			}
		}
	}

	private void swap(int[] num,int i,int k){
		int tmp=num[i];
		num[i]=num[k];
		num[k]=tmp;
	}
}
