package medium;

public class rotate_array {

    public static void main(String[] args) {
        int[] nums = {1,2,3};  // 4 3 2 1 7 6 5 -> 5 6 7 1 2 3 4
//        rotate(nums,3);
        rotate(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        //数组翻转
        if (k == 0 || k%nums.length == 0){
            return;
        }
        k = k%nums.length;
        revert(nums,0,Math.abs(nums.length-k-1)%nums.length);
        revert(nums,Math.abs(nums.length-k)%nums.length,nums.length-1);
        revert(nums,0,nums.length-1);
    }

    public static void revert(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        for (int i = left,j = right; i < right; i++,j--) {
            if (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
