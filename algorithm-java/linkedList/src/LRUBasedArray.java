import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray<T> {
    private int capacity;
    private int count;
    private T[] value;
    private Map<T, Integer> holder;
    private static final int DEFAULT_CAPACITY = (1 << 3);

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }
    
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }
    
    public void cache(T object, int end) {
        rightShift(end);
        value[0]=object;
        holder.put(object,0);
        count++;
    }

    public void removeAndCache(T object){
        T key=value[--count];
        holder.remove(key);
        cache(object,count);
    }

    public void update(int end){
        T target=value[end];
        rightShift(end);
        value[0]=target;
        holder.put(target,0);
    }

    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("不支持null");
        }
        Integer index = holder.get(object);
        if (index==null){
            if(isFull()){
                removeAndCache(object);
            }else {
                cache(object,count);
            }
        }else {
            update(index);
        }
    }

    /*
    以下是测试用例
     */
    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}




