public class MergeSort {
    private static void merge(int[] a,int p,int q,int r){
        int i=p;
        int j=q+1;
        int k=0;
        int[] tmp=new int[r-p+1];
        while (i<=q&&j<=r){
            if(a[i]<=a[j]){
                tmp[k++]=a[i++];
            }else {
                tmp[k++]=a[j++];
            }
        }
        int start=i;
        int end=q;
        if(j<=r){
            start=j;
            end =r;
        }
        while (start<=end){
            tmp[k++]=tmp[i];
        }
        for (int l = 0; l < r - p; l++) {
            a[p+i]=tmp[l];
        }
    }

    private static void mergeSortInternally(int[] a,int p,int r){
        if(p>=r){
            return;
        }
        int q=p+(r-p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    public static void mergeSort(int[] a,int n){
        mergeSortInternally(a,0,n-1);
    }

    private static void mergeBySentry(int[] arr,int p,int q,int r){
        int[] leftArr=new int[q-p+2];
        int[] rightArr=new int[r-q+1];
        for (int i = 0; i < q - p; i++) {
            leftArr[i]=arr[p+i];
        }
        leftArr[q-p+1]=Integer.MAX_VALUE;
        for (int i = 0; i < r - q; i++) {
            rightArr[i]=arr[q+1+i];
        }
        rightArr[r-q]=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int k=p;
        while (k<=r){
            if(leftArr[i]<=rightArr[j]){
                arr[k++]=leftArr[i++];
            }else {
                arr[k++]=rightArr[j++];
            }
        }
    }
}
