class Test{
    public static void main(String[] args){
      Trie trie = new Trie();
      trie.insert("somestring");
      boolean rst=trie.search("some");     
        System.out.println("has some="+rst);
        trie.insert("some");
        rst=trie.search("some");
        System.out.println("has some="+rst);
    }
}
