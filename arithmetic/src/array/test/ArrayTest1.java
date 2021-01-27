package array.test;

/*
 * 前面我基于数组的原理引出 JVM 的标记清除垃圾回收算法的核心理念。我不知道你是否使用 Java* 语言，理解 JVM.标记清除垃圾回收算法
 *
 * 大多数主流虚拟机采用可达性分析算法来判断对象是否存活，在标记阶段，会遍历所有 GC ROOTS，* 将所有 GC ROOTS 可达的对象标记为存活。只有当标记工作完成后，清理工作才会开始。 不足：1.效率问题。标记和清理效率都不高，但是当知道只有少量垃圾产生时会很高效。2.空间问题。会产生不连续的内存空间碎片。 二维数组内存寻址： 对于 m * n 的数组，a [ i ][ j ] (i < m,j < n)的地址为： address = base_address + ( i * n + j) * type_size 另外，对于数组访问越界造成无限循环，我理解是编译器的问题，对于不同的编译器，在内存分配时，会按照内存地址递增或递减的方式进行分配。老师的程序，如果是内存地址递减的方式，就会造成无限循环。
 *JVM的标记清理回收算法适用于老年代，在ParNew+CMS回收机制中，CMS就是采用的标记清理回收算法。目的在于提高垃圾回收效率，这一点应该是与作者在本文中提到的数组高效删除的思想是一样的。但CMS的回收过程做了相对应的扩展，步骤为：初始标记，并发标记，重新标记，并发删除。在并发删除后还会进行一次内存空间的调整，为了避免内存碎片。这一步将内存数据移动到连续内存的思想，个人理解也与数组的连续空间有一定的思路契合。
 *
 * 前面我们讲到一维数组的内存寻址公式，那你可以思考一下，类比一下，二维数组的内存寻址公式是
 * 怎样的呢
 * */


import array.main.TestArray;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * 需求：对数组的增删改查
 */
class ArrayTest {
    public static void main(String[] args) {
        TestArray O = new TestArray(7);

        //头部插入元素
        O.add_head(7);
        int[] a1 = {7, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(O.getData()));
        assertArrayEquals(O.getData(),a1);
        //尾部增加元素
        O.add_tail(5);
        int[] a2 = {7, 5, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(O.getData()));
        //assertArrayEquals(O.getData(),a2);

        //头部插入元素
        O.add_head(3);
        int[] a3 = {3, 7, 5, 0, 0, 0, 0};
        System.out.println(Arrays.toString(O.getData()));
        assertArrayEquals(O.getData(),a3);
        //根据数组特性不考虑根据索引进行增加元素

        //尾部增加元素
        O.add_tail(4);
        int[] a4 = {3, 7, 5, 4, 0, 0, 0};
        System.out.println(Arrays.toString(O.getData()));
        assertArrayEquals(O.getData(),a4);

        //根据数组索引进行查找元素
        int a5 = O.find(2);//3
        System.out.println(Arrays.toString(O.getData()));
        System.out.println(a5==5);

        //根据数组索引进行删除元素
        O.delete(3);//4
        int[] a6 = {3, 7, 4, 0, 0, 0, 0};
        System.out.println(Arrays.toString(O.getData()));
        assertArrayEquals(O.getData(),a6);

        //根据数组索引进行修改元素
        O.alter(1, 1);//5
        System.out.println(Arrays.toString(O.getData()));
        int[] a7 = {3, 1, 4, 0, 0, 0, 0};
        //assertArrayEquals(O.getData(),a7);
    }
}
