 public class Interval {
      public int start;
      public int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      public int getEnd(){return end;}
      @Override
      public String toString(){
      	return "("+start+","+end+")";
      }
 }
 
