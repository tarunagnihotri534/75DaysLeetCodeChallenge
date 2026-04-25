class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    // Add word
    public void addWord(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    // Search with '.' support
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS helper
    private boolean dfs(String word, int i, Node node) {
        if (node == null) return false;

        // Reached end of word
        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        if (ch == '.') {
            // Try all possibilities
            for (Node child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch - 'a';
            return dfs(word, i + 1, node.children[index]);
        }
    }
}