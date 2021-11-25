//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4   T_5 = 1 + 2 + 4 =
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 148 👎 0

 
package leetcode.editor.cn;
 
//第 N 个泰波那契数
 
class P1137_NThTribonacciNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1137_NThTribonacciNumber().new Solution();
	 	 solution.tribonacci(4);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
//    	return process(n);
		if (n==0){
			return 0;
		}else if (n==1 || n==2){
			return 1;
		}
		int p = 0;
		int q = 1;
		int r = 1;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = p+q+r;
			p = q;
			q = r;
			r = temp;
		}
		return temp;
    }
	// 动态规划
	// 直接递归 35 超时 考虑优化
	public int process(int n){
		if (n == 0){
			return 0;
		}
		if (n == 1 || n == 2){
			return 1;
		}
		return process(n-1)+process(n-2)+process(n-3);
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}