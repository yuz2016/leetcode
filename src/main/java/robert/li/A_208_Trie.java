package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-28
 */
public class A_208_Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public A_208_Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(cur.children[chars[i] - 'a'] == null) {
                cur.children[chars[i] - 'a'] = new TrieNode(chars[i]);
            }
            cur = cur.children[chars[i] - 'a'];
            if(i == chars.length - 1) {
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = this.root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(cur.children[chars[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[chars[i] - 'a'];
            if(i == chars.length - 1) {
                return cur.isWord;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(cur.children[chars[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[chars[i] - 'a'];
        }
        return true;
    }

    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char val) {
            this.val = val;
        }
    }
}
