package class07;

import class07.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 深度优先
 * 宽度优先
 * 拓扑
 * kruskal
 * prim
 * 迪杰斯特拉
 */
public class Graph {
    // 点集
    HashMap<Integer, Node> nodes;
    // 边集
    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
