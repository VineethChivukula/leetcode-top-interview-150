/*
 * Problem Statement:
 * The problem says that there is an array and initially we are at the first
 * index. The value at the ith index represents the maximum jump that we can
 * make from that index. We have to find out whether we can reach the last index
 * or not. Since maximum jump is given at each index, we can jump from that
 * index to the index upto the maximum jump. For example, the array is [2, 3, 1,
 * 1, 4]. We are at 2, so we can jump to 3 or 1. Let us say we jumped to 3. Now,
 * we can jump to 1, 1 or 4. So, we can reach the last index by choosing 4. If
 * we choose to jump to 1, we can jump to the next 1 only. When we reach next 1
 * we can jump to 4. So, we can reach the last index. There can be multiple ways
 * to reach the last index. We have to find out whether we can reach the last
 * index or not.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can greedily move
 * to the index where we can jump the maximum. So we will run a loop from 0 to
 * n. Inside the loop, we will first check if we are already at the last index.
 * If we are at the last index, then we can return true. If not, the current
 * element will be the maximum number of steps that we can take from the current
 * index. If the current position has a jump length of 0 and it's not the last
 * index, we will return false because we can't move further. Now, inorder to
 * see all possible jump positions within the maximum jump length, we will run a
 * loop from current position to the sum of the current position and maximum
 * jump length. Now, inside the loop, we will check if jumping to a position
 * guarantees that we can reach the last index or exceeds the last index. If it
 * satisfies, we will return true. Otherwise, we will find a better position to
 * jump. At any point, if the position is not changed, we will return false.
 * Otherwise, we will choose the best position to jump. If we exit both loops,
 * it means that we have reached the last index. So, we will return true.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are checking all possible jump
 * positions within the maximum jump length.
 * 
 * Efficient Approach:
 * Okay, so let us solve this problem by visualizing it like a game. Let us say
 * you are at the first index. Your score now is 0 + nums[0]. Assume that there
 * is a flag at that index value. For example, if the score is 2, then there is
 * a flag at second index of the array. Now, keep on traversing the array. At
 * any point, if you find an i such that i + nums[i] is greater than or equal to
 * flag, you are allowed to pick that and update the flag to that value. Hence,
 * in that way, you maximize your score and try reaching the last index. Now,
 * what happens if you exceed flag? well, you can't reach the last index and
 * hence game over. So, you return false.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

public class JumpGame {
	public boolean approach1(int[] nums) {
		int i = 0, n = nums.length;
		while (i < n) {
			if (i == n - 1) {
				return true;
			}

			int steps = nums[i];
			if (steps == 0 && i < n - 1) {
				return false;
			}

			int maxIndex = i;
			int maxStep = 0;
			for (int j = i + 1; j <= i + steps && j < n; j++) {
				if (j + nums[j] >= n - 1) {
					return true;
				}

				if (nums[j] + j >= maxStep + maxIndex) {
					maxStep = nums[j];
					maxIndex = j;
				}
			}

			if (maxIndex == i) {
				return false;
			}

			i = maxIndex;
		}

		return true;
	}

	public boolean efficient(int[] nums) {
		int n = nums.length, flag = 0;
		for (int i = 0; i < n; i++) {
			if (i > flag) {
				return false;
			}

			if (i + nums[i] >= flag) {
				flag = i + nums[i];
			}

			if (flag >= n - 1) {
				return true;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] nums = { 2, 3, 1, 1, 4 };
		// System.out.println(jg.approach1(nums));
		System.out.println(jg.efficient(nums));
	}
}