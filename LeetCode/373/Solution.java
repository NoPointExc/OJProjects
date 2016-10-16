public class Solution {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null && nums2 == null){
            return null;
        }
        List<int[]> rstList = new LinkedList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.sum - p2.sum;
            }
        });
        
        for(int i = 0; i < k && i < nums1.length && nums2.length != 0; i++){
            queue.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        
        for(int i = 0, j = 1; i < k && !queue.isEmpty(); i++){
            Pair nextP = queue.poll();
            int[] nextArr = new int[2];
            nextArr[0] = nums1[nextP.index1];
            nextArr[1] = nums2[nextP.index2];
            rstList.add(nextArr);
            if(nextP.index2 + 1< nums2.length){
                queue.offer(new Pair(nextP.index1, nextP.index2 + 1, nums1[nextP.index1] + nums2[nextP.index2 + 1]));
            }
        }
        
        return rstList;
    }
    
    class Pair{
        int sum, index1, index2;
        public Pair(int index1, int index2, int sum){
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }
}