public class Solution {


    public int maxSubArray(int[] nums) {
    	int mid=nums.length/2;
    	Range range=maxSumContains(mid,nums);
    	int tail=range.tail;
    	int head=range.head;
        int max=range.sum;
        //System.out.println("sum:"+range.sum+"head:"+head+"tail:"+tail);
    	//
    	int left=0, right=nums.length-1;
    	//while(left<right && nums[left]<=0) left++;
    	//while(right>left && nums[right]<=0) right++;
    	//int ct=0;
    	while(head>0 ){
    		//ct++;
    		System.out.println("sum:"+range.sum+"head:"+head+"tail:"+tail);
    		max=range.sum>max?range.sum:max;
    		head=range.head<head?range.head:head;
    		tail=range.tail>tail?range.tail:tail;
    		range=maxSumContains((head+left)/2,nums);

    	}

    	while(tail<nums.length-1){
    		//ct++;
    		//System.out.println("sum:"+range.sum+"head:"+head+"tail:"+tail);
    		max=range.sum>max?range.sum:max;
    		head=range.head<head?range.head:head;
    		tail=range.tail>tail?range.tail:tail;
    		range=maxSumContains( (tail+right+1)/2  ,nums);
    	}
    	return max;
    }

    private Range maxSumContains(int mid, int[] nums){
    	int sum=0;
    	int max=Integer.MIN_VALUE;
    	int h=mid,t=mid;
    	for(int i=mid;i>=0;i--){
    		sum+=nums[i];
    		if(sum>=max){
    			max=sum;
    			h=i;
    		}
    		
    	}
    	sum=max;
    	for(int i=mid+1;i<nums.length;i++){
    		//System.out.println("i:"+i+"sum:"+sum);
    		sum+=nums[i];
    		if(sum>=max){
    			max=sum;
    			t=i;
    		}
    	}
    	return new Range(h,t,max);
    }

   	class Range{
	int head,tail,sum;
	Range(int head,int tail,int sum){
		this.head=head;
		this.tail=tail;
		this.sum=sum;
		}
	}
}

	
