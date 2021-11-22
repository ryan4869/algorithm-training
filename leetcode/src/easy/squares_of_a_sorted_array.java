package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class squares_of_a_sorted_array {

    public static void main(String[] args) {
        int[] nums = {-1};
        int[] sortedSquares = sortedSquares(nums);
        for (int i = 0; i < sortedSquares.length; i++) {
            System.out.println(sortedSquares[i]);
        }

    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int seprate = 0;
        if (nums[0]>=0){
            for (int i = 0; i < nums.length; i++) {
                res[i] = ((int)Math.pow(nums[i],2));
            }
        }else if (nums[nums.length-1]<=0){
            for (int i=0,j = nums.length-1; i < nums.length ; i++,j--) {
                res[j] = ((int)Math.pow(nums[i],2));
            }
        } else {
            for (int i = 0; i < nums.length ; i++) {
                if (nums[i]>=0){
                    seprate = i;
                    break;
                }
            }
            int p = seprate-1;
            int q = seprate;
            int cur = 0;
            while (p>=0 && q<nums.length){

                res[cur++] = (int)Math.pow(Math.abs(nums[p])<nums[q]?Math.abs(nums[p--]):nums[q++],2);
            }
            while (p>=0){
                res[cur++] = (int)Math.pow(nums[p--],2);
            }
            while (q<nums.length){
                res[cur++] = (int)Math.pow(nums[q++],2);
            }
        }
        return res;
    }
}
