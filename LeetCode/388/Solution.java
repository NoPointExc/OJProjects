import java.util.*;

public class Solution {
    
    public int lengthLongestPath(String input) {
	int maxLen = 0;
	int dirLen = 0;
	LinkedList<String> stack = new LinkedList<>();
	
	String[] lines = input.split("\n");
	for(String line:lines){
	    //System.out.println("line="+line+" dirLen="+dirLen);
	    int dep = line.lastIndexOf("\t")+1;
	    int len = line.length()-dep;
	    
	    while( dep < stack.size()){
		dirLen -= stack.pop().length() - stack.size();
	    }
	    if(line.contains(".")){
		//file
		int pathLen = dirLen+stack.size()+len; // each '/' after each dir
		maxLen = pathLen>maxLen?pathLen:maxLen;
	    }else{
		//dir
		stack.push(line);
		dirLen += len; 
	    }	    
	}

	return maxLen;	
    }
    
    public static void main(String[] args){
    	
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"); 
	//int rst = new Solution().lengthLongestPath("dir\n    file.txt"); //expect 12 
	int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20 
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20
	System.out.println(rst);
    }

}
