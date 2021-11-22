package class06;


import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.math.BigDecimal;
import java.util.HashMap;

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

    //如何判断一颗二叉树是否是搜索二叉树？ 递归
    public static ReturnTypeBST isBST(Node head) {

        if (head == null) {
            return null;
        }
        ReturnTypeBST returnTypeLeft = isBST(head.left);
        ReturnTypeBST returnTypeRight = isBST(head.right);
        int min = head.value;
        int max = head.value;
        if (returnTypeLeft!=null){
            min = Integer.min(head.value,returnTypeLeft.min);
            max = Integer.max(head.value,returnTypeLeft.max);
        }
        if (returnTypeRight!=null){
            min = Integer.min(head.value,returnTypeRight.min);
            max = Integer.max(head.value,returnTypeRight.max);
        }
        if (returnTypeLeft!=null && returnTypeRight!=null
                && returnTypeLeft.max<head.value && returnTypeRight.min>head.value){
            return new ReturnTypeBST(true,min,max);
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
        //System.out.println(isBST(head).isFlag);



    }
}
