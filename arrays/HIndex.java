/*
 * Problem Statement:
 * The problem says that there is an array and we have to find the H-Index of
 * the array. The H-Index is the maximum number h such that there are at least h
 * papers in the array that have h citations. For example, if the array is [3,
 * 0, 6, 1, 5] then the H-Index is 3. This is because there are 3 papers with at
 * least 3 citations. The papers with 3 citations are [3, 6, 5]. The remaining 2
 * papers have 0 and 1 citations. So, the H-Index is 3.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can run a loop
 * until we calculate the H-Index. We will keep track of the count of the papers
 * and check if the count is greater than or equal to the citations. If it is,
 * then we will return the count.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) because we are running a loop
 * again and again until we calculate the H-Index which could be n in the worst
 * case.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are traversing the array again and
 * again to calculate the H-Index.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can sort the
 * array and then run a loop to calculate the H-Index. The idea is that first we
 * set h to 1, ans to 0, and then we will traverse the array from the end. We
 * will check if the current paper has atleast h citations. If it has, then we
 * will increment h and ans. If it has not, then we will break the loop and
 * return ans. This logic works because if the current paper has atleast h
 * citations, then all the papers before it will also have atleast h citations.
 * Here 'before' means the papers that are on the right side of the current
 * paper when we are traversing from the end.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of sorting the array is O(nlogn).
 * The Time Complexity of finding the H-Index is O(n).
 * So, the final Time Complexity of this approach is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are sorting the array to find the
 * H-Index.
 * 
 * Efficient Approach:
 * The idea is very simple. We will create an array of size n+1 and initialize
 * it with 0. Let us call it as count array. This array will store the count of
 * the papers that have citations[i] citations. We will traverse the citations
 * array and increment the count array at the index citations[i]. If
 * citations[i] exceeds the length of the citations array, then we will
 * increment the count array at the last index. This is because the H-Index
 * cannot be greater than the length of the citations array. Now, we will
 * traverse the count array from the end and keep track of the sum of the count.
 * If the sum of the count is greater than or equal to the index, then we will
 * return the index. This is because the sum of the count is the number of
 * papers that have atleast index citations.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) because we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) because we are using an extra
 * array of size n+1.
 */

import java.util.Arrays;

public class HIndex {
	public int approach1(int[] citations) {
		int h = 1, ans = 0;
		while (true) {
			int count = 0;
			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= h) {
					count++;
				}
			}
			if (count >= h) {
				ans = h;
				h++;
			} else {
				break;
			}
		}

		return ans;
	}

	public int approach2(int[] citations) {
		Arrays.sort(citations);
		int h = 1, ans = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			if (citations[i] >= h) {
				h++;
				ans++;
			} else {
				break;
			}
		}

		return ans;
	}

	public int efficient(int[] citations) {
		int n = citations.length;
		int[] count = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n) {
				count[n]++;
			} else {
				count[citations[i]]++;
			}
		}

		int sum = 0;
		for (int i = n; i >= 0; i--) {
			sum += count[i];
			if (sum >= i) {
				return i;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		HIndex hIndex = new HIndex();
		int[] citations = { 3, 0, 6, 1, 5 };
		// System.out.println(hIndex.approach1(citations));
		// System.out.println(hIndex.approach2(citations));
		System.out.println(hIndex.efficient(citations));
	}
}