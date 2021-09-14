package class03;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ryangjun on 2021/8/1.
 * 比较器的使用
 * 1、比较器的实质就是重载比较运算符
 * 2、比较器可以很好的应用在特殊标准的排序上
 * 3、比较器可以很好的应用在根据特殊标准排序的结构上
 */

public class HeapTest {

    public static class Acomp implements Comparator<Integer>{


        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Acomp());
        heap.add(3);
        heap.add(5);
        heap.add(9);
    }

}
