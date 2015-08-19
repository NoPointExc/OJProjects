public class Solution {
    public String convert(String s, int numRows) {
       int [][] head=new int[2][numRows];
       int step=2*numRows-2;
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<numRows;i++){
       	head[0][i]=i;
       }
       head[1][0]=-1; head[1][numRows-1]=-1;

       for(int i=numRows;i<2*numRows-2;i++){
       	head[1][2*numRows-2-i]=i;
       }
     print(head);
     //first set,k=count,k< column num
     int column=s.length()/step;
     int tmp=column;
     if(s.length()%step!=0) tmp++;
     for(int k=0;k<tmp;k++){
     	sb.append(s.charAt(head[0][0]+k*step));
     }
     //middle
     
     for(int i=1;i<s.length()-1;i++){
     	tmp=2*column;
     	if(column%step>step-i) tmp++;
     	for(int k=0;k<tmp;k++){
     		sb.append(s.charAt(head[k%2][numRows-i]+k*step));
     		System.out.println("sb="+sb);
     	}
     }
     
     //final set
     tmp=column;
     if(s.length()%step>numRows-1) tmp++;
     for(int k=0;k<tmp;k++){
     	sb.append(s.charAt(head[0][numRows-1]+k*step));
     }
     System.out.println("sb="+sb);
     return sb.toString(); 	
    }


    private void print(int[][] zig){
    	System.out.println();
    	for(int y=0;y<zig[0].length;y++){
    		for(int x=0;x<zig.length;x++){
    			System.out.print(zig[x][y]);  			
    		}
    		System.out.println();    		
    	}
    }
}

