package class03;

import java.util.PriorityQueue;

/**
 * Created by ryangjun on 2021/8/1.
 * 堆排序扩展题目
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 */
public class Code04_SortArrayDistanceLessK {

    public static void main(String[] args) {
        int arr[] = {2,1,4,5,3,6,7};
        sortedArrDistanceLessK(arr,3);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void sortedArrDistanceLessK(int arr[],int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i <= Math.min(arr.length,k) ; i++) {
            heap.add(arr[i]);
        }
        int i = 0;
        for (i = 0; i+k+1 < arr.length; i++) {
            arr[i] = heap.poll();
            heap.add(arr[i+k+1]);
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }



}
