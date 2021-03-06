import com.sun.source.tree.BreakTree;

public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;
    public CircularQueue(int capacity){
        items=new String[capacity];
        n=capacity;
    }

    public boolean enqueue(String item){
        if((tail+1)%n==head){
            return false;
        }
        items[tail]=item;
        tail=(tail+1)%n;
        return true;
    }

    public String dequeue(){
        if(head==tail){
            return null;
        }
        String ret=items[head];
        head=(head+1)%n;
        return ret;
    }

    public void printAll(){
        if(n==0){
            return;
        }
        for (int i = head;i%n!=tail; i=(i+1)%n){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }
}
