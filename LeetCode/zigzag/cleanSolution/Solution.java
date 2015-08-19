public class Solution {

    public String convert(String s, int nRows) {
        if(nRows == 1)  return s;
        int len = s.length();
        char[] ans = new char[len];

        int index = 0;
        //Line-by-line add these chars
        for(int row = 0; row < nRows; ++row){
            //Every 2*(nRows-1) chars are a unit from i*(2*(nRows-1)) - (nRows-1) to i*(2*(nRows-1)) - (nRows-1)
            for(int zigzag = 0; zigzag < len + row; zigzag += (2*(nRows-1))){
                if(zigzag -row < len && zigzag -row >= 0) ans[index++] = s.charAt(zigzag - row);
                //If i*(2*(nRows-1)) - row is not equal to  i*(2*(nRows-1)) + row, add this char
                if(row + zigzag < len && row != 0 && row != nRows-1)  ans[index++] = s.charAt(row + zigzag);
            }
        }
        return String.valueOf(ans);
        //Time complexity is almost nRows * s.length() / (nRows - 1)
    }
}