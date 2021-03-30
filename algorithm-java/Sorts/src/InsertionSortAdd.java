import java.util.Arrays;

public class InsertionSortAdd {
    private static void fromStartToEnd(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            int[] tmp = new int[2];
            int change = i;
            for (int j = 0; j < i; j++) {
                if (value > data[i]) {
                    continue;
                }
                int index = j % 2;
                if (change == 1) {
                    tmp[Math.abs(index - 1)] = data[j];
                    change = j;
                }
                tmp[index] = data[j + 1];
                if (0 == index) {
                    data[j + 1] = tmp[index + 1];
                } else {
                    data[j + 1] = tmp[index - 1];
                }
            }
            data[change] = value;
        }
    }

    //另一种做法，可读性更好，但空间复杂度有所增大
    public class InsertSort2 {

        public int[] sort(int[] sourceArray) throws Exception {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

            // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
            for (int i = 1; i < arr.length; i++) {

                // 记录要插入的数据
                int tmp = arr[i];

                // 从已经排序的序列最右边的开始比较，找到比其小的数
                int j = i;
                while (j > 0 && tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }

                // 存在比其小的数，插入
                if (j != i) {
                    arr[j] = tmp;
                }

            }
            return arr;
        }
    }
}
