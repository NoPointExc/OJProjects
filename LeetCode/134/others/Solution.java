public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, sum = 0, index = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        if (index == len)return -1;
        for (int i = 0; i <= index; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < 0) return -1;          
        }
        return index;
    }
}