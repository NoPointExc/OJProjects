public class Solution {
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int mid = b > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        if(a != 0){
            mid = -b / (2 * a);
        }
        
        if(a < 0){
            reverse(nums);
        }
        LinkedList<Integer> lStack = new LinkedList<>();
        LinkedList<Integer> rQueue = new LinkedList<>();
        for(int n : nums){
            if(n <= mid){
                lStack.push(n);
            }else{
                rQueue.offer(n);
            }
        }
        System.out.println(lStack);
        
        System.out.println(rQueue);
        int[] rstArr = new int[nums.length];
        for(int i = 0; i < rstArr.length; i++){
            if(rQueue.isEmpty() || (!lStack.isEmpty() && f(lStack.peek(), a, b, c) <= f(rQueue.peekLast(), a, b, c))){
                rstArr[i] = f(lStack.pop(), a, b, c);
            }else{
                rstArr[i] = f(rQueue.poll(), a, b, c);
            }
        }
        
        return rstArr;
    }
    
    private int f(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
    
    private void reverse(int[] nums){
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}