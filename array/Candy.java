/*
 * Problem Statement:
 * There are n children standing in a line. Each child is assigned a rating
 * value given in an integer array ratings. You are giving candies to these
 * children subjected to the following requirements:
 * Each child must have at least one candy.
 * A child with a higher rating gets more candies than their neighbors.
 * A child with a lower rating must get fewer candies than their neighbors.
 * A child with a rating equal to its neighbors gets the same number of candies
 * as them.
 * Return the minimum number of candies you need to have to distribute the
 * candies to the children.
 * 
 * Thought Process::
 * Approach 1:
 * First, we will initialize an array candies with all elements as 1 because
 * each child must have at least one candy. We will initialize a variable
 * changed to indicate whether the array candies is changed or not. We will run
 * a while loop until the array candies is not changed. Inside the loop, we will
 * set changed to false. We will run a loop from 0 to n-1. Inside the loop, we
 * will check if the current element is greater than the previous element and
 * candies[i] is less than or equal to candies[i-1]. If it is true, we will
 * increment candies[i] and set changed to true. We will also check if the
 * current element is greater than the next element and candies[i] is less than
 * or equal to candies[i+1]. If it is true, we will increment candies[i] and set
 * changed to true. We will return the sum of the array candies.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) since we are running a while
 * loop and a for loop inside it.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an extra
 * array candies.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are running a while loop and a for
 * loop inside it.
 * 
 * Efficient Approach:
 * This approach is similar to the above approach. But we will use two passes
 * left to right and right to left once to solve the problem. In the first pass,
 * if the current element is greater than the previous element, we will
 * increment the current element by 1. In the second pass, if the current
 * element is greater than the next element, we will increment the current
 * element by 1. We will return the sum of the array candies.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running two loops
 * separately.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an extra
 * array candies.
 */

public class Candy {
	public int approach1(int[] ratings) {
		int n = ratings.length;
		int[] candies = new int[n];
		for (int i = 0; i < n; i++) {
			candies[i] = 1;
		}
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < n; i++) {
				if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
					candies[i] = candies[i - 1] + 1;
					changed = true;
				}
				if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
					candies[i] = candies[i + 1] + 1;
					changed = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += candies[i];
		}
		return sum;
	}

	public int efficient(int[] ratings) {
		int n = ratings.length;
		int[] candies = new int[n];
		for (int i = 0; i < n; i++) {
			candies[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += candies[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Candy candy = new Candy();
		int[] ratings = { 1, 0, 2 };
		// System.out.println(candy.approach1(ratings));
		System.out.println(candy.efficient(ratings)); 
	}
}