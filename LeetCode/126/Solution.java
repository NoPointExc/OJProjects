import java.util.*;

public class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	Node root=new Node(beginWord);
    	HashSet<String> toRm=new HashSet();
    	LinkedList<Node> reached=new LinkedList();
        reached.add(root);
        toRm.add(beginWord);
        wordList.add(endWord);

    	while(!toRm.contains(endWord) && toRm.size()!=0){
    		System.out.println(toRm);
            toRm=new HashSet();            
            LinkedList<Node> willReached=new LinkedList();
            
    		for(Node node:reached){

				//find possible next                    
    			for(int i=0;i<node.val.length();i++){
    				char[] str=node.val.toCharArray();    			
    				for(char ch='a';ch<='z';ch++){
    					str[i]=ch;
    					String word=new String(str);
    					if(wordList.contains(word)){
    						Node tmp=new Node(word);
                            node.addNext(tmp);
                            willReached.add(tmp);
    						toRm.add(word);
    					}
    				}
    			}

    		}

            reached=willReached;	    	
	    	wordList.removeAll(toRm);

    	}

        System.out.println("tree generated");
        //parsing to a List
        List<List<String>> rst=new LinkedList();

        for(Node node:reached){
            if(node.val.equals(endWord)){
                LinkedList<String> lst=new LinkedList();
                addTo(node,lst,rst);              
            }
        }
    	return rst;
    }

    private void addTo(Node node,LinkedList<String> toAdd,List<List<String>> list){        
        if(toAdd.size()==0){
            toAdd=new LinkedList();
        }
        toAdd.addFirst(node.val);
       
        if(node.prev==null || node.prev.size()==0) {
            list.add(toAdd);
            return;
        }

        for(Node each:node.prev){
            LinkedList<String> tmp=new LinkedList(toAdd);
            addTo(each,tmp,list);
        }

    }

    class Node{
    	String val=null;
    	LinkedList<Node> prev=null;
        LinkedList<Node> next=null;
    	
    	public Node(){
    		this(null);
    	}

    	public Node(String word){
    		val=word;
            next=new LinkedList();
            prev=new LinkedList();    			
    	}
    	
    	public void addNext(String node){
    		Node tmp=new Node(node);
    		this.addNext(tmp);
    	}

    	public void addNext(Node node){
    		if(node==null) return;
            if(next==null){
    			next=new LinkedList();
    		}
            node.prev.add(this);
    		next.add(node);
    	}

    	
    }
}
