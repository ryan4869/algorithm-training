package class08;

import java.util.PriorityQueue;

/**
 * 哈夫曼树
 */
public class Code04_LessMoney {
// 60  10 20 30
    public int LessMoney(int[] arr){
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size()>1){
            int cur = queue.poll() + queue.poll();
            result += cur;
            queue.add(cur);
        }
        return result;
    }
}
