package class07;

import java.util.*;

/**
 * dijkstra算法
 * 求起点到任意一点的最短距离
 */
public class Code05_Dijkstra {

    public HashMap<Node,Integer> dijkstra(Node head){
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        Set<Node> selected = new HashSet<>();
        distanceMap.put(head,0);
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selected);
        while (minNode != null){
            for (Edge edge: minNode.edges) {
                Node to = edge.to;
                if (distanceMap.get(to) == null){
                    distanceMap.put(to,edge.weight);
                }else {
                    distanceMap.put(to,Math.min(distanceMap.get(to),distanceMap.get(minNode)+edge.weight));
                }
            }
            selected.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selected);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,Set<Node> selected){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry:distanceMap.entrySet()) {
            Node node = entry.getKey();
            Integer value = entry.getValue();
            if (!selected.contains(node) && value<minDistance){
                minNode = node;
                minDistance = value;
            }
        }
        return minNode;
    }

}
