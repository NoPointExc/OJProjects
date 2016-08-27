class Test{
    public static void main(String[] args){
        WordDictionary dict=new WordDictionary();
        dict.addWord("a");
        dict.addWord("ab");
        boolean rst=dict.search("a.");
        System.out.println(rst);
    }
}
