package class06;

import class06.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author:
 * @Date: 2022/01/14/9:12
 * @Description:
 */
public class Conclu {
    @Test
    public void test(){
        Node[] nodes = new Node[5];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(new Random().nextInt());
        }
        Arrays.sort(nodes);
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i].val);
        }
    }

    @Test
    public void test2(){
        Node[] nodes = new Node[5];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(new Random().nextInt(100));
        }

        // 方法二：Array.sort()，参数传comparator接口的匿名实现类对象
//        Arrays.sort(nodes, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o2.val - o1.val;
//            }
//        });

        // 方法一：Node类实现Comparable接口，重写compareTo方法，this-形参o 升序排列；形参o-this 降序排列
        Arrays.sort(nodes);
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i].val);
        }

        int nextInt = new Random().nextInt(); // 返回32位整型数 相减可能会因溢出导致排序结果不正确
        System.out.println(2083873311 - (-2018489191));
    }
}
