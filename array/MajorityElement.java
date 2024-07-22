/*
 * Problem Statement:
 * The problem says that there is an array and we have to find the majority
 * element. The majority element is the element that appears more than n/2 times
 * where n is the size of the array. Assume that the array is non-empty and the
 * majority element always exists in the array. For example, if the array is [3,
 * 2, 3] then the majority element is 3.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can sort the array
 * and then keep track of the count of the elements. If the count of any element
 * is greater than n/2, then we can return that element.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of sorting the array is O(nlogn).
 * The Time Complexity of finding the majority element is O(n).
 * So, the final Time Complexity of this approach is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are sorting the array and traversing
 * the array to find the majority element.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can sort the
 * array and find out the major element by accessing the middle element of this
 * array. Why the middle element is the majority element?. See, in a given array
 * it is said that the majority element will always exist. So, if we sort the
 * array, then the middle element will always be the majority element. You can
 * try out by taking any number of examples. Result will always be the same.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of sorting the array is O(nlogn).
 * The Time Complexity of finding the majority element is O(1).
 * So, the final Time Complexity of this approach is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are sorting the array and finding
 * the majority element.
 * 
 * Approach 3:
 * The third approach that should come to our mind is that we can use a HashMap
 * to store the frequency of each element of the array. We will traverse the
 * array and store the frequency of each element in the HashMap. Now, we will
 * traverse the HashMap and check if the frequency of any element is greater
 * than n/2, then we can return that element.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of traversing the array and building the HashMap is O(n).
 * The Time Complexity of finding the majority element is O(n).
 * So, the final Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using a HashMap to
 * store the frequency of the elements.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space.
 * 
 * Efficient Approach:
 * Okay, so there's a concept called Boyer-Moore Voting Algorithm. Iterate
 * through the array, and for each element, if the count is zero, designate the
 * current element as the candidate for majority element. Increment the count if
 * the current element is the same as the candidate, and decrement it if
 * different. Although not always necessary (since the problem guarantees a
 * majority element), you can verify the candidate by counting its occurrences
 * in the array to ensure it indeed appears more than half the time. This
 * algorithm works under the principle that the majority element will always
 * have a positive count by the end of the array traversal, as it outnumbers all
 * other elements combined.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
	public int approach1(int[] nums) {
		Arrays.sort(nums);
		int count = 1;
		int majorityElement = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
				if (count > nums.length / 2) {
					majorityElement = nums[i];
					break;
				}
			} else {
				count = 1;
			}
		}
		return majorityElement;
	}

	public int approach2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int approach3(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (int key : map.keySet()) {
			if (map.get(key) > nums.length / 2) {
				return key;
			}
		}
		return -1;
	}

	public int efficient(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			if (num == candidate) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = { 3, 2, 3 };
		// System.out.println(me.approach1(nums));
		// nums = new int[] { 3, 2, 3 };
		// System.out.println(me.approach2(nums));
		// nums = new int[] { 3, 2, 3 };
		// System.out.println(me.approach3(nums));
		// nums = new int[] { 3, 2, 3 };
		System.out.println(me.efficient(nums));
	}
}