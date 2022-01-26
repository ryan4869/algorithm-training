//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 641 👎 0

 
package leetcode.editor.cn;
 
//矩阵置零

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.HashSet;

class P73_SetMatrixZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P73_SetMatrixZeroes().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {

		/**
		 * // 方法一：
		 * // 空间复杂度 m+n
		 * 		HashSet<Integer> rowSet = new HashSet<>();
		 * 		HashSet<Integer> colSet = new HashSet<>();
		 * 		int m = matrix.length;
		 *     	int n = matrix[0].length;
		 * 		for (int i = 0; i < m; i++) {
		 * 			for (int j = 0; j < n; j++) {
		 * 				if (matrix[i][j] == 0){
		 * 					rowSet.add(i);
		 * 					colSet.add(j);
		 *                                }* 			}
		 * 		}
		 * 		for (int i = 0; i < m; i++) {
		 * 			for (int j = 0; j < n; j++) {
		 * 				if (rowSet.contains(i) || colSet.contains(j)) {
		 * 					matrix[i][j] = 0;
		 *                }* 			}
		 * 		}
		 **/

		// 方法二
		// 空间复杂度 O(1)  >>>> 没想到
		// 用matrix第一行和第一列记录该行该列是否有0
		// 对于第一行,和第一列要设置一个标志位,为了防止自己这一行(一列)也有0的情况
		// 第一行有0的情况，会把这一行刷成0，导致往后遍历时，
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row = false;
		boolean col = false;
		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0){
					if (i == 0){ // 第一行有0
						row = true;
					}
					if (j == 0){ // 第一列有0
						col = true;
					}
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m ; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0){
					// 先从第二行第二列开始处理
					matrix[i][j] = 0;
				}
			}
		}
		if (row){
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (col){
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}