public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null){
            return null;
        }
        //get critical points
        Point[] points = new Point[2 * buildings.length];
        for(int i = 0; i < buildings.length; i++){
            points[2 * i] = new Point(buildings[i][0], buildings[i][2], false);
            points[2 * i + 1] = new Point(buildings[i][1], buildings[i][2], true);
        }
        
        //sort points
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.x - p2.x;
            }
        });
        
        
        //height queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        
        //go through points, skip overlap x .
        List<int[]> list = new LinkedList<>();
        int preHeight = 0;
        for(int i = 0; i < points.length; i++){
            //System.out.println(queue);
            //System.out.println(points[i]);
            
            if(!points[i].isExit){
                queue.offer(points[i].y);
            }else{
                queue.remove(points[i].y);
            }
            
            //jump over overlap x points
            if(i + 1 < points.length && points[i + 1].x == points[i].x){
                continue;
            }
           
            if(preHeight != queue.peek()){
                //height change. add to rst list
                list.add(new int[]{points[i].x, queue.peek()});
            }
            preHeight = queue.peek();
        }
        
        return list;
    }
    
    class Point{
        int x, y;
        boolean isExit;
        public Point(int x, int y, boolean isExit){
            this.x = x;
            this.y = y;
            this.isExit = isExit;
        }
        
        @Override
        public String toString(){
            return "[" + x + "," + y + "," + (isExit? "e" : "s")+"]";
        }
    }
}