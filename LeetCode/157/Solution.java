/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(buf == null){
            return 0;
        }
        
        char[] buf4 = new char[4]; 
        int count = 0;
        while(count < n){
            int readLen = read4(buf4);
            for(int i = 0; count + i < n && count + i < buf.length && i < readLen && i < 4; i++){
                buf[count + i] = buf4[i];
            }
            count = Math.min(count + readLen, n);
            if(readLen < 4){
                break;
            }
        }
        
        return count;
    }
}