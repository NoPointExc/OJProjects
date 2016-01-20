public class Sort{
	int[] arr;
	public int[] quickSort(int[] arr){
		if(arr.length<2) return arr;
		this.arr=arr;
		partion(0,arr.length-1);
		return arr;
	}

	public void partion(int from,int to){
		
		int mid=arr[(from+to)/2];
		int i=from,j=to; //i head pointer, j tail pointer
		while(i<=j){
			while(arr[i]<mid) i++;
			while(arr[j]>mid) j--;
			if(i<=j) {
				swap(i,j); 
				i++;j--;
			}			
		}
		if(j>from) partion(from,j);
		if(i<to) partion(i,to);
	}

	private void swap(int i, int j){
		if(i==j) return;
		arr[i]^=arr[j];
		arr[j]^=arr[i];
		arr[i]^=arr[j];
	}

}