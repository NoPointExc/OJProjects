public class fanbing{
	//aim:sort pan from top to button, 1234 ; input 4321
	//pan arrary
	private static int[] pan ={14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
	public static  void main(String[] args) {
		//sort for the bigset one
		
		for(int i=pan.length-1;i>=0;i--){
			int bigestPos=getBigestPos(i);
			//double switch. put the bigest pan in the top then swithc to bottom
			if(bigestPos!=0){
				//switch to bottom
				switchPan(bigestPos);
			}
			//switch to top
			switchPan(i);
		}
		print();
	}
	/**
	input the position to switch with the top one. Top position is 0
	*/
	private static void switchPan(int pos){
		int tmp=pan[pos];
		pan[pos]=pan[0];
		pan[0]=tmp;
		System.out.println(pos);	
		
	}
	/**
	int put the last unsorted position and get the bigest number position
	return -1 if not found error
	*/
	private static int getBigestPos(int lastPos){
		for(int i=0;i<=lastPos;i++){
			if(pan[i]==lastPos) return i;
		}
		//not found error
		return -1;
	}

	private static void print(){
		System.out.println("Result:");
		for(int i=0;i<pan.length;i++){
			System.out.print(" "+pan[i]+" ");
		}
	}
}