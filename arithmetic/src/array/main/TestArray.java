package array.main;

public class TestArray {
    private int num;//大小
    private int data[];
    private int i;//已有数据个数

    public TestArray(int num) {
        this.num=num;
        this.data=new int[num];
    }
    public void add_tail(int x){

        if(i>=0&&i<data.length) data[i]=x;
        i++;
    }

    public void add_head(int x) {
        if(i>=0&&i<data.length) {
            for (int j = i-1; j >=0 ; j--) {
                data[j+1]=data[j];
            }
            data[0]=x;
            i++;
        }
    }

    public int find(int index) {
        if(index>=0&&index<data.length){
            return data[index];
        }else return 0;
    }

    public void delete(int index) {
        if(index>=0&&index<data.length) {
            for (int j = index; j <num ; j++) {
                data[j-1]=data[j];
            }
            i--;
        }
    }

    public void alter(int index, int x) {
        if(index>=0&&index<data.length) data[index]=x;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
