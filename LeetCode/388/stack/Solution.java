import java.util.*;

public class Solution {
    
    public int lengthLongestPath(String input) {
	int maxLen = 0;
	LinkedList<Integer> stack = new LinkedList<>();
	stack.push(0);	
	
	for(String line:input.split("\n")){
	    int depth = line.lastIndexOf("\t")+1;
	    int length = line.length()-depth;

	    while( depth < stack.size()-1){
		stack.pop();
	    }
	    
	    int parentPthLen = stack.peek();
	    if(line.contains(".")){
		//file
		int filePthLen = parentPthLen + length;
		maxLen = filePthLen>maxLen?filePthLen:maxLen;
	    }else{
		//dir
		stack.push(parentPthLen + length+1);
	    }
	}

	return maxLen;	
    }
    
    public static void main(String[] args){
    	
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"); 
	int rst = new Solution().lengthLongestPath("dir\n    file.txt"); //expect 12 
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20 
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20
	System.out.println(rst);
    }

}
