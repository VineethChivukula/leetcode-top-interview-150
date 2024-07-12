/*
 * Problem Statement:
 * The problem says that there is an array and an integer. We have to remove all
 * the occurrences of the integer from the array and return the length of the
 * array after removing the occurrences of the integer. We also need to modify
 * the array such that the elements can be any order as they were in the
 * original array. The remaining elements are not important. For example, if the
 * array is [3, 2, 2, 3] and the integer is 3, then the output should be 2 and
 * the array should be [2,2,_,_].
 * 
 * Thought Process::
 * Approach 1:
 * The first approach that should come to our mind is that we find out the
 * length of the array after removing the occurrences of the integer. We will
 * take a variable k and initialize it to 0. We will traverse the array and
 * if the element at the ith index is not equal to the integer, then we will
 * increment the value of k by 1. In this way we will get the length. Now
 * initialize another array of length k and copy the elements of the original
 * array which are not equal to the integer into the new array. Finally, we will
 * again traverse the original array and copy the elements of the new array into
 * the original array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of finding the length of the array is O(n).
 * The Time Complexity of copying the elements of the original array into the
 * new array is O(n).
 * The Time Complexity of copying the elements of the new array into the
 * original array is O(k).
 * So, the final Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(k) since we are using an extra
 * array of length k.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space and also we
 * are traversing the array multiple times. We are also not using the fact that
 * the remaining elements are not important.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can take two
 * pointers i and j. i will point to the first element of the array and j will
 * point to the last element of the array. We will traverse the array from the
 * start and if the element at the ith index is equal to the integer, then we
 * will swap the elements at the ith and jth index. We will decrement the value
 * of j by 1. We will keep on swapping the elements until i is less than or
 * equal to j. Finally, we will return the value of i.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra Space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using two pointers and swapping
 * the elements which is not required and we can use a single pointer to solve
 * the problem.
 * 
 * Efficient Approach:
 * The idea we took before is correct but we can optimize it. We can take a
 * single pointer i and initialize it to 0. We will also initialize n to array's
 * length. We will traverse the array and if the element at the ith index is
 * equal to the integer, then we will replace the element at the ith index with
 * the element at the (n-1)th index. We will decrement the value of n by 1. We
 * will repeat the above steps until i is less than n. Finally, we will return
 * the value of n. This approach is efficient because we are not swapping the
 * elements. We are just replacing the elements.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra Space.
 */

public class RemoveElement {
	public int approach1(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				k++;
			}
		}

		int[] arr = new int[k];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				arr[j] = nums[i];
				j++;
			}
		}

		for (int i = 0; i < k; i++) {
			nums[i] = arr[i];
		}

		return k;
	}

	public int approach2(int[] nums, int val) {
		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			if (nums[i] == val) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j--;
			} else {
				i++;
			}
		}

		return i;
	}

	public int efficient(int[] nums, int val) {
		int i = 0;
		int n = nums.length;

		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else {
				i++;
			}
		}

		return n;
	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;
		// System.out.println(re.approach1(nums, val));
		// nums = new int[] { 3, 2, 2, 3 };
		// System.out.println(re.approach2(nums, val));
		// nums = new int[] { 3, 2, 2, 3 };
		System.out.println(re.efficient(nums, val));
	}
}
