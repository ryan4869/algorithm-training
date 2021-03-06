package class05;

import java.util.*;

public class BinaryTree {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    //前序遍历 递归
    public static void preOrder(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }

    //前序遍历 非递归
    public static void preOrderUnRecur(Node head){
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        System.out.println(cur.value);
        cur = cur.left;
        while (!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                System.out.println(cur.value);
                cur = cur.left;
            }
            Node pop = stack.pop();
            if (pop.right != null){
                cur = pop.right;
                stack.push(cur);
                System.out.println(cur.value);
                cur = cur.left;
            }
        }
    }

    //中序遍历 递归
    public static void inOrder(Node head){
        if (head == null){
            return;
        }
        inOrder(head.left);
        System.out.println(head.value);
        inOrder(head.right);
    }

    //中序遍历 非递归
    public static void inOrderUnRecur(Node head){
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        cur = cur.left;
        while (!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            Node pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null){
                cur = pop.right;
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    public static void postOrder(Node head){
        if (head == null){
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);


//        inOrder(head);
//        postOrder(head);
//        w(head);
        System.out.println(getMaxWidth2(head));

    }

//    二叉树的宽度优先遍历
    public static void w(Node head){

        if (head == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }


        }

    }

    //求一棵二叉树的最大宽度
    public static int getMaxWidth(Node head){

        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        int curLevel = 1;//当前在哪一层
        int curLevelNodes = 0;//当前层发现了几个结点
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            Integer curNodeLevel = levelMap.get(poll);
            if (curLevel == curNodeLevel){
                curLevelNodes++;
            }else {
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

//            System.out.println(poll.value);

            if (poll.left != null){

                queue.add(poll.left);
                levelMap.put(poll.left,curNodeLevel+1);

            }
            if (poll.right != null){
                queue.add(poll.right);
                levelMap.put(poll.right,curNodeLevel+1);
            }


        }
        return max;
    }



    //求一棵二叉树的最大宽度（不用hashmap）
    public static int getMaxWidth2(Node head){

        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curLevelEnd = head;
        Node nextLevelEnd = null;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            curLevelNodes++;
            if (cur.left!=null){
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                nextLevelEnd = cur.right;

            }
            if (cur == curLevelEnd){
                max = curLevelNodes;
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
                curLevelNodes = 0;

            }
        }
        return max;

    }


}
