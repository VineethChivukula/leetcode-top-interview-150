/*
 * Problem Statement:
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i]. We are not allowed to use division. For example, given [1, 2, 3, 4],
 * return [24, 12, 8, 6].
 * 
 * Thought Process::
 * Approach 1:
 * The first approach that should come to our mind is that we can run two loops.
 * So, we will run a loop from 0 to n. Inside the loop, we will run another loop
 * from 0 to n. We will skip the current index in the inner loop. We will
 * multiply all the elements except the current element and store it in the
 * output array. We will return the output array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) since we are running two
 * loops.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an extra
 * array to store the output.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are running two loops.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can take three
 * arrays left, right and output. The left array will store the product of all
 * the elements to the left of the current element. The right array will store
 * the product of all the elements to the right of the current element. The
 * output array will store the product of all the elements except the current
 * element. We will run a loop from 0 to n. Inside the loop, we will store the
 * product of all the elements to the left of the current element in the left
 * array. We will run another loop from n-1 to 0. Inside the loop, we will store
 * the product of all the elements to the right of the current element in the
 * right array. We will run another loop from 0 to n. Inside the loop, we will
 * multiply the left[i] and right[i] and store it in the output array. We will
 * return the output array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running three loops
 * separately.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using three arrays
 * to store the left, right and output.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space.
 * 
 * Efficient Approach:
 * The approach is similar to the above approach. But we will use only output
 * array. We will run a loop from 0 to n. Inside the loop, we will store the
 * product of all the elements to the left of the current element in the output
 * array. We will run another loop from n-1 to 0. Inside the loop, we will
 * multiply the product of all the elements to the right of the current element
 * with the output array. We will return the output array.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running two loops
 * separately.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space other than the output array.
 */

public class ProductOfArrayExceptSelf {
	public int[] approach1(int[] nums) {
		int n = nums.length;
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {
			int product = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					product *= nums[j];
				}
			}
			output[i] = product;
		}
		return output;
	}

	public int[] approach2(int[] nums) {
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] output = new int[n];
		left[0] = 1;
		right[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < n; i++) {
			output[i] = left[i] * right[i];
		}
		return output;
	}

	public int[] efficient(int[] nums) {
		int n = nums.length;
		int[] output = new int[n];
		output[0] = 1;
		for (int i = 1; i < n; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			output[i] *= right;
			right *= nums[i];
		}
		return output;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
		int[] nums = { 1, 2, 3, 4 };
		int[] output;
		// output = poaes.approach1(nums);
		// for (int i = 0; i < output.length; i++) {
		// System.out.print(output[i] + " ");
		// }
		// System.out.println();
		// output = poaes.approach2(nums);
		// for (int i = 0; i < output.length; i++) {
		// System.out.print(output[i] + " ");
		// }
		// System.out.println();
		output = poaes.efficient(nums);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}