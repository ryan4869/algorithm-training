package class03;

import java.util.Random;

public class Code06_QuickSort {

    public static void main(String[] args) {
        int arr[] = {3,5 ,6, 3, 4, 5, 2, 6, 9, 0};
        quickSort(arr,0,arr.length-1);
        printArr(arr);
    }

    public static void quickSort(int arr[],int L,int R){
        if (L >= R){
            return;
        }
        int help[] = partition(arr,L,R);
        quickSort(arr,L,help[0]-1);
        quickSort(arr,help[1]+1,R);

    }

    public static int[] partition(int arr[], int L, int R ){
        //(3 5 6 3 4 5 2 6 9  0)
        //p 左边界 q 右边界
        int bound[] = new int[2];
        int p = L;
        int q = R;

        int pos = L + (int) (Math.random()*(R-L+1));
        int num = arr[pos];

        int i = p;
        while (i <= q) {
            if (arr[i]<num){
                swap(arr,i,p);
                i++;
                p++;
            }else if (arr[i]>num){

                swap(arr,i,q);
                q--;

            }else {
                i++;
            }
        }
        bound[0] = p;
        bound[1] = q;
        return bound;

    }

    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
