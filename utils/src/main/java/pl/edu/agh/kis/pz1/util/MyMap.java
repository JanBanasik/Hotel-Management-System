package pl.edu.agh.kis.pz1.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A class implementing the Map interface. It represents a data structure that stores key-value pairs,
 * allowing for adding, removing, and accessing data by key.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class MyMap<K, V> implements Map<K, V> {
    List<K> keys;
    List<V> values;

    /**
     * Constructor that initializes an empty map.
     * It creates empty lists for keys and values.
     */
    public MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * Adds a key-value pair to the map. If the key already exists, its value is updated.
     *
     * @param key The key to be added or updated.
     * @param value The value associated with the key.
     * @return Returns true if the key was added to the map, or false if the value was updated.
     */
    @Override
    public boolean put(K key, V value) {
        int ix = keys.indexOf(key);
        if (ix == -1) { // No such key
            keys.add(key);
            values.add(value);
            return true;
        } else {
            keys.set(ix, key);
            values.set(ix, value);
            return false;
        }
    }

    /**
     * Returns the value associated with the given key, or null if the key does not exist.
     *
     * @param key The key (not null).
     * @return The value associated with the key or null if the key does not exist.
     */
    @Override
    public V get(K key) {
        int ix = keys.indexOf(key);
        if (ix == -1) {
            return null;
        }
        return values.get(ix);
    }

    /**
     * Returns a list of all keys in the map.
     *
     * @return A list of keys in the map.
     */
    @Override
    public List<K> keys() {
        return new ArrayList<>(keys);
    }

    /**
     * Removes the key-value pair from the map based on the given key.
     *
     * @param key The key to be removed.
     * @return Returns true if the key was removed, or false if the key does not exist.
     */
    @Override
    public boolean remove(K key) {
        int ix = keys.indexOf(key);
        if (ix == -1) {
            return false;
        } else {
            keys.remove(ix);
            values.remove(ix);
            return true;
        }
    }

    /**
     * Checks if the given key exists in the map.
     *
     * @param key The key to check for existence.
     * @return true if the key exists, false otherwise.
     */
    @Override
    public boolean contains(K key) {
        return keys.contains(key);
    }

    /**
     * Creates a textual representation of the map, returning all key-value pairs
     * in the format "key=value".
     *
     * @return The textual representation of the map.
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (K key : keys) {
            V value = values.get(keys.indexOf(key));
            if (value != null) {
                res.append(key).append("=").append(value).append("\n");
            } else {
                res.append(key).append("=null\n");
            }
        }
        return res.toString();
    }
}
