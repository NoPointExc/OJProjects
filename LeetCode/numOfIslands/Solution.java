/**
*11110
*11010
*11000
*00000
**/

public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int x=0;x<grid.length;x++){
        	for(int y=0;y<grid[0].length;y++){
        		if(visit(grid,x,y)) count++;
        		//print(grid,count);
        	}
        }
        return count;
    }

    private boolean visit(char[][] grid, int x, int y){
    	if(x<0||y<0||x>=grid.length||y>=grid[0].length|| grid[x][y]!='1') return false;
    	grid[x][y]='v';
    	visit(grid, x+1,y);
    	visit(grid,x-1,y);
    	visit(grid, x,y+1);
    	visit(grid,x,y-1);
    	return true;
    }


    // private void print(char[][] grid,int count){
    // 	System.out.println("************count["+count+"]***********");
    // 	for(int x=0;x<grid.length;x++){
    // 		for(int y=0;y<grid[0].length;y++){
    // 			System.out.print(grid[x][y]);
    // 		}
    // 		System.out.println();
    // 	}
    // }

}