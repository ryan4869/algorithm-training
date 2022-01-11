//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 993 👎 0

 
package leetcode.editor.cn;
 
//实现 Trie (前缀树)

import java.util.LinkedList;
import java.util.List;

class P208_ImplementTriePrefixTree{
	 public static void main(String[] args) {
	 	 //测试代码
//	 	 Solution solution = new P208_ImplementTriePrefixTree().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode{
    int pass;
    int end;
    TrieNode[] nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new TrieNode[26];
    }
}
class Trie {

	     TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (int i = 0; i <chars.length ; i++) {
            int index = chars[i]-'a';
            if (node.nexts[index] == null){
                TrieNode next = new TrieNode();
                node.nexts[index] = next;
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }
    
    public boolean searchDFS(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i <chars.length ; i++) {
            int index = chars[i]-'a';
            if (node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        if (node.end >= 1){
            return true;
        }
        return false;
    }

    public boolean search(String word){
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,TrieNode node){
        if (index == word.length()){
            return node.end >= 1;
        }
        char ch = word.charAt(index);
        TrieNode next = node.nexts[ch - 'a'];
        if (next!=null && dfs(word,index+1,next)){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i <chars.length ; i++) {
            int index = chars[i]-'a';
            if (node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}