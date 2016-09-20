import java.util.*;

class Solution {
    public int lengthLongestPath(String input) {
	Deque<Integer> stack = new ArrayDeque<>();
	stack.push(0); // "dummy" length
	int maxLen = 0;
	for(String s:input.split("\n")){
	    int lev = s.lastIndexOf("\t")+1; // number of "\t"
	    while(lev+1<stack.size()) stack.pop(); // find parent
	    System.out.println(s.length()-lev);
	    int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
	    stack.push(len);
	    // check if it is file
	    if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
	}
	return maxLen;
    }
    

    public static void main(String[] args){
    	
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"); 
	int rst = new Solution().lengthLongestPath("dir\n    file.txt"); //expect 12 
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20 
	System.out.println(rst);
    }


}
