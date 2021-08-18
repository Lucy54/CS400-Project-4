// --== CS400 File Header Information ==--
// Name: <Shin-Tsz Lucy Kuo>
// Email: <skuo8@wisc.edu>
// Team: <GD>
// Role: <Test Engineer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * This class contains all the methods to edit and access values in the key-value pairs and map.
 * 
 * @author Lucy Kuo
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private int capacity;
  private LinkedList<Pair>[] list;
  private int size;

  /**
   * Inner Pair class for hashtable map, contains the key-value pairs.
   * 
   */
  public class Pair {
    public KeyType key;
    public ValueType value;

    /**
     * Constructor to create a new node given key and value.
     * 
     * @param key   the designated key for KeyType
     * @param value the designated value for ValueType
     */
    public Pair(KeyType key, ValueType value) {
      this.key = key;
      this.value = value;
    }

    /**
     * Returns the key of a specific Pair
     * 
     * @return value the key which is the KeyType
     */
    public KeyType getKey() {
      return key;
    }

    /**
     * Returns the value of desired Pair
     * 
     * @return value the value which is the ValueType
     */
    public ValueType getValue() {
      return value;
    }
  }

  /**
   * Constructor to to create a hashtable map given a capacity.
   * 
   * @param capacity for the number of spots available
   */
  public HashTableMap(int capacity) {
    this.capacity = capacity;
    size = 0;
    list = new LinkedList[capacity];

    for (int i = 0; i < capacity; i++) {
      list[i] = new LinkedList<Pair>();
    }
  }

  /**
   * Constructor without designated capacity, will have default of 10.
   * 
   */
  public HashTableMap() {
    capacity = 10;
    size = 0;
    list = new LinkedList[10];

    for (int i = 0; i < capacity; i++) {
      list[i] = new LinkedList<Pair>();
    }
  }

  /**
   * Private helper method to grow and rehash the hashtablemap when load capacity is greater than 
   * or equal to over half capacity.
   */
  private void grow() {
    capacity = 2 * capacity;
    LinkedList<Pair>[] temp = new LinkedList[capacity];
    int key;

    // initialize temp with empty LinkedLists
    for (int i = 0; i < capacity; i++) {
      temp[i] = new LinkedList<Pair>();
    }

    // rehash
    for (int i = 0; i < capacity / 2; i++) {
      for (int j = 0; j < list[i].size(); j++) {
        key = Math.abs(list[i].get(j).getKey().hashCode());
        temp[Math.abs(key % capacity)] = list[i];
      }
    }

    list = temp;
  }

  /**
   * Inserts new key-value pairs into hash table. In case that hash table has load factor equal to 
   * or greater than 50 percent initial capacity, will call grow to create a new hashTable with 
   * double capacity. In case that key present in the hashTable, returns false.
   *
   * @param key   the key which is of type KeyType
   * @param value the value which is of type ValueType
   * @return true if key-value pair added to the hashTable successfully, otherwise false.
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if (Math.abs(((size + 1) - capacity * 0.8)) < 0.001 || ((size + 1) > capacity * 0.8)) {
      grow();
    }
    // see if there are duplicates
    int index = Math.abs(key.hashCode() % capacity);

    for (Pair p : list[index]) {
      if (p.getKey().equals(key)) {
        return false;
      }
    }

    list[index].add(new Pair(key, value));
    size++;

    return true;
  }

  /**
   * Getter method to retrieve value from hash table associated with the key. If key non existent 
   * in hash table map, throws an exception.
   * 
   * @param key the Key of type KeyType
   * @return value that goes with the key
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if (!containsKey(key)) {
      throw new NoSuchElementException("no value found");
    }
    int index = Math.abs(key.hashCode() % capacity);

    for (int i = 0; i < list[index].size(); i++) {
      if (list[index].get(i).getKey().equals(key)) {
        return list[index].get(i).getValue();
      }
    }

    return null;
  }

  /**
   * Retrieves size of hash table map.
   * 
   * @return size of hash table map
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Sees if hash table map contains a certain key.
   * 
   * @param key the Key of type KeyType
   * @return true if map contains key, false otherwise.
   */
  @Override
  public boolean containsKey(KeyType key) {
    int index = Math.abs(key.hashCode() % capacity);

    for (int i = 0; i < list[index].size(); i++) {
      if (list[index].get(i).getKey().equals(key)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Removes a certain value corresponding to key from hash table map.
   * 
   * @param key of KeyType associated with value trying to remove
   * @return removed value or null if key does not exist
   */
  @Override
  public ValueType remove(KeyType key) {
    int index = Math.abs(key.hashCode() % capacity);
    ValueType temp = null;

    for (int i = 0; i < list[index].size(); i++) {
      if (list[index].get(i).getKey().equals(key)) {
        temp = list[index].get(i).getValue();
        list[index].remove(i);
        size--;
      }
    }

    return temp;
  }

  /**
   * Remove all key-value pairs from this collection.
   * 
   */
  @Override
  public void clear() {
    list = new LinkedList[capacity];

    for (int i = 0; i < capacity; i++) {
      list[i] = new LinkedList<Pair>();
    }
    size = 0;
  }

}
