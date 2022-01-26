package class03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
// i  2i+1

    /**
     * 向上调整成大根堆
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //   1
    //  3 6
    // 8

    public static void heapify(int[] arr,int index, int heapSize){
        while (index*2+1 < heapSize){
            // 找到左右孩子里较大的
            int maxIndex = (index*2+2 >= heapSize || arr[index*2+1] > arr[index*2+2]) ? index*2+1 : index*2+2;
            if (arr[index] < arr[maxIndex]){
                swap(arr,index,maxIndex);
            }else {
                break;
            }
            index = maxIndex;
        }
    }

    public static void heapSort(int[] arr,int heapSize){
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//            heapSize++;
//        }

        for (int i = arr.length-1; i >=0 ; i--) {
            heapify(arr,i,arr.length);
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0) {
            heapify(arr,0,heapSize--);
            swap(arr,0,heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,8};
//        Heap.heapSort(arr,arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        for (int i = 0; i <arr.length ; i++) {
            heapInsert2(arr,i);
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void heapInsert2(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void sortedArrayDistanceLessK(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; // 降序
            }
        });
        int index = 0;
        for (; index  <k ; index++) {
            queue.add(arr[index]);
        }
        int i = 0;
        while (index<arr.length){
            queue.add(arr[index++]);
            arr[i++] = queue.poll();
        }
        while (!queue.isEmpty()){
            arr[i++] = queue.poll();
        }
    }
}
