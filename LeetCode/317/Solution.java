import java.util.*;

public class Solution {
    //TODO: DIR
    //
    private static final int[][] DIR = {{1, 0}, {0 , 1}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0){
        	return -1;
        }
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i = 0; i < distance.length; i++){
        	for(int j = 0; j < distance[0].length; j++){
        		if(grid[i][j] == 1){
        			int[][] tmpDistance = bfs(i, j, grid);
        			add(distance, tmpDistance);
        		}
        	}
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < distance.length; i++){
        	for(int j = 0; j < distance[0].length; j++){
        		minDistance = Math.min(minDistance, distance[i][j]);
        	}
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int[][] bfs(int x, int y, int[][] grid){
    	boolean[][] visited = new boolean[grid.length][grid[0].length];
    	LinkedList<int[]> queue = new LinkedList<>();
    	queue.offer(new int[]{x, y});
    	int[][] rstArr = new int[grid.length][grid[0].length];
    	while(!queue.isEmpty()){
    		int[] cur = queue.poll();
    		for(int dir : DIR){
    			int nextX = cur[0] + dir[0];
    			int nextY = cur[1] + dir[1];
    			if(nextX >= 0 && nextX < grid.length && nextY >=0 && nextY < grid[0].length && grid[nextX][nextY] == 0){
    				if(!visited[nextX][nextY]){
    					queue.offer(new int[]{nextX, nextY});	
    				}
    				
    				rstArr[nextX][nextY] = math.min(rstArr[cur[0]][cur[1]] + 1, rstArr[nextX][nextY]);
    			}
    		}
    	}

    	return rstArr;
    }

    private void add(int[][] addTo, int[][] addFrom){
    	for(int i = 0; i < addTo.length; i++){
        	for(int j = 0; j < addTo[0].length; j++){
        		addTo[i][j] += addFrom[i][j];
        	}
    	}
    }
}