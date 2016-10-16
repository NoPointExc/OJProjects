public class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        if(people == null){
            return null;
        }
        PriorityQueue<People> queue = new PriorityQueue<>(new Comparator<People>(){
            @Override
            public int compare(People p1, People p2){
                if(p1.height == p2.height){
                    return p1.rank - p2.rank;
                }
                return p2.height - p1.height;
            }
        });
        
        for(int[] p : people){
            queue.offer(new People(p));
        }
        
        ArrayList<People> peopleList = new ArrayList<>();
        while(!queue.isEmpty()){
            People nextP = queue.poll();
            peopleList.add(nextP.rank, nextP);
        }
        
        int[][] peopleArr = new int[people.length][2];
        for(int i = 0; i < peopleList.size(); i++){
            peopleArr[i][0] = peopleList.get(i).height;
            peopleArr[i][1] = peopleList.get(i).rank;
        }
        
        return peopleArr;
    }
    
    class People{
        int height, rank;
        public People(int[] people){
            this.height = people[0];
            this.rank = people[1];
        }
        
        @Override
        public String toString(){
            return "Height=" + height + " Rank=" + rank;
        }
    }
}