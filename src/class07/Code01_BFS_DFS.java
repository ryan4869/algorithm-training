package class07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code01_BFS_DFS {



    public void bfs(Node head){
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashSet<Node> hashSet = new HashSet<>();
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            for (Node node: poll.next) {
                if (!hashSet.contains(node)){
                    queue.add(node);
                    System.out.println(node.value);
                }
            }
        }

    }

    public void dfs(Node head){
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        System.out.println(head.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node node: cur.next) {
                if (!set.contains(node)){
                    stack.push(cur);
                    stack.push(node);
                    set.add(node);
                    System.out.println(node.value);
                    break;
                }
            }
        }
    }


}
