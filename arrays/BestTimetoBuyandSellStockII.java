/*
 * Problem Statement:
 * The problem says that there is an array and we have to find the maximum
 * profit that we can make by buying and selling the stock. We can buy and sell
 * the stock multiple times. For example, if the given array is [7, 1, 5, 3, 6,
 * 4] then the maximum profit that we can make is 7. We can buy the stock at 1
 * and sell it at 5. Then we can buy the stock at 3 and sell it at 6. So, the
 * profit will be 5-1 + 6-3 = 7. If there is no profit, then we return 0.
 * 
 * Thought Process:
 * Efficient Approach:
 * Most of us will definitely think of the efficient approach due to the nature
 * of the problem. If the price of the stock is less than the next price, then
 * we can buy the stock at the current price and sell it at the next price. If
 * the price of the stock is more than the next price, we simply ignore that
 * stock. So, we will keep on adding the profit where the price of the stock is
 * less than the next price. In the end, we will get the maximum profit.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) because we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

public class BestTimetoBuyandSellStockII {
	public int efficient(int[] prices) {
		int maxProfit = 0, left = 0, right = 1;
		while (right < prices.length) {
			if (prices[right] > prices[left]) {
				maxProfit += prices[right] - prices[left];
			}
			left++;
			right++;
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStockII b = new BestTimetoBuyandSellStockII();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(b.efficient(prices));
	}
}