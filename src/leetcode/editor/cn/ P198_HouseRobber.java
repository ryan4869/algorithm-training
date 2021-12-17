//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]   递归公式 ： f(n) = max(f(n-1),f(n-2)+arr[n])
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 
// 👍 1775 👎 0

 
package leetcode.editor.cn;
 
//打家劫舍
 
class P198_HouseRobber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P198_HouseRobber().new Solution();
	 	 int[] nums = {2,7,9,3,1};
		 System.out.println(solution.rob(nums));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	 	// 非递归 参考P509 斐波那契数列
    public int rob(int[] nums) {
//	 		return process(nums,nums.length-1);
		if (nums.length == 1){
			return nums[0];
		}

		// f(n) = max(f(n-1) + f(n-2)+nums[n])
		int p = 0, q = nums[0], r = Math.max(nums[0],nums[1]);
		for (int i = 2; i < nums.length; ++i) {
			p = q;
			q = r;
			r = Math.max(p+nums[i],q);
		}
		return r;
		}
    }


	/**
	 * @param nums
	 * @param i
	 * @return
	 */
	/**
	 // 递归可实现 但超时了
    public int process(int[] nums,int i){
	 		if (i == 0){
	 			return nums[0];
			}
	 		if (i == 1){
	 			return Math.max(nums[0],nums[1]);
			}
		return Math.max(process(nums, i - 1), process(nums, i - 2) + nums[i]);
	}
	 */
//leetcode submit region end(Prohibit modification and deletion)

}