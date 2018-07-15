package Q1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DoubleHashMap<K,V> implements Map<K,V> {

    private Entry < K, V > [] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private int PRIME = 19;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);

    /**
     *  Constructor set table capacity
     */
    public DoubleHashMap(){
        table = new Entry[START_CAPACITY];
    }

    /**
     *  first hashing
     * @param keyhash the hash
     * @return index
     */
    private int hash1(int keyhash)
    {
        return (keyhash % table.length);
    }

    /**
     *  second hashing
     * @param keyhash the hash
     * @return index
     */
    private int hash2(int keyhash)
    {
        return (PRIME - (keyhash % PRIME));
    }

    /**
     *  get size the map table
     * @return size
     */
    @Override
    public int size() {
        return numKeys+numDeletes;
    }

    /**
     *  Table isEmpty
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     *  Check map contains given key
     * @param key the key
     * @return boolean
     */
    @Override
    public boolean containsKey(Object key) {
        return  get(key) != null;
    }


    /**
     *  get keys value
     * @param key the key
     * @return value
     */
    @Override
    public V get(Object key) {
        if (key == null){
            return null;
        }
        int index = hash1(key.hashCode());
        int firstIndex = index;
        if (index < 0)
            index += table.length;
        if(table[index] != null){
            int i = 1;
            int index2 = hash2(key.hashCode());
            while (true){
                if(table[index] !=null){

                    if(table[index].key.equals(key))
                        return table[index].value;
                    index = (firstIndex + i*index2)%table.length;
                    if (index < 0)
                        index += table.length;
                    i++;
                }else
                    break;
            }
        }
        return null;
    }

    /**
     *  Put the data map
     * @param key the key
     * @param value the value
     * @return Value
     */
    @Override
    public V put(K key, V value) {

        if (key == null){
            return null;
        }
        V adding = null;
        int index = hash1(key.hashCode());
        int firstIndex = index;
        if (index < 0)
            index += table.length;
        if(table[index] != null){
            int i = 1;
            int index2 = hash2(key.hashCode());
            while (true){
                if(table[index] !=null){

                    if(table[index].key.equals(key)){ // key already have value so swap value
                        adding =  table[index].value;
                        table[index].setValue(value);
                        break;
                    }
                    index = (firstIndex + i*index2)%table.length;
                    if (index < 0)
                        index += table.length;
                    i++;
                }else{
                    table[index] = new Entry<>(key, value);
                    adding=value;
                    numKeys++;
                    break;
                }

            }

        } else {
            table[index] = new Entry<>(key, value);
            adding=value;
            numKeys++;
        }
        // Check rehashing
        double loadFactor = (double) (numKeys + numDeletes) / table.length;
        if (loadFactor > LOAD_THRESHOLD)
            rehash();
        return adding;
    }

    /**
     *  Remove the entry from map
     * @param key the entry key
     * @return removed value
     */
    @Override
    public V remove(Object key) {
        if (key == null){
            return null;
        }
        V removed = null;
        int index = hash1(key.hashCode());
        int firstIndex = index;
        if (index < 0)
            index += table.length;
        if(table[index] != null){
            int i = 1;
            int index2 = hash2(key.hashCode());
            while (true){
                if(table[index] !=null){

                    if(table[index].key.equals(key)){
                        removed = table[index].value;
                        table[index] = DELETED;
                        numKeys--;
                        numDeletes++;
                        break;
                    }
                    index = (firstIndex + i*index2)%table.length;
                    if (index < 0)
                        index += table.length;
                    i++;
                }else
                    break;
            }
        }
        return removed;
    }

    /**
     *  Rehash the table
     */
    private void rehash() {
        Entry < K, V > [] oldTable = table;
        table = new Entry[2 * oldTable.length + 1];
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    @Override
    public void clear() {
        numKeys=0;
        numDeletes=0;
        table = null;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    /**
     *  The entry class
     * @param <K> key
     * @param <V> value
     */
    public static class Entry<K,V> implements Map.Entry<K,V>{
        private K key;
        private V value;

        /**
         * Entry constructor
         * @param key1 key
         * @param value1 value
         */
        public Entry(K key1, V value1) {
            key= key1;
            value=value1;
        }

        /**
         *  get key
         * @return key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         *  get value
         * @return value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         *  SetValue
         * @param value1 new value
         * @return new value
         */
        @Override
        public V setValue(V value1) {
            value=value1;
            return value1;
        }
    }
}
