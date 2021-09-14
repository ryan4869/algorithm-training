package class02;

/**
 * Created by ryangjun on 2021/7/28.
 *
 * 题目二
 * 小和问题和逆序对问题
 *
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和，求一个数组的小和。
 * 例子:[1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1，3，4，2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * 逆序对问题
 * 在一个数组中，左边的数如果比右边的数大，则称两个数构成一个逆序对，请打印所有逆序对。
 *
 */
public class Code_ {
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,5};
        /**
         *
         */
        process(arr,0,arr.length-1);
    }

    public static void process(int arr[],int L,int R){
        if (L == R){
            return;
        }
        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int arr[],int L,int M,int R){
        int help[] = new int[R-L+1];
        int p = L;
        int q = M+1;
        int i = 0;
        while(p <= M && q <= R){
            if (arr[p] < arr[q]){
                help[i++] = arr[p++];
            }else {
                int p2 = p;
                while(p2 <= M){
                    System.out.println("("+arr[p2++]+","+arr[q]+")");
                }

                help[i++] = arr[q++];
            }

        }
        while(p <= M){
            int q2 = M +1;
            while(q2 <= R){
                System.out.println("("+arr[p]+","+arr[q2++]+")");

            }
            help[i++] = arr[p++];
        }
        while(q <= R){
            help[i++] = arr[q++];
        }
        i = 0;
        while (i < help.length) {
            arr[L++] = help[i++];
        }
    }

}
