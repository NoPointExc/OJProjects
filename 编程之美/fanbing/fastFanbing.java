public class fastFanbing{
	/**
	try all the possible solution and get the fastest solution.
	As show in fanbing.java, the fast solution must better than 2*n steps( all pan in wrong position). 
	So, 0<=min<=2n 
	In deed, this problem is to travel through n-1 tree with n-2 children in each level. The max deepth is 2n
	//


	*/
	private static int[] pan={0,3,2,1};

	private static int lastPan=0;
	private static int min= 2*pan.length;
	public static void main(String[] args) {
		int[] panArray=init();
		getMinStep(0,panArray);
		System.out.println();
		System.out.println("RESULT: " +min);

	}
	/**
	return initilized panArray
	*/
	private static int[] init(){
		int[] panArray=new int[pan.length];
		for(int i=0;i<pan.length;i++){
			panArray[i]=pan[i];
		}
		return panArray;
	}

	/**
		return int min step
	*/
	private static void getMinStep(int step, int[] panArray){
		for(int i=1;i<panArray.length;i++){			
			switchPan(i,panArray);
			//over mini step		
			if(step>=min) return;
			else if(isSorted(panArray)){
				//less step than min
				min=step;
				return;
				}else{
				//forward	
				getMinStep(step+1,panArray);
				}
			}
		
	}

	/**
	return is sorted or not 
	*/
	private static boolean isSorted(int[] panArray){
		for(int i=0;i<panArray.length;i++){
			if(panArray[i]!=i) return false;
		}
		return true;
	}
	/**
	input the position to switch with the top one. Top position is 0
	*/
	private static int[] switchPan(int pos,int[] panArray){
		System.out.print(pos);
		int[] tmp=new int[panArray.length];
		for(int i=0;i<panArray.length;i++){
			tmp[i]=panArray[i];
		}
		for(int i=0;i<=pos;i++){
			panArray[i]=tmp[pos-i];
		}
		return panArray;
		
	}


}