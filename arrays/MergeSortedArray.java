/*
 * Problem Statement:
 * The problem says that there are two sorted arrays and we have to
 * merge them into a single sorted array.
 * The size of the first array is m+n and the size of the second array is n.
 * The first array has m elements and the second array has n elements.
 * The first array has enough Space to accommodate all the elements of the
 * second array.
 * We have to merge the second array into the first array such that the first
 * array becomes a single sorted array.
 * For example, if the first array is [1, 3, 5, 0, 0, 0] and the second array is
 * [2, 4, 6], then the output should be [1, 2, 3, 4, 5, 6].
 * 
 * Thought Process::
 * Approach 1:
 * The first approach that should come to our mind is that we can merge the two
 * arrays by copying the elements of the second array into the first array and
 * then sorting the first array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of copying the elements of the second array into the
 * first array is O(n).
 * The Time Complexity of sorting the first array is O((m+n)log(m+n)).
 * So, the final Time Complexity of this approach is O((m+n)log(m+n)) since this
 * dominates O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra Space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are not using the fact that the
 * arrays are already sorted and after adding the elements of the second array
 * into the first array, we are sorting the first array which should be avoided
 * somehow.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can take two
 * pointers i and j. The pointers i and j will point to the first element of the
 * first and second arrays. We will compare the elements at the ith and jth
 * index. If the element at the ith index is smaller than or equal to the
 * element at the jth index, then we will increment the value of i by 1.
 * Otherwise, we need to shift all the elements of the first array by 1 to the
 * right starting from the ith index. Then we will copy the element at the jth
 * index into the ith index. Since we copied the element, we will mark the jth
 * index element as Integer.MIN_VALUE and increment i and j. You might have a
 * question to why we are marking the jth index element as Integer.MIN_VALUE.
 * The reason is because, once i reaches the end of the first array, we will
 * copy all the remaining elements of the second array into the first array by
 * traversing the second array from the end. Once we encounter
 * Integer.MIN_VALUE, it means that we have copied all the remaining elements of
 * the second array into the first array, so we will break the loop.
 * 
 * Time Complexity Analysis:
 * Since i and j are traversing the first and second arrays respectively, the
 * Time Complexity of the loop is O(m+n). Inside the loop, we are shifting the
 * elements of the first array by 1 to the right when we encounter an element in
 * the second array which is smaller than the element in the first array. The
 * Time Complexity of shifting the elements of the first array is O(m + n). So,
 * the total Time Complexity upto now is O((m+n)^2). We are also traversing the
 * second array from the end to copy the remaining elements of the second array
 * into the first array. The Time Complexity of this operation is O(n). So, the
 * final Time Complexity of this approach is O((m+n)^2) since this dominates
 * O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra Space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are shifting the elements of the
 * first array by 1 to the right when we encounter an element in the second
 * array which is smaller than the element in the first array. This is not an
 * efficient way to merge the two arrays.
 * 
 * Efficient Approach:
 * The idea that we took before is correct. But the approach that we took to
 * solve the problem is wrong. The efficient approach is that we will take three
 * pointers i, j, and k. i will point to the (m-1)th index of the first array, j
 * will point to the (n-1)th index of the second array, and k will point to the
 * (m+n-1)th index of the first array. We will compare the elements at the ith
 * and jth index. If the element at the ith index is greater than the element at
 * the jth index, then we will copy the element at the ith index into the kth
 * index and decrement the value of i and k by 1. We do this because, if the
 * element at the ith index is less than the element at the jth index, it means
 * that the element at jth index is the highest value of all elements. We came
 * to this conclusion because the arrays are sorted. Otherwise, we will copy the
 * element at the jth index into the kth index and decrement the value of j and
 * k by 1. We will repeat the above steps until i and j are greater than or
 * equal to 0. We will copy the remaining elements of the second array into the
 * first array if any elements are left in the second array.
 * 
 * Time Complexity Analysis:
 * Since i and j are traversing the first and second arrays respectively, the
 * Time Complexity of the loop is O(m+n). So, the final Time Complexity of this
 * approach is O(m+n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra Space.
 */

import java.util.Arrays;

public class MergeSortedArray {
	public void approach1(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		for (int i = m; i < nums1.length; i++) {
			nums1[i] = nums2[j];
		}

		Arrays.sort(nums1);
	}

	public void approach2(int[] nums1, int m, int[] nums2, int n) {
		int i = 0;
		int j = 0;

		while (i != nums1.length && j != nums2.length) {
			if (nums1[i] <= nums2[j]) {
				i++;
			} else {
				for (int k = nums2.length; k >= i; k--) {
					nums1[k + 1] = nums1[k];
				}
				nums1[i] = nums2[j];
				nums2[j] = Integer.MIN_VALUE;
				i++;
				j++;
			}
		}

		int f = nums1.length - 1;
		for (int k = nums2.length - 1; k >= 0; k--) {
			if (nums2[k] == Integer.MIN_VALUE) {
				break;
			} else {
				nums1[f] = nums2[k];
				f--;
			}
		}
	}

	public void efficient(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}
	}

	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;

		// mergeSortedArray.approach1(nums1, m, nums2, n);
		// System.out.println(Arrays.toString(nums1));

		// mergeSortedArray.approach2(nums1, m, nums2, n);
		// System.out.println(Arrays.toString(nums1));

		mergeSortedArray.efficient(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
}