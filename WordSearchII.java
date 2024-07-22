import java.util.*;

public class WordSearchII {    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, v, i, j, root, res);
            }
        }
        return res;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }
                cur = cur.child[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    
    private void dfs(char[][] board, boolean[][] v, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || v[i][j] || node.child[board[i][j] - 'a'] == null) {
            return;
        }
        v[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if (node.word!= null) {
            res.add(node.word);
            node.word = null;
        }
        dfs(board, v, i - 1, j, node, res);
        dfs(board, v, i + 1, j, node, res);
        dfs(board, v, i, j - 1, node, res);
        dfs(board, v, i, j + 1, node, res);
        v[i][j] = false;
        return;
    }
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }




    public static void main(String[] args) {
        WordSearchII w = new WordSearchII();
        char[][] board = { {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'} };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = w.findWords(board, words);
        System.out.println(res);
    }
}





