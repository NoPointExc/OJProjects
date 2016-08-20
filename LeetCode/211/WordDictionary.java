import java.util.*;

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void addWord(String word) {
        TrieNode p=root;
        word=word+'0';
        for(char c:word.toCharArray()){
            if(p.next.containsKey(c)){
                p=p.next.get(c);
            }else{
                TrieNode node=new TrieNode(c);
                p.next.put(c,node);
                p=node;
            }
        }
    }

    public boolean search(String word){
        word=word+'0';
        LinkedList<TrieNode> queue=new LinkedList<TrieNode>();
        queue.offer(root);
        int matched=0;
        int toTest=0;

        for(int i=0;i<word.length();i++){
            int size=queue.size();
            if(size==0) return false;
            while(size-->0){
                TrieNode p=queue.poll();

                if(word.charAt(i)=='.'){
                    queue.addAll(p.next.values()); 
                }else{
                    TrieNode next=p.next.get(word.charAt(i));
                    if(next==null)
                        return false;
                    else
                        queue.offer(next);
                }     
            }

        }

        return true;
    }

    class TrieNode {                                               
        // Initialize your data structure here.                    
        char val='1';                                              
        HashMap<Character,TrieNode> next;                          
        public TrieNode() {                                        
            next=new HashMap<Character,TrieNode>();                
        }                                                          

        public TrieNode(char val) {                                
            this.val=val;                                          
            next=new HashMap<Character,TrieNode>();                
        }                                                          
    }                                                              
}
