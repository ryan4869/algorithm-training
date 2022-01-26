//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 671 👎 0

 
package leetcode.editor.cn;
 
//杨辉三角

import java.util.ArrayList;
import java.util.List;

class P118_PascalsTriangle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P118_PascalsTriangle().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		// 放入第一行
		List<Integer> first = new ArrayList<>();
		first.add(0,1);
		res.add(first);
		// 从第二行开始循环添加
		for (int i = 1; i < numRows ; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i ; j++) {
				list.add(j,(j-1>=0?res.get(i-1).get(j-1):0) + (j>=i?0:res.get(i-1).get(j)));
			}
			res.add(list);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}