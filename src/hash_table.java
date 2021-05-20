public class hash_table <K, V> {

    public static class HashNode <K, V> {
        K key;
        V value;
        HashNode next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    private int M = 20;
    private int size = 0;
    private HashNode<K, V>[] chainArray = new HashNode[M];

    private Integer hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value){
        HashNode<K, V> e = new HashNode<>(key, value);
        int i = hash(key);
        System.out.println(i);
        if(chainArray[i] == null){
            chainArray[i] = e;
            size++;
            return;
        }
        HashNode<K, V> t = chainArray[i];
        while(t != null) {
            if(t.key == key){
                t.value = value;
                return;
            }
            t = t.next;
        }
        size++;
        t.next = e;
    }

    public V getV(K key){
        int h = hash(key);
        if(chainArray[h] == null){
            return null;
        }
        if(chainArray[h].next != null && chainArray[h].key == key)
            return (V)chainArray[h].value;

        HashNode<K,V> Z  = chainArray[h];
        while(Z != null){
            if(Z.key == key)
                return (V)Z.value;
            Z = Z.next;
        }
        return null;
    }

    public V remove(K key) {
        int k = (hash(key) % size);
        if (chainArray[k] != null) {
            HashNode prev = null;
            HashNode entry = chainArray[k];
            while (entry.next != null && entry.key != key) {
                prev = entry;
                entry = entry.next;
            }
            if (entry.key == key) {
                if (prev == null)
                    chainArray[k] = entry.next;
                else
                    prev.next = entry.next;
                size--;
                return (V)entry.value;
            }
        }
        return null;
    }

    public boolean containsK(K key){
        int i = hash(key);
        if(chainArray[i] == null){
            return false;
        }
        if(chainArray[i].next != null && chainArray[i].key == key)
            return true;
        HashNode<K, V> a  = chainArray[i];
        while(a != null){
            if(a.key == key)
                return true;
            a = a.next;
        }
        return false;
    }

    public boolean containsV(V value){
        int i = 1;
        while(chainArray[i] != null){
            if(chainArray[i].value == value)
                return true;
            i++;
        }
        return false;
    }

    public K getK(V value){
        int i = 1;
        HashNode<K,V> R  = chainArray[i];
        while(R != null){
            if(R.value == value)
                return (K)R.key;
            R = R.next;
        }
        return null;
    }
}