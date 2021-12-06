//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1206 👎 0

 
package leetcode.editor.cn;
 
//搜索插入位置
 
class P35_SearchInsertPosition{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P35_SearchInsertPosition().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
    	return process(0,nums.length-1,nums,target);
    }
	public int process(int left, int right, int[] nums,int target){
		if (left >= right){
			if (nums[left]>target){
				return left;
			}else if (nums[left]<target){
				return left+1;
			}
		}
		int mid = left + ((right-left) >> 1);
		if (target < nums[mid]){
			return process(left,mid-1,nums,target);
		}
		if (target > nums[mid]){
			return process(mid+1,right,nums,target);
		}
		return mid;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}