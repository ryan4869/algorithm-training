package class06.leetcode;

import class06.BinaryTree2;

public class Solution {

    public boolean isValidBST(TreeNode treeNode){
        ReturnType res = process(treeNode);
        return res.isVaildBST;
    }

    public class ReturnType{
        boolean isVaildBST;
        int min;
        int max;

        public ReturnType(boolean isVaildBST, int min, int max) {
            this.isVaildBST = isVaildBST;
            this.min = min;
            this.max = max;
        }
    }

    public ReturnType process(TreeNode x){
        if (x==null){
            return null;
        }
        int min = x.val;
        int max = x.val;
        ReturnType resultLeft = process(x.left);
        ReturnType resultRight = process(x.right);
        if (resultLeft != null){
            min = Math.min(resultLeft.min,x.val);
            max = Math.max(resultLeft.max,x.val);
        }
        if (resultRight != null){
            min = Math.min(resultRight.min,x.val);
            max = Math.max(resultRight.max,x.val);
        }
        if (resultLeft!=null && (!resultLeft.isVaildBST || resultLeft.max>=x.val)){
            return new ReturnType(false,x.val,x.val);
        }
        if (resultRight!=null && (!resultRight.isVaildBST || resultRight.min<=x.val)){
            return new ReturnType(false,x.val,x.val);
        }
        return new ReturnType(true,min,max);
    }
}
