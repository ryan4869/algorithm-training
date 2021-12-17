//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 550 👎 0

 
package leetcode.editor.cn;
 
//01 矩阵

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class P542_Zero1Matrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P542_Zero1Matrix().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dist = new int[m][n];
		boolean[][] seen = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<int[]>();
		// 将所有的 0 添加进初始队列中
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[]{i, j});
					seen[i][j] = true;
				}
			}
		}

		// 广度优先搜索
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int i = cell[0], j = cell[1];
			for (int d = 0; d < 4; ++d) {
				int ni = i + dirs[d][0];
				int nj = j + dirs[d][1];
				if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
					dist[ni][nj] = dist[i][j] + 1;
					queue.offer(new int[]{ni, nj});
					seen[ni][nj] = true;
				}
			}
		}

		return dist;
	}
	 **/

	public int[][] updateMatrix(int[][] matrix) {
		int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

		int m = matrix.length, n = matrix[0].length;
		int[][] dist = new int[m][n];
		boolean[][] seen = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n ; j++) {
				if (matrix[i][j] == 0){
					queue.add(new int[]{i,j});
					dist[i][j] = 0;
					seen[i][j] = true;
				}
			}
		}

		// 广度优先搜索
		while (!queue.isEmpty()){
			int[] cell = queue.poll();
			int i = cell[0];
			int j = cell[1];
			// 相邻上下左右四个方向
			for (int k = 0; k < dirs.length; k++) {
				int ni = i+dirs[k][0];
				int nj = j+dirs[k][1];
				if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]){
					dist[ni][nj] = dist[i][j]+1;
					queue.add(new int[]{ni,nj});
					seen[ni][nj] = true;
				}
			}
		}
		return dist;
	}

	class Solution2 {

		public int[][] updateMatrix(int[][] matrix) {
			int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			int m = matrix.length, n = matrix[0].length;
			// 初始化动态规划的数组，所有的距离值都设置为一个很大的数
			int[][] dist = new int[m][n];
			for (int i = 0; i < m; ++i) {
				Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
			}
			// 如果 (i, j) 的元素为 0，那么距离为 0
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (matrix[i][j] == 0) {
						dist[i][j] = 0;
					}
				}
			}
			// 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (i - 1 >= 0) {
						dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
					}
					if (j - 1 >= 0) {
						dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
					}
				}
			}
			// 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
			for (int i = m - 1; i >= 0; --i) {
				for (int j = 0; j < n; ++j) {
					if (i + 1 < m) {
						dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
					}
					if (j - 1 >= 0) {
						dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
					}
				}
			}
			// 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
			for (int i = 0; i < m; ++i) {
				for (int j = n - 1; j >= 0; --j) {
					if (i - 1 >= 0) {
						dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
					}
					if (j + 1 < n) {
						dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
					}
				}
			}
			// 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
			for (int i = m - 1; i >= 0; --i) {
				for (int j = n - 1; j >= 0; --j) {
					if (i + 1 < m) {
						dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
					}
					if (j + 1 < n) {
						dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
					}
				}
			}
			return dist;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}