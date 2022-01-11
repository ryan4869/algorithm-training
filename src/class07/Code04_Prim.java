package class07;

import java.util.*;

public class Code04_Prim {
    /**
     * prim算法
     * 适用范围：要求无向图
     */

    public class MySets{
        HashMap<Node, List<Node>> set;
    }

    public Set<Edge> prim(Graph graph){
        Set<Edge> result = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        Set<Node> set = new HashSet<>();

        HashMap<Integer, Node> nodes = graph.nodes;
        for (Node node: nodes.values()) {
            // 头
            if (set.contains(node)){
                set.add(node);
                for (Edge edge: node.edges) {
                    priorityQueue.add(edge);
                }
            }

            while (!priorityQueue.isEmpty()){
                Edge edge = priorityQueue.poll();
                Node node1 = edge.to;
                if (!set.contains(node1)){
                    set.add(node1);
                    result.add(edge);
                    for (Edge edge1: node1.edges) {
                        priorityQueue.add(edge1);
                    }
                }
            }

        }

        return result;
    }
}
