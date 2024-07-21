/*
 * Problem Statement:
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 1. insert(val): Inserts an item val to the set if not already present.
 * 2. remove(val): Removes an item val from the set if present.
 * 3. getRandom: Returns a random element from current set of elements. Each
 * element must have the same probability of being returned.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can use a HashSet
 * to store the elements. The add method of the HashSet returns a boolean value
 * i.e true if the element is added to the HashSet and false if the element is
 * already present in the HashSet. The remove method of the HashSet also returns
 * a boolean value i.e true if the element is removed from the HashSet and false
 * if the element is not present in the HashSet. The getRandom method can be
 * implemented by converting the HashSet to an ArrayList and then generating a
 * random index between 0 and the size of the ArrayList. To generate a random
 * index, we can use the Random class. We will return the element at the random
 * index.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of the insert method is O(1) because the add method of
 * the HashSet is O(1).
 * The Time Complexity of the remove method is O(1) because the remove method of
 * the HashSet is O(1).
 * The Time Complexity of the getRandom method is O(n) because we are converting
 * the HashSet to an ArrayList.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) because the HashSet is storing
 * n elements.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that the getRandom method is taking O(n)
 * time because every time we call the getRandom method, we are converting the
 * HashSet to an ArrayList which is taking O(n) time.
 * 
 * Approach 2:
 * The second approach is similar to the first approach. The only difference is
 * that we will use an ArrayList to store the elements. The insert method will
 * add the element to the ArrayList if it is not already present. The remove
 * method will remove the element from the ArrayList if it is present. The
 * getRandom method will generate a random index between 0 and the size of the
 * ArrayList and return the element at the random index.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of the insert method is O(n) because the contains method
 * of the ArrayList is O(n).
 * The Time Complexity of the remove method is O(n) because the remove method of
 * the ArrayList is O(n).
 * The Time Complexity of the getRandom method is O(1) because we are generating
 * a random index between 0 and the size of the ArrayList.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) because the ArrayList is
 * storing n elements.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that the insert and remove methods are
 * taking O(n) time.
 * 
 * Efficient Approach:
 * The idea is very simple. We will use a HashMap to store the elements. The key
 * of the HashMap will be the element and the value will be the index of the
 * element in the ArrayList. We will also use an ArrayList to store the
 * elements. The insert method will add the element to the HashMap if it is not
 * already present. The remove method will remove the element from the HashMap
 * if it is present. The getRandom method will generate a random index between 0
 * and the size of the ArrayList and return the element at the random index.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of the insert method is O(1) because the put method of
 * the HashMap is O(1).
 * The Time Complexity of the remove method is O(1) because the remove method of
 * the HashMap is O(1).
 * The Time Complexity of the getRandom method is O(1) because we are generating
 * a random index between 0 and the size of the ArrayList.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) because the HashMap is storing
 * n elements.
 * The ArrayList is also storing n elements.
 * So, the total Space Complexity is O(2n) which is O(n).
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

class Approach1 {
	Set<Integer> set;
	Random random;

	public Approach1() {
		set = new HashSet<>();
		random = new Random();
	}

	public boolean insert(int val) {
		return set.add(val);
	}

	public boolean remove(int val) {
		return set.remove(val);
	}

	public int getRandom() {
		int randomIndex = random.nextInt(set.size());
		return new ArrayList<>(set).get(randomIndex);
	}
}

class Approach2 {
	ArrayList<Integer> list;
	Random random;

	public Approach2() {
		list = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (list.contains(val)) {
			return false;
		}
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!list.contains(val)) {
			return false;
		}
		list.remove(Integer.valueOf(val));
		return true;
	}

	public int getRandom() {
		int randomIndex = random.nextInt(list.size());
		return list.get(randomIndex);
	}
}

class Efficient {
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;
	Random random;

	public Efficient() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		int lastElement = list.get(list.size() - 1);
		list.set(index, lastElement);
		map.put(lastElement, index);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		int randomIndex = random.nextInt(list.size());
		return list.get(randomIndex);
	}
}

public class InsertDeleteGetRandom {
	public static void main(String[] args) {
		// Approach1 approach1 = new Approach1();
		// System.out.println(approach1.insert(1));
		// System.out.println(approach1.insert(2));
		// System.out.println(approach1.insert(3));
		// System.out.println(approach1.insert(4));
		// System.out.println(approach1.insert(5));
		// System.out.println(approach1.remove(3));
		// System.out.println(approach1.getRandom());

		// Approach2 approach2 = new Approach2();
		// System.out.println(approach2.insert(1));
		// System.out.println(approach2.insert(2));
		// System.out.println(approach2.insert(3));
		// System.out.println(approach2.insert(4));
		// System.out.println(approach2.insert(5));
		// System.out.println(approach2.remove(3));
		// System.out.println(approach2.getRandom());

		Efficient efficient = new Efficient();
		System.out.println(efficient.insert(1));
		System.out.println(efficient.insert(2));
		System.out.println(efficient.insert(3));
		System.out.println(efficient.insert(4));
		System.out.println(efficient.insert(5));
		System.out.println(efficient.remove(3));
		System.out.println(efficient.getRandom());
	}
}