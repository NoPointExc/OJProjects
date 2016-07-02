public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length, tank=0, index=0;
        for(int i=0;i<len;i++){
            tank+=gas[i]-cost[i];
            if(tank<0) {index=i+1; tank=0;}
        }
        if(index==len) return -1;
        for(int i=0;i<=index;i++){
            tank+=gas[i]-cost[i];
            if(tank<0) return-1;
        }
        return index;
    }
}