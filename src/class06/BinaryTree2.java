package class06;


import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by ryangjun on 2021/10/7.
 */
public class BinaryTree2 {

    //    二叉树的相关概念及其实现判断
//    如何判断一颗二叉树是否是搜索二叉树？
//    如何判断一颗二叉树是完全二叉树？
//    如何判断一颗二叉树是否是满二叉树？
//    如何判断一颗二叉树是否是平衡二叉树？
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

    public static class ReturnTypeBST{
        boolean isFlag;
        int min;
        int max;

        public ReturnTypeBST() {
        }

        public ReturnTypeBST(boolean isFlag, int min, int max) {
            this.isFlag = isFlag;
            this.min = min;
            this.max = max;
        }
    }

    //如何判断一颗二叉树是否是搜索二叉树？ 递归 動態檢查
    public static int preValue = Integer.MIN_VALUE;
    public static boolean checkBST(Node head){
        if (null == head){
            return true;
        }
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST){
            return false;
        }
        if (head.value <= preValue){
            return false;
        }else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean checkBST2(Node head){
        List<Node> inOrderList = new ArrayList<>();
        process2(head,inOrderList);
        for (int i = 0; i < inOrderList.size()-1; i++) {
            if (inOrderList.get(i).value >= inOrderList.get(i+1).value){
                return false;
            }
        }
        return true;
    }

    public static void process2(Node head, List<Node> inOrderList){
        if (null == head){
            return;
        }
        process2(head.left,inOrderList);
        inOrderList.add(head);
        process2(head.right,inOrderList);
    }

    // 非遞歸中序遍歷
    public static boolean checkBST3(Node head){
        Stack<Node> stack = new Stack<>();
        int preValue = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head!=null){
            if (head!=null){
                stack.push(head);
                head = head.left;
            }
            else {
                Node pop = stack.pop();
//                System.out.println(pop.value);
                if (pop.value <= preValue){
                    return false;
                }else {
                    preValue = pop.value;
                }
                head = pop.right;
            }
        }
        return true;
    }

    //如何判断一颗二叉树是否是搜索二叉树？ 递归
    public static ReturnTypeBST isBST(Node head) {

        if (head == null) {
            return null;
        }
        ReturnTypeBST returnTypeLeft = isBST(head.left);
        ReturnTypeBST returnTypeRight = isBST(head.right);
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (returnTypeLeft!=null){
            leftMax = returnTypeLeft.max;
        }
        if (returnTypeLeft!=null){
            rightMin = returnTypeRight.min;
        }

        if ((returnTypeLeft == null || (returnTypeLeft!=null&& returnTypeLeft.isFlag))
                && (returnTypeRight == null || (returnTypeRight!=null&& returnTypeRight.isFlag))
                && returnTypeLeft.max<head.value && returnTypeRight.min>head.value){
            return new ReturnTypeBST(true,head.value,head.value);
        }
        return new ReturnTypeBST(false,head.value,head.value);
    }


    public static class ReturnType{
        boolean isBalanced;
        int height;

        public ReturnType() {
        }

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }

    }

    public static ReturnType checkBalanced(Node head){
        if (head == null){
            return new ReturnType(true,0);
        }
        ReturnType returnTypeLeft = checkBalanced(head.left);

        ReturnType returnTypeRight = checkBalanced(head.right);

        int height = Math.max(returnTypeLeft.height,returnTypeRight.height)+1;
        if (returnTypeLeft.isBalanced && returnTypeRight.isBalanced
                && Math.abs(returnTypeLeft.height-returnTypeRight.height)<=1){
            return new ReturnType(true,height);
        }

        return new ReturnType(false,height);

    }

    //1任一節點，有右無左false
    //2在1不違規條件下，如果遇到了第一個左右子不全，後續皆葉
    public static boolean isCBT(Node head){
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            l = poll.left;
            r = poll.right;

            if (leaf && (l !=null || r !=null)){
                return false;
            }
            if (l == null && r !=null){
                return false;
            }
            if (l!=null){
                queue.add(l);
            }
            if (r!=null){
                queue.add(r);
            }
            if (l == null || r == null){
                leaf = true;
            }
        }
        return true;
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
        System.out.println(checkBST(head));
        System.out.println(checkBST2(head));
        System.out.println(checkBST3(head));
        System.out.println(isCBT(head));
    }
}
