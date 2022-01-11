//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 793 👎 0

 
package leetcode.editor.cn;
 
//组合

import java.util.*;

class P77_Combinations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P77_Combinations().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	     // 从P46改造
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] use = new boolean[n+1];
        dfs(n,k,path,use,res);
        return res;
    }

    private void dfs(int n,int k,List<Integer> path,boolean[] use,List<List<Integer>> res) {
        if (path.size() == k){
            res.add(path);
            return;
        }
        for (int i = 1; i <= n ; i++) {
            // 再插入的数字必须大于前一个
            if (!use[i] && (path.size()==0 || i>path.get(path.size()-1))){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(i);
                boolean[] newUse = new boolean[n+1];
                System.arraycopy(use,0,newUse,0,n+1);
                newUse[i] = true;
                dfs(n,k,newPath,newUse,res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}