
public class Solution {
    public String convert(String s, int numRows) {//s=abcd, numRows=3
    	StringBuilder sb=new StringBuilder();
    	if(numRows==1) return s;
    	char[][] zig=new char[(1+s.length()/(2*numRows-2))*(numRows-1)][numRows];
    	//initial
    	for(int y=0;y<zig[0].length;y++){
    		for(int x=0;x<zig.length;x++){
    			zig[x][y]='*';
    			//System.out.print('*');
    		}
    		//System.out.println();
    	}

    	//zigZag
    	int i=0,j=0,k=0;
    	while(k<s.length()){
    		while(j<zig[0].length&&k<s.length()) {	
    			zig[i][j]=s.charAt(k);
    			j++;
    			k++;
    			print(zig);
    		}
    		j--;
    		while(i<zig.length&&k<s.length()&&j>0){
    			j--;i++;
    			zig[i][j]=s.charAt(k);
    			k++;
    			print(zig);
    		}
    		j++;
    	}
    

    	//output s
    	for(int y=0;y<zig[0].length;y++){
    		for(int x=0;x<zig.length;x++){
    			if(zig[x][y]!='*') sb.append(zig[x][y]);   			
    		}    		
    	}
    	return sb.toString();
    }

    private void print(char[][] zig){
    	System.out.println();
    	for(int y=0;y<zig[0].length;y++){
    		for(int x=0;x<zig.length;x++){
    			System.out.print(zig[x][y]);  			
    		}
    		System.out.println();    		
    	}
    }


}