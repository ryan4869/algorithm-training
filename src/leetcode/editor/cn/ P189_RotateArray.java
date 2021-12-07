//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1226 👎 0

 
package leetcode.editor.cn;
 
//轮转数组
 
class P189_RotateArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P189_RotateArray().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void rotate(int[] nums, int k) {
		//数组翻转
		if (k == 0 || k%nums.length == 0){
			return;
		}
		k = k%nums.length;
		revert(nums,0,Math.abs(nums.length-k-1)%nums.length);
		revert(nums,Math.abs(nums.length-k)%nums.length,nums.length-1);
		revert(nums,0,nums.length-1);
	}

	public void revert(int[] nums,int left,int right){
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
//leetcode submit region end(Prohibit modification and deletion)

}