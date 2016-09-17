import java.util.*;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
	return getUniqueDigitsList(n).size();  
    }

    public List<Integer> getUniqueDigitsList(int n) {
	List<Integer> list  = new ArrayList<Integer> ();
	if(n<0)
	    return list;
	list.add(0);
	if(n==0)
	    return list;
	for(int i=1;i<=9;i++)
	    list.add(i);

	int[] arr = new int[10];
	for(int i=0;i<10;i++)
	    arr[i] = i;


	for(int i=2;i<=n && i<=10;i++){
	    permute(arr,0,i,list);
	}

	return list;
    }
 
    private void permute(int[] arr,int k,int t, List<Integer> list){

	if(k==t){
	    int num = 0;
	    for(int i:arr){
		num = num*10 + i;
	    }
	    list.add(num);  
	}else{
	    for(int i=k;i<arr.length;i++){
		if(k==0 && i ==0)
		    continue;
		swap(arr,k,i);
		permute(arr,k+1,t,list);
		swap(arr,k,i);
	    }
	}	
    }

    private void swap(int[] arr, int i, int j){
	int tmp = arr[i];
	arr[i] = arr[j];
	arr[j] = arr[i];
    }

    public static void main(String[] args){
	Solution s = new Solution();
	for(int i=-1;i<20;i++){
	  int rst = s.countNumbersWithUniqueDigits(i);
	  System.out.println(rst);
	}
    }

}
