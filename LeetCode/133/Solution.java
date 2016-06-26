import java.util.*;

//* Definition for undirected graph.
 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class Solution {
    HashMap<Integer,UndirectedGraphNode> visited=new HashMap();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node==null) return null;
    	if(visited.containsKey(node.label)) return visited.get(node.label);
    	
    	UndirectedGraphNode rst=new UndirectedGraphNode(node.label);
    	visited.put(node.label,rst);    	
    	for(UndirectedGraphNode nbr:node.neighbors){
    		UndirectedGraphNode cl=cloneGraph(nbr);    		    		
    		rst.neighbors.add(cl);
    	}
    	return rst;
    }
}