/*
 * Problem Statement:
 * The problem says that there is an array and we have to find the maximum
 * profit that we can make by buying and selling the stock. We can buy and sell
 * the stock only once. For example, if the given array is [7, 1, 5, 3, 6, 4]
 * then the maximum profit that we can make is 5. We can buy the stock at 1 and
 * sell it at 6. So, the profit will be 6-1 = 5. If there is no profit, then we
 * return 0.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can use two loops
 * to find out the maximum profit. The outer loop will traverse the array and
 * the inner loop will traverse the array from the next element of the outer
 * loop. We will find out the profit by subtracting the current element from the
 * next element. If the profit is greater than the maximum profit, then we will
 * update the maximum profit. In the end, we will return the maximum profit.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) because we are using two
 * loops.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using two loops to find out the
 * maximum profit.
 * 
 * Efficient Approach:
 * This approach is very simple. We will keep track of the lowest price of all
 * the stocks that we have seen so far. Why do we need to keep track of the
 * lowest price? Because we can buy the stock at the lowest price and sell it at
 * the highest price to get the maximum profit. At any point, if the difference
 * of prices is less than 0, it means that there is a price that is less than
 * the current lower price. So, we will update the lower price. If the
 * difference of prices is greater than the maximum profit, then we will update
 * the maximum profit.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) because we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

public class BestTimetoBuyandSellStock {
	public int approach1(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	public int efficient(int[] prices) {
		int maxProfit = 0, left = 0, right = 1;
		while (right < prices.length) {
			if (prices[right] - prices[left] < 0) {
				left = right;
			} else {
				maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
			}
			right++;
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStock btbss = new BestTimetoBuyandSellStock();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		// System.out.println(btbss.approach1(prices));
		System.out.println(btbss.efficient(prices));
	}
}