// Árbol binario de búsqueda (BST)
public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    // ================= INSERT =================
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> node, E data) {
        // Si el nodo está vacío, crear uno nuevo
        if (node == null) {
            return new Node<>(data);
        }

        // Comparar para decidir izquierda o derecha
        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else {
            node.right = insertRec(node.right, data);
        }

        return node;
    }

    // ================= SEARCH =================
    public E search(E data) {
        return searchRec(root, data);
    }

    private E searchRec(Node<E> node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);

        if (cmp == 0) return node.data;
        if (cmp < 0) return searchRec(node.left, data);
        return searchRec(node.right, data);
    }

    // ================= IN-ORDER =================
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<E> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
}
