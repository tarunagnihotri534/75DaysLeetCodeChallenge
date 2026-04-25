class Trie {

    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26]; // for a-z
            isEnd = false;
        }
    }

    private Node root;

    // Initialize
    public Trie() {
        root = new Node();
    }

    // Insert word
    public void insert(String word) {
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

    // Search full word
    public boolean search(String word) {
        Node node = findNode(word);
        return node != null && node.isEnd;
    }

    // Check prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Helper function
    private Node findNode(String str) {
        Node current = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}