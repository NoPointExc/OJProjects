import java.util.*;
public class Solution {
    public static int findMaximumXOR(int[] nums) {
	if(nums == null){
	    return 0;
	}
	int max = 0;
	int mask = 0;
	for(int flipBit = 1 << 30; flipBit >= 1; flipBit = flipBit >> 1){
	    mask = mask | flipBit;
	    HashSet<Integer> set = new HashSet<>();
	    for(int n : nums){
		set.add(n & mask);	
	    }
	    
	    //flip current bit of max (xxxxx0 --> xxxxx1)
	    //nextMax = i ^ j  ==> j = nextMax ^ i
	    int nextMax = flipBit | max; 
	    for(int n : set){
		if(set.contains(nextMax ^ n)){
		    max = nextMax;
		    break;
		}
	    }

	}

	return max;
    }

    public static void main(String[] args){
	int max = findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
	System.out.println(max);
    }
}

