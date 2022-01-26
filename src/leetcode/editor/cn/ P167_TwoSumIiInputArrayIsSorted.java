//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。 
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 104 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 623 👎 0

 
package leetcode.editor.cn;
 
//两数之和 II - 输入有序数组

/**
 * P1 两数之和 --> 哈希表
 * P167 两数之和 已按照非递减顺序排序
 */
class P167_TwoSumIiInputArrayIsSorted{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P167_TwoSumIiInputArrayIsSorted().new Solution();

	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] res = new int[2];
    	process(0,numbers.length-1,numbers,target,res);
    	return res;
    }

    public void process(int left, int right, int[] numbers,int target,int[] res){
    	if (left >= right){
    		return;
		}
    	if (numbers[left]+numbers[right]==target){
    		res[0] = left+1;
    		res[1] = right+1;
		}else if (numbers[left]+numbers[right]>target){
			process(left,--right,numbers,target,res);
		}else {
    		process(++left,right,numbers,target,res);

		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}