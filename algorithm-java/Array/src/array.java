import org.junit.Test;

import java.sql.Array;

public class array {
    public int data[];
    private int n;
    private int count;

    public array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    public boolean insert(int index, int value) {
        //应该首先判断array是否有空位提供插入
        if (count >= n) {
            System.out.println("数组已满");
            return false;
        }
        if (index < 0 || index > n) {
            System.out.println("索引错误，无法插入");
            return false;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        //需要将数组个数count加一
        count++;
        //因为是Boolean函数，必须有返回值
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= n) {
            System.out.println("位置不合法");
            return false;
        }
        //不能动最后一个数字，因为这样会导致内存溢出
//        for (int i = index; i <n-1 ; i++) {
//            data[i]=data[i+1];
//        }
        for (int i = index + 1; i < n; i++) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        array array = new array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        //array.insert(1, 5);
        //array.insert(3, 9);
        array.insert(3, 10);
        array.delete(0);
        array.printAll();
        System.out.println(array.find(0));
        array.insert(0, 4);
        array.delete(3);
        //array.insert(3, 11);
        array.printAll();
    }
}

