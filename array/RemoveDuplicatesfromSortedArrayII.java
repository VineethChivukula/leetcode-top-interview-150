/*
 * Problem Statement:
 * The problem says that there is an array which is sorted and we have to remove
 * duplicates such that the array contains at most two duplicates of each
 * element and return the length of the array. We also need to make sure that
 * the remaining elements are in the same order as they were in the original
 * array. For example, if the array is [1,1,1,2,2,3] then the output is
 * [1,1,2,2,3,_,_].
 * 
 * Thought Process::
 * Approach 1:
 * The first approach that should come to our mind is that we can take a TreeMap
 * to store the frequency of each element of the array. Why TreeMap? Because it
 * maintains the order of the elements. Why not HashMap? Because HashMap does
 * not maintain the order of the elements. Why not HashSet? Because HashSet does
 * not store the frequency of the elements. We will traverse the array and store
 * the frequency of each element in the TreeMap. Now, we will traverse the
 * TreeMap and copy the elements of the TreeMap into the original array. If
 * there are k elements after removing the duplicates, then the first k elements
 * of nums should hold the final result. So we will return k.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of traversing the array and building the TreeMap is
 * O(nlogn).
 * The Time Complexity of copying the elements of the TreeMap into the array is
 * O(n).
 * So, the final Time Complexity of this approach is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using a TreeMap to
 * store the frequency of the elements.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space and also we
 * are traversing the array multiple times.
 * 
 * Efficient Approach:
 * Let's try to understand this approach in a simple way. If the array's length
 * is less than or equal to 2, then we can return it directly but why?. See, If
 * the array has 2 or fewer elements, there can't be any duplicates that need to
 * be removed, so we just return the length of the array. We use two pointers: i
 * and j. Both start at the third position (index 2) because the first two
 * elements can be duplicates and we want to allow up to two duplicates of any
 * number. For each element at position j, we compare it with the element at
 * position i - 2. This comparison checks if the current element is different
 * from the element that is two positions before the current position of i. If
 * the current element at j is different from the element at i - 2, it means we
 * can safely include this element in the new array without exceeding the limit
 * of two duplicates. So, we copy the element at j to the position i and then
 * move i to the next position. If the current element at j is the same as the
 * element at i - 2, we skip it because we already have two duplicates of that
 * number before i. After the loop, i will be at the position just after the
 * last valid element in the modified array. So, we return i as the new length
 * of the array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

import java.util.TreeMap;

public class RemoveDuplicatesfromSortedArrayII {
	public int approach1(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int i = 0;
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (freq == 1) {
				nums[i] = key;
				i++;
			} else {
				nums[i] = key;
				nums[i + 1] = key;
				i += 2;
			}
		}

		return i;
	}

	public int efficient(int[] nums) {
		int n = nums.length, i = 2, j = 2;

		if (n <= 2) {
			return n;
		}

		while (j < n) {
			if (nums[i - 2] != nums[j]) {
				nums[i] = nums[j];
				i++;
			}
			j++;
		}

		return i;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII rdsa = new RemoveDuplicatesfromSortedArrayII();
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		// System.out.println(rdsa.approach1(nums));
		// nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(rdsa.efficient(nums));
	}
}