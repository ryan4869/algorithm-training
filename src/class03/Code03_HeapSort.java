package class03;

/**
 * Created by ryangjun on 2021/8/1.
 * 堆
 * 1、堆结构就是用数组实现的完全二叉树结构
 * 2、完全二叉树中如果每棵子树的最大值都在顶部就是大根堆
 * 3、完全二叉树中如果每棵子树的最小值都在顶部就是小根堆
 * 4、堆结构的heapInsert和heapify操作
 * 5、堆结构的增大和减少
 * 6、优先级队列结构，就是堆结构
 */
public class Code03_HeapSort {
    public static void main(String[] args) {
        int arr[] = {3,4,5,2,6,1,7,5,8,2,9};
        heapSort(arr,0);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void heapInsert(int arr[],int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapify(int arr[],int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            int largest = left+1<heapSize && arr[left]<arr[left+1]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if (largest==index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;
        }
    }

    public static void swap(int arr[],int a,int b){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

    public static void heapSort(int arr[],int heapSize){
        for (int i = 0; i <arr.length ; i++) {
            heapInsert(arr,i);
            heapSize++;
        }
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr,0,i);
            heapSize--;
            heapify(arr,0,heapSize);
        }
    }
}
