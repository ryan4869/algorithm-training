//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 460 👎 0

 
package leetcode.editor.cn;
 
//腐烂的橘子

import java.util.LinkedList;
import java.util.Queue;

class P994_RottingOranges{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P994_RottingOranges().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	// 从腐烂的橘子开始广度优先遍历
	// 参考 P542
    public int orangesRotting(int[][] grid) {

    	int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}};
    	// 1.遍历二维数组，把腐烂的橘子的坐标放入栈中
		Queue<int[]> queue = new LinkedList<>();
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] seem = new boolean[m][n];
		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n ; j++) {
				if (grid[i][j] == 2){
					queue.add(new int[]{i,j});
					seem[i][j] = true;
				}
			}
		}
		// 2.栈不为空时，元素依次出栈，若出栈位置上下左右有为1的，则变为2
		// 一轮记一次数 116 第一种方式 一轮清一次栈
		int time = 0;
		while (!queue.isEmpty()){
			int size = queue.size();
			// 如果一次没有任何元素改变 则结束
			boolean change = false;
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				for (int j = 0; j < dirt.length; j++) {
					int ni = poll[0]+dirt[j][0];
					int nj = poll[1]+dirt[j][1];
					if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seem[ni][nj] && grid[ni][nj]==1){
						grid[ni][nj] = 2;
						seem[ni][nj] = true;
						queue.add(new int[]{ni,nj});
						change = true;

					}
				}
			}
			if (change){
				time++;
			}
		}
		// 3.遍历结束后的二维数组，如果还有新鲜的则返回-1
		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1){
					time = -1;
					break;
				}
			}
		}
		return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}