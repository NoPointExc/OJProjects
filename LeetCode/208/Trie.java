import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return startsWith(word+'0');
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p=root;
        int i=0;
        while(p!=null){
            if(i==prefix.length()) 
                return true;
            else{ 
                p=p.next.get(prefix.charAt(i));
                i++;
            }
        }

        return false;
    }
}
