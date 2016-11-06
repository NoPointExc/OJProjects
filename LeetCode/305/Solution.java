public class Solution {

	int[] DIR = {1, 0, -1, 0, 1, 1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	HashSet<Island> islands = new HashSet<>();
    	List<Integer> numsLst = new LinkedList<>();
        Island[][] map = new Island[m][n];
        for(int[] pos : positions){
        	Island curIsland = new Island(pos[0],pos[1]);
        	map[pos[0]][pos[1]] = curIsland;

        	for(int i = 0; i < 4; i++){
        		int x = pos[0] + DIR[i];
        		int y = pos[1] + DIR[i + 1];
        		if(x >=0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != null){
        			Island mergedIsland = map[x][y].merge(curIsland);
        			islands.remove(mergedIsland);
        		}
        	}

        	islands.add(curIsland.getRoot());
        	numsLst.add(islands.size());
        }


        return numsLst;
    }

    class Island{
    	Island root;
    	int x, y;
    	int size;
    	
    	public Island(int x, int y){
    		this.x = x;
    		this.y = y;
    		root = this;
    		size = 1;
    	}

    	public Island merge(Island other){
    		Island largeIsland = this.getRoot();
    		Island smallIsland = other.getRoot();
    		if(largeIsland.size < smallIsland.size){
    			largeIsland = other.getRoot();
    			smallIsland = this.getRoot();
    		} 

    		largeIsland.size += smallIsland.size; 
    	    smallIsland.root = largeIsland;
    	    return smallIsland;
    	}

    	public Island getRoot(){
    		if(root == this){
    			return root;
    		}
    		return root.getRoot();
    	}

    }
}