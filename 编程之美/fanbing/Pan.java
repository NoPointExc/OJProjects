public class Pan{
	private int[] panArray;
	private int min=0;
	private int  order[];

	Pan(int[] pan){
		panArray=new int[pan.length];
		order=new int[2*pan.length];
		for(int i=0;i<pan.length;i++){
			panArray[i]=pan[i];
			order[i]=0;
			order[i+pan.length]=0;
		}
		min=2*pan.length;

	}
	public int getMinStep(){
		getMinStep(0,panArray);
		return min;
	}

	/**
		return int min step
	*/
	public void getMinStep(int step, int[] panArray){
		for(int i=1;i<panArray.length;i++){			
			switchPan(i,panArray);
			order[step]=i;
			//over mini step		
			if(step>=min) {
			order[step]=0;
			print();
			System.out.println("");
			System.out.println("*******OVER*******");
			return;
			}
			else if(isSorted(panArray)){
				//less step than min
				min=step;
				order[step-1]=0;
				System.out.println("");
				System.out.println("*******MIN*******"+min);
				return;
				}else{
				//forward	
				getMinStep(step+1,panArray);
				}
			}
		
	}
	
	private void print(){
		for(int i=0;i<order.length;i++){
			System.out.print(order[i]+",");
		}
	}
	/**
	return is sorted or not 
	*/
	private boolean isSorted(int[] panArray){
		for(int i=0;i<panArray.length;i++){
			if(panArray[i]!=i) return false;
		}
		return true;
	}
	/**
	input the position to switch with the top one. Top position is 0
	*/
	private  int[] switchPan(int pos,int[] panArray){
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