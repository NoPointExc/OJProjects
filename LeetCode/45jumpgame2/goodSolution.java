public class Solution {
    public int jump(int[] A) {
        int count = 0, max = 0;
        for (int i = 0, nextMax = 0; i <= max && i < A.length - 1; i++) {
            nextMax = Math.max(nextMax, i + A[i]);
            if (i == max) {
                max = nextMax;
                count++;
            }
        }
        // if there is no way to get to the end, return -1
        return max >= A.length - 1 ? count : -1;
    }

}