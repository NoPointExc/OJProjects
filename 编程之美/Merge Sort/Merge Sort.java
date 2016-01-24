public class Main{

	public int[] mergeSort(int[] arr, int len){

	}

	private int[] merge(int[] arr1, int len1, int[] arr2, int len2){
		int len=len1+len2;
		int[] mergedArr= new int[len];
		int p1=0; //pointer for arr1 
		int p2=0; //pointer for arr2
		int pMe=0; //pointer for mergeaArr
		for(int i=0;i<len;i++){
			if(p1<len1&&p2<len2){
				if(arr1[p1]<arr2[p2]){
					mergedArr[pMe++]=arr1[p1];
					p1++;
				}else{
					mergedArr[pMe++]=arr2[p2];
					p2++;
					}

			}else if(p1<len1){
				mergedArr[pMe++]=arr2[p1];
				p1++;
			}else if(p2<len2){
				mergedArr[pMe++]=arr2[p2];
				p2++;
			}

		}
			return mergedArr;
		}
	}

	public int[] quickSort(int[] arr, int len){

	}	
}