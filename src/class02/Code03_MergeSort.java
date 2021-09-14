package class02;

/**
 *
 * 二路归并排序
 * Created by ryangjun on 2021/7/27.
 *
 *
 */
public class Code03_MergeSort {

    public static void main(String[] args) {

        int arr[] = {3,5,1,4,6,2,7,8};
        process(arr,0,arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void process(int arr[], int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int arr[], int L,int M,int R){


        int help[] = new int[R-L+1];
        int i = 0;
        int p = L;
        int q = M+1;
        while (p <= M && q <= R){
            if (arr[p] <= arr[q]){
                help[i++] = arr[p++];
            }else {
                help[i++] = arr[q++];
            }
        }

        while(p <= M){
            help[i++] = arr[p++];
        }

        while(q <= R){
            help[i++] = arr[q++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
        }
    }
}
