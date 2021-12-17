//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
// [0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//
// [0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 610 👎 0

 
package leetcode.editor.cn;
 
//岛屿的最大面积

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class P695_MaxAreaOfIsland{
	 public static void main(String[] args) {
		 //测试代码
		 Solution solution = new P695_MaxAreaOfIsland().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	 	int[][] dirt = {{0,1},{0,-1},{-1,0},{1,0}};
	 	// 对于每一个坐标进行深度优先搜索遍历
		public int maxAreaOfIsland(int[][] grid) {
			int max = 0;
			int m = grid.length;
			int n = grid[0].length;
			// 优化 对于每一个没遍历过的坐标进行深度优先搜索遍历
			boolean[][] seem = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j]==1 && !seem[i][j]){
						int area = dfs(new int[]{i, j}, grid,seem);
						max = Math.max(max,area);
					}
				}
			}
			return max;
		}


		public int dfs(int[] arr,int[][] grid,boolean[][] seem){
			int area = 1;
			int m = grid.length;
			int n = grid[0].length;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(arr);
			seem[arr[0]][arr[1]] = true;
			while (!queue.isEmpty()){
				int[] poll = queue.poll();
				for (int i = 0; i < dirt.length ; i++) {
					int rx = poll[0] + dirt[i][0];
					int ry = poll[1] + dirt[i][1];
					if (rx>=0 && rx<m && ry>=0 && ry<n && grid[rx][ry]==1 && !seem[rx][ry]){
						queue.add(new int[]{rx,ry});
						seem[rx][ry] = true;
						area++;
					}
				}
			}
			return area;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}