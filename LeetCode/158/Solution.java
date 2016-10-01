/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] localBuf = new char[4];
    private int localCount = 0;
    private int localPointer = 0;
    
    public int read(char[] buf, int n) {
        if(buf == null){
            return 0;
        }
        
        int count = 0;
        while(count < n && count < buf.length){
            if(localCount == localPointer){
                localPointer = 0;
                localCount = read4(localBuf);
                if(localCount == 0){
                    break;
                }
            }else{
                buf[count++] = localBuf[localPointer++];
            }            
        }
        
        return count;
    }
    
}