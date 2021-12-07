//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 365 👎 0

 
package leetcode.editor.cn;
 
//有序数组的平方
 
class P977_SquaresOfASortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P977_SquaresOfASortedArray().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] sortedSquares(int[] nums) {
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
//leetcode submit region end(Prohibit modification and deletion)

}