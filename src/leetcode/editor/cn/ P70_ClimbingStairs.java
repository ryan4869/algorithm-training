//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ f(1) = 1, f(2) = 2  f(n) = f(n-2) + f(n-1)
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3   f(3) = f(2) + f(1)
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  2 阶 + 1 阶
//3.  1 阶 + 2 阶
//
// 示例 3：
//
// 输入： 4   f(4) = f(3) + f(2)
//输出： 5
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶 + 1 阶
//2.  2 阶 + 1 阶 + 1 阶
//3.  1 阶 + 2 阶 + 1 阶
//4.  2 阶 + 2 阶
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2027 👎 0

 
package leetcode.editor.cn;
 
//爬楼梯
 
class P70_ClimbingStairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P70_ClimbingStairs().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
    	if (n<=2){
    		return n;
		}
    	int p = 1;
    	int q = 2;
    	int temp = 0;
		for (int i = 3; i <=n ; i++) {
			temp = p+q;
			p = q;
			q = temp;
		}
		return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}