package class07;

import java.util.*;

public class Code02_Topo {

    public void topo(Graph graph){
        Queue<Node> queue = new LinkedList<>();
        // 遍历图 把入度为一的节点放入结果集 并把该节点的边删除
        for (Node node: graph.nodes.values()) {
            if (node.in == 0){
                System.out.println(node.value);
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (Edge edge: cur.edges) {
                edge.to.in--;
                if (edge.to.in == 0){
                    System.out.println(edge.to.value);
                    queue.add(edge.to);
                }
            }
        }

    }
}
