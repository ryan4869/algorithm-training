package class05;

import java.util.Collection;
import java.util.Stack;

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
        postOrder(head);

    }


}
