import java.util.*;

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
