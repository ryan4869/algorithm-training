//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 排序 
// 👍 594 👎 0

 
package leetcode.editor.cn;
 
//存在重复元素

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class P217_ContainsDuplicate{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P217_ContainsDuplicate().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums.length ; i++) {
			if (hashSet.contains(nums[i])){
				return true;
			}else {
				hashSet.add(nums[i]);
			}
		}
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}