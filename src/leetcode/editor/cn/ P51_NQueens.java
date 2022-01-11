//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 
// 👍 1139 👎 0

 
package leetcode.editor.cn;
 
//N 皇后

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

class P51_NQueens{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P51_NQueens().new Solution();
		 System.out.println(solution.solveNQueens(4));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int solveNQueens(int n) {

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