import java.util.*;

public class Solution {
    
    public int lengthLongestPath(String input) {
	int maxLen = 0;
	int dirLen = 0;
	LinkedList<String> stack = new LinkedList<>();
	
	String[] lines = input.split("\n");
	for(String line:lines){
	    //System.out.println("line="+line+" dirLen="+dirLen);
	    int dep = getDepth(line);
	    line = line.trim();
	    int len = line.length();
	    //System.out.println("len="+len+" dep="+dep);
	    if(line.contains(".")){
		//file
		int pathLen = dirLen+len;
		maxLen = pathLen>maxLen?pathLen:maxLen;
	    }else{
		//dir
		while(dep < stack.size()){
		    String outDir = stack.pop();
		    dirLen -= 1+outDir.length();
		}
		stack.push(line);
		dirLen += len+1; 
	    }	    
	}

	return maxLen;	
    }
    
    private int getDepth(String name){
	int depth = 0;
	
	while(name.startsWith("\t")){
	    depth++;
	    name = name.substring(1);
	}
	
	return depth;
    }

    public static void main(String[] args){
    	
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"); 
	int rst = new Solution().lengthLongestPath("dir\n    file.txt"); //expect 12 
	//int rst = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); //expect 20 
	System.out.println(rst);
    }

}
