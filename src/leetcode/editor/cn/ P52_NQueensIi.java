//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 回溯 
// 👍 323 👎 0

 
package leetcode.editor.cn;
 
//N皇后 II
 
class P52_NQueensIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P52_NQueensIi().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
		return process(0, new int[n], n);
    }
	public int process(int i,int[] record,int n){
		int res = 0;
		if (i==n){
			return 1;
		}
		for (int j = 0; j < n ; j++) {
			if (isValid(record,i,j)){
				record[i] = j;
				res += process(i+1,record,n);
			}

		}
		return res;
	}

	public boolean isValid(int[] record,int row,int col){
		for (int i = 0; i < row ; i++) {
			if (record[i] == col || Math.abs(col-record[i]) == Math.abs(row-i)){
				return false;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}