public class Solution {
    public long myAtoi(String str) {
        str = str.trim();
        long ans = 0;
        int len = str.length(), flag = 1;
        for (int i = 0; i < len; i++) {
            char c=str.charAt(i);
            int num = Character.getNumericValue(c);
            if (num > -1 && num < 10) {
                ans = 10 * ans + num;
                if (flag * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (flag * ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else if (i == 0&& (c=='+'||c=='-') ) {
                flag = (c=='-')? -1:1;
            } else  break;
        }
        return ans * flag;
    }
}