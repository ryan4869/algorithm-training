package class08;


import org.junit.Test;

public class Code01_Trie {

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

    public class Trie{

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word){
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

        public boolean search(String word){
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

        // 递归遍历 存在.ba的情况
        public boolean searchDFS(String word){
            char[] chars = word.toCharArray();
            return dfs(word,0,root);
        }

        public boolean DFS(char[] chars, int count, TrieNode node){
            if (count == chars.length-1){
                return true;
            }
            if (Character.isLetter(chars[count])){
                int index = chars[count]-'a';
                if (node.nexts[index] != null){
                    node = node.nexts[index];
                    count++;
                    return DFS(chars,count,node);
                }
            }else {
                for (int i = 0; i < 26 ; i++) {
                    count++;
                    return node!=null && DFS(chars,count,node.nexts[i]);
                }
            }
            return false;
        }

        private boolean dfs(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.end >= 1;
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)) {
                int childIndex = ch - 'a';
                TrieNode child = node.nexts[childIndex];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    TrieNode child = node.nexts[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void delete(String word){
            boolean search = search(word);
            if (search){
                return;
            }
            TrieNode node = root;
            node.pass--;
            char[] chrs = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chrs.length ; i++) {
                index = chrs[i]-'a';
                if (--node.nexts[index].pass == 0){
                    node.nexts[index] = null;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    @Test
    public void Test(){
        //输入：
        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        //输出：
        //[null,null,null,null,false,true,true,true]
        //
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        System.out.println(trie.searchDFS("pad"));
        System.out.println(trie.searchDFS(".ad"));

    }
}
