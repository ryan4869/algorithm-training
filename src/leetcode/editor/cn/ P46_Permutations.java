//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//     1             2            3
//   /   \         /   \        /   \
// 1,2   1,3     2,1   2,3    3,1   3,2
// 3 2
//
//  2
// 1 3
// 3 1
//
//  3
// 1 2
// 2 1
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1689 👎 0

 
package leetcode.editor.cn;
 
//全排列

import java.util.ArrayList;
import java.util.List;

class P46_Permutations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P46_Permutations().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		boolean[] include = new boolean[nums.length];
		dfs(path,include,nums,res);
    	return res;
    }

    public void dfs(List<Integer> path, boolean[] include,int[] nums,List<List<Integer>> res){
    	if (path.size() == nums.length){
    		res.add(path);
    		return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!include[i]){
				List<Integer> newPath = new ArrayList<>(path);
				newPath.add(nums[i]);
				boolean[] newInclude = new boolean[nums.length];
				System.arraycopy(include,0,newInclude,0,include.length);
				newInclude[i] = true;
				dfs(newPath,newInclude,nums,res);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}