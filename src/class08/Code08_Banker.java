package class08;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Code08_Banker {
    class Node{
        int p;
        int c;

        public Node() {
        }

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c-o2.c;
        }
    }

    public class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p-o1.p;
        }
    }

    public int findMax(List<Node> nodes,int initial,int k){
        PriorityQueue<Node> costs = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> profits = new PriorityQueue<>(new MaxProfitComparator());
        nodes.forEach(p->{
            costs.add(p);
        });
        for (int i = 0; i < k; i++) {
            while (initial >= costs.peek().c){
                profits.add(costs.poll());
            }
            if (profits.isEmpty()){
                break;
            }
            initial += profits.poll().p;
        }
        return initial;
    }


}
