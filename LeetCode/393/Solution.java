public class Solution {
    private static final int[] HEAD = new int[8];
    static{
        HEAD[1] = 1 << 7;
        for(int i = 2; i < 8; i++){
            HEAD[i] = HEAD[i - 1] + (1 << (8 - i));
        }
    }
    
    public boolean validUtf8(int[] data) {
        if(data == null){
            return false;
        }
        
        int pend = 0;
        for(int i = 0; i < data.length; i++){
            int bytes = getBytes(data[cur]);
            if(bytes == 1){
                if(pend <= 0){
                    return false;
                }
                pend--;
            }else if(bytes > 1){
                if(pend != 0){
                    return false;
                }
                pend = bytes -1;
            }
        }

        return pend == 0;
    }
    
    private int getBytes(int num){
        int len = 0;
        while(len + 1 < HEAD.length && num >= HEAD[len + 1]){
            len++;
        }
        return len;
    }

}