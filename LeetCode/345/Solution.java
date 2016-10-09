public class Solution {
    private static final HashSet<Character> VOWELS = new HashSet<>();
    static{
        char[] VOWELS_ARR= {'a', 'e', 'i', 'o', 'u'};
        for(char c : VOWELS_ARR){
            VOWELS.add(c);
            VOWELS.add((char)(c + 'A' - 'a'));
        }
    }
    
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        char[] str = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : str){
            stack.push(c);
        }
        
        for(int i =0; i < str.length; i++){
            if(VOWELS.contains(str[i])){
                str[i] = stack.pop();
            }
        }
        
        return new String(str);
    }
}