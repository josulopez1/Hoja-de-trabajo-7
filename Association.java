
// Representa una asociación (english -> spanish)
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {

    private K key;     // palabra en inglés
    private V value;   // traducción en español

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // IMPORTANTE: esto permite que el BST ordene por la palabra en inglés
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
