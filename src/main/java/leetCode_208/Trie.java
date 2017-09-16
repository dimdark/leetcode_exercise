package leetCode_208;

/**
 * @author dimdark
 * @date 2017-09-16
 * @time 8:38 AM
 */
public class Trie {

    class TrieNode {

        private final int LINKS_COUNT = 26; // child node count
        private TrieNode[] links;
        private boolean isEnd; // leaf node or not

        public TrieNode() {
            links = new TrieNode[LINKS_COUNT];
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; ++i) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) { // not contains
                node.put(currChar, new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd(true);
    }

    private TrieNode searchPrefix(String prefixWord) {
        TrieNode node = root;
        int len = prefixWord.length();
        for (int i = 0; i < len; ++i) {
            char currChar = prefixWord.charAt(i);
            if (node.containsKey(currChar)) {
                node = node.get(currChar); // move to specific child node
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

}
