package class07;

import java.util.*;

public class Code03_Kruskal {
    /**
     * kruskal算法
     * 适用范围：要求无向图
     */

    public class MySets{
        public HashMap<Node, List<Node>> setMap;

        // 初始化，收集所有点集
        public MySets(List<Node> nodes) {
            for (Node cur: nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }

        // 判断起点和终点是否在一个集合中 --> 可用并查集优化
        public boolean isSameSet(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        // 合并点集
        public void union(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode: toSet) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }

    }

    public static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public Set<Edge> kruskal(Graph graph){
        Set<Edge> result = new HashSet<>();
        // 生成hashmap
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        // 选择最小的边 --> 小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge: graph.edges) {
            priorityQueue.add(edge);
        }
        Edge head = priorityQueue.poll();
        result.add(head);
        while (!priorityQueue.isEmpty()){
            Edge cur = priorityQueue.poll();
            // 如果不是一个集合中的点 添加这条边到结果集， 并合并点集
            if (!mySets.isSameSet(cur.from,cur.to)){
                mySets.union(cur.from,cur.to);
                result.add(cur);
            }
        }
        return result;
    }

}
