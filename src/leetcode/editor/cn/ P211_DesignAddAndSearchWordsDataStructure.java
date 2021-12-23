//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 
// 👍 383 👎 0

 
package leetcode.editor.cn;
 
//添加与搜索单词 - 数据结构设计

import class08.Code01_Trie;
import org.junit.Test;

class P211_DesignAddAndSearchWordsDataStructure{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 String[] dirt = new String[]{"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
	 	 String[] arr = new String[]{};


	 }

	 public void test(){
         WordDictionary wordDictionary = new WordDictionary();
         String word = "bad";
         wordDictionary.addWord(word);
         System.out.println(wordDictionary.search(word));

     }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)

    public class TrieNode{

        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }
class WordDictionary {

	     TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        if (word == null){
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (int i = 0; i < chs.length ; i++) {
            int index = chs[i]-'a';
            if (node.nexts[index]==null){
                node.nexts[index] = new TrieNode();
            }
            node.nexts[index].pass++;
            node = node.nexts[index];
        }
        node.end++;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        char[] chrs = word.toCharArray();
        int index = 0;
        for (int i = 0; i < chrs.length ; i++) {
            index = chrs[i]-'a';
            if (node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return true;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}