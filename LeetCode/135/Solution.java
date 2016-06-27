public class Solution {
    public int candy(int[] ratings) {
    	int rst=0;
    	if(ratings==null || ratings.length==0) return 0;
    	if(ratings.length==1) return 1; 
    	int len=ratings.length;
    	int minNum=ratings[0];
    	for(int i:ratings) minNum=minNum<i?minNum:i;
    	for(int i=0;i<len;i++) ratings[i]-= (minNum-1);
    	boolean todo=true;
    	boolean last=true;
    	while(todo || last){
    		if(!todo) last=false;
	    	
	    	// for(int i:ratings){
	    	// 	System.out.print(i+"  ,");   		
	    	// }	
	    	// System.out.println();

    		todo=false;
    		
    		int i=0;
    		while(i<len){
    			int fr=i, to=i+1;
    			int max=-1;
    			int min=-1;
    			
    			while( last &&to<len && ratings[to]==ratings[i]){
    				to++;
    			}

    			//flash num between fr..to
    			if(fr-1>=0){
    				min=ratings[fr-1];
    				max=ratings[fr-1];	    				
	    			if(to<len){		    				
	    				if(ratings[to]<min) min=ratings[to];
	    				else if(ratings[to]>max) max=ratings[to];	
	    			}
    			}else if(to<len){
    				min=ratings[to];
    				max=ratings[to];
    			}else{
    				for(int j=fr;j<to;j++) ratings[j]=1;
    				break;
    			}
    			
    			if(ratings[i]<=min && ratings[i]!=1){
    				//less than left & right
    				todo=true;
    				for(int j=fr;j<to;j++) ratings[j]=1;
    			}else if(ratings[i]>min+1 && ratings[i]<=max){
    				//in the mid
    				todo=true;
    				for(int j=fr;j<to;j++) ratings[j]=min+1;
    			}else if(ratings[i]>max+1){
    				todo=true;
    				for(int j=fr;j<to;j++) ratings[j]=max+1;
    			}


    			i=to;
    		}
    	}

    	for(int i:ratings){
    		//System.out.print(i+"  ,");
    		rst+=i;
    	}	


    	return rst;
    }
}