/**
*Input: numbers={0,4,3,0}, target=0
*Output: index1=1, index2=2
*/
import java.util.*;

public class Solution {
	//numbers= 5,75,25  target=100
    public int[] twoSum(int[] numbers, int target) {
    	Map<Integer, Integer> map=new HashMap<>();
        int length=numbers.length; //length=3
        for(int i=0;i<length;i++){
        	int x=numbers[i]; //95
        	//search for index2
        	if(map.containsKey(target-x)){
        		return new int[] {map.get(target-x)+1,i+1 };
        	}
        	map.put(x,i);
    	}   
    	throw new IllegalArgumentException("No Solution");
	}
}