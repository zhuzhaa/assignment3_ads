public class binary_tree<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (get(key) == null)
            root = put(root, key, value);
    }

    public Node put(Node node, K key, V value) {
        if (node == null)
            node = new Node(key, value);
        else if (key.compareTo(node.key) < 0)
            node.left = put(node.left, key, value);
        else
            node.right = put(node.right, key, value);
        return node;
    }

    public V get(K key){
        return get(root, key);
    }

    public V get(Node node, K key) {
        if (node == null) return null;
        int c = key.compareTo(node.key);
        if (c < 0)
            return get(node.left, key);
        else if (c > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    public void delete(K key) {
        if (get(key) != null)
            root = delete(root, key);
    }

    public Node delete(Node node, K key) {
        int c = key.compareTo(node.key);
        if (c < 0) {
            node.left = delete(node.left, key);
        } else if (c > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) { //When node has only right child
                node = node.right;
            } else if (node.right == null) { //When node has only left child
                node = node.left;
            } else { // When node has two children
                Node min = findMin(node.right);
                node.right = deleteMin(node.right);
                node.key = min.key;
                node.value = min.value;
            }
        }
        return node;
    }

    public Node findMin(Node node) {
        if (node.left != null)
            return deleteMin(node.left);
        else
            return node;
    }

    Node deleteMin(Node node) {
        if (node.left != null) {
            node.left = deleteMin(node.left);
            return node;
        } else
            return node.right;
    }
    public Iterable<K> iterator(){
        Queue<K> q = new Queue<K>();
        inorder(root, q);
        return (Iterable<K>) q;
    }
    private void inorder(Node x, Queue<K> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }
}