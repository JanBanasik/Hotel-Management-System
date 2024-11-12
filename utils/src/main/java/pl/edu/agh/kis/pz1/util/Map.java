package pl.edu.agh.kis.pz1.util;

import java.util.List;

/**
 * Interface representing a data structure for a map that stores key-value pairs.
 * Each key in the map is unique, and a value is associated with each key.
 * This interface offers basic operations such as adding elements, removing elements,
 * retrieving values by key, checking if a key exists, and obtaining a list of all keys.
 * Implementations of this interface should provide:
 *   <ul>
 *     <li>Adding elements by key and value, with the possibility of overwriting an existing key's value.</li>
 *     <li>Removing elements by key.</li>
 *     <li>Retrieving the value associated with a given key.</li>
 *     <li>Checking if a given key exists in the map.</li>
 *     <li>Generating a string representation of the map in the format "key=value".</li>
 *   </ul>
 *
 * @param <K> Type of the key in the map (cannot be null).
 * @param <V> Type of the value in the map (cannot be null).
 */
public interface Map<K, V> {

    /**
     * Adds an element to the map under the given key.
     * If the key already exists, the method should overwrite the existing value.
     *
     * @param key   The key (cannot be null).
     * @param value The value associated with the key (cannot be null).
     * @return true if the element was successfully added, false otherwise.
     */
    boolean put(K key, V value);

    /**
     * Removes the key-value pair from the map based on the provided key.
     *
     * @param key The key to be removed.
     * @return true if the key was removed, false if the key does not exist in the map.
     */
    boolean remove(K key);

    /**
     * Returns the value associated with the given key, or null if the key does not exist.
     *
     * @param key The key (cannot be null).
     * @return The value associated with the key, or null if the key is not found.
     */
    V get(K key);

    /**
     * Returns a list of all the keys in the map.
     *
     * @return A list of all the keys in the map.
     */
    List<K> keys();

    /**
     * Checks if the given key exists in the map.
     *
     * @param key The key to check for existence.
     * @return true if the key exists in the map, false otherwise.
     */
    boolean contains(K key);

    /**
     * Creates a string representation of the map, returning all key-value pairs
     * in the format "key=value".
     *
     * @return A string representation of the map.
     */
    @Override
    String toString();
}
