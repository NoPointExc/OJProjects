public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map={" ", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> queue=new LinkedList<String>();
        if(digits.length()==0) return queue;
        queue.add("");
        int[] num=getNum(digits);
        
        for(int i=0;i<num.length;i++){
            while(queue.peek().length()==i){
                String next="";
                if(!queue.isEmpty()) next=queue.poll();
                for(char c:map[num[i]].toCharArray()){
                    String tmp=next+c;
                    queue.offer(tmp);
                }
            }
        }
        
        return queue;
    }
    
    private int[] getNum(String digits){
        int[] rst=new int[digits.length()];
        for(int i=0;i<digits.length();i++){
            rst[i]=digits.charAt(i)-'0'+0;
        }
        return rst;
    }
}