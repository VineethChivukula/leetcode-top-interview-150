/*
 * Problem Statement:
 * The problem says that there is an array and we have to rotate the array to
 * the right by k steps. For example, if the array is [1, 2, 3, 4, 5, 6, 7] and
 * k is 3, then the array should be rotated to [5, 6, 7, 1, 2, 3, 4].
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can use an
 * array-list to store the elements of the array. Then, we can add the elements
 * from (n-k)th index to (n-1)th index and then add the elements from 0th index
 * to (n-k-1)th index. Finally, we copy the elements from the array-list to the
 * array. But, what if k is greater than or equal to n? In that case, we can
 * take the modulo of k before doing these operations. This ensures that the k
 * is always less than n.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of traversing the array and building the array-list is
 * O(n).
 * The Time Complexity of copying the elements from the array-list to the array
 * is O(n).
 * So, the final Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an
 * array-list.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using an array-list to store the
 * elements.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can store the
 * last element of the array in a temporary variable. Then, we can shift the
 * elements of the array to the right by one position. Finally, we can store the
 * temporary variable in the 0th index of the array. We can repeat this process
 * k times.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of shifting the elements of the array is O(n).
 * The Time Complexity of repeating this process k times is O(k).
 * So, the final Time Complexity of this approach is O(n*k).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are shifting the elements of the
 * array k times.
 * 
 * Efficient Approach:
 * Firse we reverse the array and then reverse the first k elements and then
 * reverse the last n-k elements. This will give us the desired result.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of reversing the array is O(n).
 * The Time Complexity of reversing the first k elements is O(k).
 * The Time Complexity of reversing the last n-k elements is O(n-k).
 * So, the final Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

import java.util.List;
import java.util.ArrayList;

public class RotateArray {
	public void approach1(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		List<Integer> list = new ArrayList<>();
		for (int i = n - k; i < n; i++) {
			list.add(nums[i]);
		}
		for (int i = 0; i < n - k; i++) {
			list.add(nums[i]);
		}
		for (int i = 0; i < n; i++) {
			nums[i] = list.get(i);
		}
	}

	public void approach2(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int rotate = k;

		while (rotate > 0) {
			int lastElement = nums[n - 1];
			for (int i = n - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = lastElement;
			rotate--;
		}
	}

	public void efficient(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		// ra.approach1(nums, k);
		// for (int num : nums) {
		// 	System.out.print(num + " ");
		// }
		// System.out.println();

		// nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// ra.approach2(nums, k);
		// for (int num : nums) {
		// 	System.out.print(num + " ");
		// }
		// System.out.println();

		// nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		ra.efficient(nums, k);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}