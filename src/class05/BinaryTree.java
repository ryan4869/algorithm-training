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

    public static void preOrder(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void preOrderUnRecur(Node head){

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        System.out.println(head.value);
        head = head.left;
        while (!stack.isEmpty()){
            while (head!=null){
                stack.push(head);
                System.out.println(head.value);
                head = head.left;
            }
            Node pop = stack.pop();
            if (pop.right != null){
                stack.push(pop.right);
            }

        }


    }



    public static void inOrder(Node head){
        if (head == null){
            return;
        }
        inOrder(head.left);
        System.out.println(head.value);
        inOrder(head.right);
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


        inOrder(head);

    }


}
