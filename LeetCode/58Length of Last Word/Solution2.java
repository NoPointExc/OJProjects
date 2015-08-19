public class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        int index=0;
        for(int i=0;i<=arr.length-1;i++){
        	index=arr[i].length();
        }
        return index;
    }
}