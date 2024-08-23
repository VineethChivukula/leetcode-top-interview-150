/*
 * Problem Statement:
 * Given an array of non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to trap after
 * raining. For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * Thought Process:
 * Approach 1:
 * We will have a generic approach in mind. So, let us assume there are three
 * bars, left bar, right bar and the middle bar. For now, let us assume that
 * the height of the left bar is more than the middle bar and the height of the
 * right bar is more than both the left and the middle bar. How much water do
 * you think can be trapped between the left, right and the middle bar? The
 * answer is pretty simple. The amount of water that can be trapped is equal to
 * the minimum of the height of the left and the right bar minus the height of
 * the middle bar. Why minimum? if not minimum, then the water will overflow
 * which we do not want. Hence, we take the minimum. So, the amount of water
 * that can be trapped between the left, right and the middle bar is equal to
 * min(left, right) - middle. You might have a question in mind. What if the
 * middle bar is the highest? or the heights are in ascending or descending
 * order?. In that case, we cannot trap any water. So, we will skip those cases,
 * simple. Now the question arises like what if there are more than three bars?
 * say 4 bars with the height of the bars as 5, 3, 2, 4. The complexity
 * increased because instead of one bar, we have two bars to be dealt with.
 * Here, we will assume there are only three bars. One time we will assume the
 * middle bar is 3, and the other time we will assume the middle bar is 2. We
 * then find out the total amount of water that can be trapped by adding the two
 * amounts. Nice, right? but there is a problem. There can be bars to the left
 * of the left bar and to the right of the right bar. So, we need to consider
 * all the bars. So, we will run a loop from 1 to n-2. Inside the loop, we will
 * run another loop from 0 to middle - 1 to find the maximum height of the
 * bars to the left of the current bar. We will run another loop from middle+1
 * to n to find the maximum height of the bars to the right of the current bar.
 * We are we finding the maximums to ensure we correctly identify the "walls"
 * that define the container for any water that can be trapped above the current
 * bar. We don't want to consider any water that would overflow the container.
 *
 * Time Complexity Analysis:
 * The Time Complexity for middle bars is O(n) since we are running a loop from
 * 1 to n-2.
 * The Time Complexity for left bars is O(n) since we are running a loop from 0
 * to middle-1.
 * The Time Complexity for right bars is O(n) since we are running a loop from
 * middle+1 to n.
 * The total Time Complexity is O(n^2).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Approach 2:
 * The second approach is similar to the above approach. But we will use two
 * arrays left and right to store the maximum height of the bars to the left and
 * right of the current bar. We run two loops to fill the left and right arrays.
 * We run another loop from 1 to n-2. Inside the loop, we will find the minimum
 * of the left[i] and right[i] and subtract the height of the current bar from
 * it. We will add the result to the total amount of water that can be trapped
 * and return it.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running three loops
 * separately.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using two arrays
 * left and right.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space.
 * 
 * Efficient Approach:
 * Instead of using two arrays left and right, we will use two variables
 * leftMax and rightMax. This time we won't use for loop, but rather while loop
 * by using left and right pointers. Left pointer will start from 0 and right
 * pointer will start from n-1. The purpose of leftMax and rightMax is to keep
 * track of the maximum height of the bars to the left and right of the current
 * bar. The purpose of left and right pointers is to keep track of the current
 * bar. Inside the while loop, if height[left] is less than height[right], then
 * we will check if height[left] is greater than leftMax. If it is, then we will
 * update leftMax. Otherwise, we will add leftMax - height[left] to the total
 * amount of water that can be trapped. We will increment left. If height[left]
 * is greater than height[right], then we will check if height[right] is greater
 * than rightMax. If it is, then we will update rightMax. Otherwise, we will add
 * rightMax - height[right] to the total amount of water that can be trapped. We
 * will decrement right. At last, we will return the total amount of water that
 * can be trapped.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running a while
 * loop.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

public class TrappingRainWater {
	public int approach1(int[] height) {
		int totalWaterTrapped = 0;
		int n = height.length;

		for (int middle = 1; middle < n - 1; middle++) {
			int leftMax = 0;
			for (int left = 0; left < middle; left++) {
				leftMax = Math.max(leftMax, height[left]);
			}

			int rightMax = 0;
			for (int right = middle + 1; right < n; right++) {
				rightMax = Math.max(rightMax, height[right]);
			}

			int waterAtMiddle = Math.min(leftMax, rightMax) - height[middle];

			if (waterAtMiddle > 0) {
				totalWaterTrapped += waterAtMiddle;
			}
		}

		return totalWaterTrapped;
	}

	public int approach2(int[] height) {
		int totalWaterTrapped = 0;
		int n = height.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}

		right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			int waterAtMiddle = Math.min(left[i], right[i]) - height[i];

			if (waterAtMiddle > 0) {
				totalWaterTrapped += waterAtMiddle;
			}
		}

		return totalWaterTrapped;
	}

	public int efficient(int[] height) {
		int totalWaterTrapped = 0;
		int n = height.length;
		int left = 0;
		int right = n - 1;
		int leftMax = 0;
		int rightMax = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > leftMax) {
					leftMax = height[left];
				} else {
					totalWaterTrapped += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] > rightMax) {
					rightMax = height[right];
				} else {
					totalWaterTrapped += rightMax - height[right];
				}
				right--;
			}
		}

		return totalWaterTrapped;
	}
}