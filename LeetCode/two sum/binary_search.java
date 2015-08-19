public int binary_search(int[] numbers, int start, int end,int index2){
    	
    	if(start==end){
    		if(numbers[start]==index2) return start+1;
    		else return -1;
    	}
    	if(start==(end-1)){
    		if(numbers[start]==index2) return start+1;
    		else if(numbers[end]==index2) return end+1;
    		else return -1;
    	}

    	int middle=(int)Math.floor((start+end)/2);//middle=1, numbers=5,75,25
    	if(index2<numbers[middle]){
    		return binary_search(numbers,start,middle,index2);
    	}else if(index2==numbers[middle]){
    		return middle+1;
    	}else{
    		return binary_search(numbers,middle,end,index2); //search(numbers, 1, 3,95)
    	}
    }