import java.util.*;
class MyStack {
   private Queue<Integer> queue;
   private int num;

    public MyStack(){
        this.queue=new LinkedList<Integer>();
        this.num=0;
    }
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        for(int i=0;i<num;i++){
            queue.offer(queue.poll());
        }
        num++;
    }

    // Removes the element on top of the stack.
    public void pop() {
        num--;
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return num==0;
    }

}